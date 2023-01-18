import { findIconDefinition } from '@fortawesome/fontawesome-svg-core'
import { faSnowflake } from '@fortawesome/free-regular-svg-icons'
import { faCar, faKitchenSet, faPaw, faPersonSwimming, faTv, faWifi } from '@fortawesome/free-solid-svg-icons'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import React, { useContext, useEffect } from 'react'
import { useState } from 'react'
import { ThemeContext } from '../../context/ContextCategoryCity'
import { Feature } from '../features/Feature'
import ProductConfirmation from '../productConfirmation/ProductConfirmation'
import style from './adminProduct.module.css'

const URL_API_CITY = process.env.REACT_APP_API+"/public/api/v1/cities/"
const URL_API_FEATURE = process.env.REACT_APP_API+"/public/api/v1/features/"
const URL_API_PRODUCT_CATEGORY =process.env.REACT_APP_API+"/public/api/v1/categories"
const URL_API_PRODUCT_CREATE =process.env.REACT_APP_API+"/admin/api/v1/products/"
const LOGIN_URL='/city'
export const AdminProduct = () => {
    const [title, setTitle] = useState()
    const {category} = useContext(ThemeContext); 
    const [cities, setCities] = useState([])   
    const [adress, setAddress] = useState('')
    const [features, setFeatures] = useState([])
    const [newFeature, setNewFeature] = useState([])   
    const [provFeature, setProvFeature] = useState({})  
    const [image, setImage] = useState({title:"Foto", url:''})
    const [images, setImages] = useState([])
    const [input, setInput] = useState('')    
    const [totalImages, setTotalImages] = useState(-1)
    const [confirmation, setConfirmacion] = useState(false) 
    const[errorBook, setErrorBook] = useState('')       
    const[newProduct, setNewProduct] = useState({
        punctuation:10,
       
    })
    const user = JSON.parse(localStorage.getItem("user")).jwtToken
    
        useEffect(()=>{    
            fetch(URL_API_CITY)
            .then((res) => res.json())
            .then((res) =>{
                let data = res;         
                setCities(data)
            });
            
        }, []) 
        
        useEffect(()=>{    
            fetch(URL_API_FEATURE)
            .then((res) => res.json())
            .then((res) =>{
                let data = res;         
                setFeatures(data)
            });
            
        }, []) 

        const handleClickFeature = (e)=>{
            e.preventDefault()              
            features.filter((val )=>{
                if(val.name === provFeature){             
                    //let arr= [val,...newFeature]    
                    let arr= [{id:val.id}, ...newFeature]   
                    let featureMap = arr.map(item=>{
                        return [item.id,item]
                    });
                    var featureMapArr = new Map(featureMap); // Pares de clave y valor
                    setNewFeature([...featureMapArr.values()]); // Conversión a un array    
                    setNewProduct({...newProduct, feature:[...featureMapArr.values()]})     
                                      
                }
            })  
        }
             
        const handleCity = (e) =>{        
            cities.filter((val )=>{ 
                if(val.name === e.target.value)  //setCityId(val.id)       
                setNewProduct({...newProduct, city_id:val.id})
            })
        }
           
         
        const handleCategory = (e) =>{         
            category.filter((val )=>{                                
                if(val.title === e.target.value)      
                setNewProduct({...newProduct, category_id:val.id})
            })
            
        }
               
        const handleNewImage = (e) =>{
            e.preventDefault()
            if(e.target.value.length>0){
            setInput(e.target.value)            
            setImage({...image, url:e.target.value})
            }
        }

     
   
        const handleImages = (e) =>{
            e.preventDefault()
            if((images.length<5) &&(image.url.length>0)) {
                setImages([ ...images, image])                
                setNewProduct({...newProduct, image:[ ...images, image]})
                setTotalImages(images.length)
                setInput('')
            }else{
                console.log('sin imagen');
            }
            setImage({...image, url:""})

        }
            console.log(newProduct);
     
    const registrar = async () =>{    
  
    await fetch(`${process.env.REACT_APP_API}/admin/api/v1/products/`, {
         method: "POST",
         body:
           JSON.stringify(
           newProduct
          )
         ,
         headers: {
             'Content-Type': 'application/json',             
             'Authorization': 'Bearer '+ `${user}`               
         }
    })
    .then((res) => res)
    .then((res) =>{
        console.log(res)
        if(res.status===201) {
            setConfirmacion(true)
        }
        else{
            setErrorBook('Lamentablemente el producto no ha podido crearse. Por favor intente más tarde')
        }
        
     })
    };
    
    const handleSubmit =(e) =>{        
        e.preventDefault(); 
        if(images.length===5) registrar()        
    }
          
    return (
        <div className={style.productAdminContainer}>
       {!confirmation&&     
       <>     
       <div className={style.apTitleContainer}>
            <h2 className={style.apTitle}>Crear propiedad</h2>
        </div>
        <div className={style.apFormContainer}>
         <form onSubmit={handleSubmit} className={style.formContainer}>
            <div className={style.apFormDisplay}>
                <div className={style.apDisplayLeft}>
                    <label htmlFor="name">Nombre de la propiedad</label>
                    <input className={style.apInputText} type="text" name="name" onChange={(e)=>setNewProduct({...newProduct, title:e.target.value, titleDescription:e.target.value})} value={title}/>
                    {/* <input className={style.apInputText} type="text" name="name" onChange={(e)=>setTitle(e.target.value)} value={title}/> */}
                </div>
                <div  className={style.apDisplayRight}>
                    <label htmlFor="categoryName">Categoría</label>
                    <select className={style.selectItem} input="text" required name='categoryName' 
                        onChange={handleCategory}>
                        <option className={style.optionItem} value="0" selected></option>
                        {category.map(item =>
                        <option className={style.optionItem} value={item.title}>{item.title}</option>   
                    )}
                </select>
                </div>
                <div className={style.apDisplayLeft}>
                    <label htmlFor="address">Dirección</label>
                    <input className={style.apInputText}  type="text" name="address"onChange={(target)=>setAddress(target.value)} value={adress}/>
                </div>
                <div className={style.apDisplayRight}>
                    <label htmlFor="city">Ciudad</label>  
                {/* <select className={style.selectItem} input="text" required name={city} id={city} value={city} onChange={(e)=>setCity(e.target.value)}> */}
                <select className={style.selectItem} input="text" required name="city"   onChange={handleCity}>
                    <option className={style.optionItem} value="0"  selected></option>
                     {cities.map(item =>
                        <option className={style.optionItem} value={item.name}>{item.name}</option>   
                        )}
                </select>              
                </div>
                <div className={style.apDisplayText}>
                    <label htmlFor="info">Descripción</label>
                    {/* <textarea maxlength="100" onChange={(target)=>setComment(target.value)} value={''}></textarea> */}
                    <textarea className={style.apTextArea} maxlength="100"  name="description" onChange={(e)=>setNewProduct({...newProduct, description: e.target.value})} value={newProduct.description}></textarea>
                </div>
            <div className= {style.apFeatureTitleContainer}>
                <h3 className={style.apFeatureTitle}>Agregar atributos</h3>  
            </div>
            <div className={style.apFormDisplayFeature}>
                <div className={style.apDisplayLeftFeature}>
                <label htmlFor="feature">Nombre </label>    
                           
                    <select className={style.selectItem} input="text" required name={''}  onChange={(e)=>setProvFeature(e.target.value)}  >
                        <option className={style.optionItem} value="0" selected></option>
                        {features.map(item =>
                        <option key={item.id} className={style.optionItem} value={item.name}>{item.name}</option>   
                    )}
                    </select>
                </div>               
                <div className={style.apIconButtonDisplay}>
                    <button className={style.apIconButton} onClick={handleClickFeature}>+</button>
                </div>
                <div className={style.apDisplayRightFeature} >
              
                {newFeature.map(item=>   
                                         
                        <span className={style.iconSpan}><FontAwesomeIcon icon=
                          {item.id===7?faWifi:
                          item.id===6?faPersonSwimming:
                          item.id===5?faSnowflake:
                          item.id===2?faKitchenSet:
                          item.id===4?faPaw:
                          item.id===1?faTv:
                          faCar
                          }
                        /> 
                        </span>
                        
                        
                    )}
                </div>
            </div>                 
            <div className= {style.apFeatureTitleContainer}>
                <h3 className={style.apFeatureTitle}>Políticas del producto</h3>
            </div>
            <div className={style.apFormDisplayPol}>              
                <div className={style.apDisplayTextPolLeft}>
                <h4 className={style.apPolText}>Normas de la casa</h4>
                    <label htmlFor="info">Descripción</label>
                    {/* <textarea maxlength="100" onChange={(target)=>setComment(target.value)} value={''}></textarea> */}
                    <textarea className={style.apTextAreaPol} maxlength="200" name='houseRules' onChange={(e)=>setNewProduct({...newProduct, houseRules:e.target.value})} value={newProduct.houseRules}></textarea>
                </div>
                <div className={style.apDisplayTextPolCenter}>
                <h4 className={style.apPolText}>Salud y seguridad</h4>
                    <label htmlFor="info">Descripción</label>
                    {/* <textarea maxlength="100" onChange={(target)=>setComment(target.value)} value={''}></textarea> */}
                    <textarea className={style.apTextAreaPol} maxlength="200"  name='healthAndSafety' onChange={(e)=>setNewProduct({...newProduct, healthAndSafety:e.target.value})} value={newProduct.healthAndSafety}></textarea>
                </div>
                <div className={style.apDisplayTextPolRight}>
                    <h4 className={style.apPolText}>Políticas de cancelación</h4>
                        <label htmlFor="info">Descripción</label>
                        {/* <textarea maxlength="100" onChange={(target)=>setComment(target.value)} value={''}></textarea> */}
                        <textarea className={style.apTextAreaPol} maxlength="200"  name='cancellationPolicies' onChange={(e)=>setNewProduct({...newProduct, cancellationPolicies:e.target.value})} value={newProduct.cancellationPolicies}></textarea>
                </div>
            </div>
            <div className= {style.apFeatureTitleContainer}>
                <h3 className={style.apFeatureTitle}>Crear imágenes</h3>
            </div>
            <div className={style.apFormDisplayImage}>
                <div className={style.apDisplayLeftImage}>                    
                    {/* <input className={style.apInputText} type="text" name="image"  onChange={(e)=>setImage({...image, url:e.target.value})} value={image.url}/> */}
                    <input className={style.apInputText}  type="text" name="image" value={input} onChange={handleNewImage}/>
                </div>                
                <div className={style.apIconButtonDisplay}>
                    {/* <button className={style.apIconButton}  onClick={()=>setImages([image, ...images])}>+</button> */}
                    <button className={style.apIconButton}  onClick={handleImages}>+</button>
                </div>
            </div>
                    <p className={style.imageText}>*imagenes faltantes {4 - totalImages}</p>
        </div>       
            <button className={style.formButton}>Crear</button>
        </form>
    </div>
    </>}
    {confirmation&&
    <ProductConfirmation
    />
   }
    </div>
    

   

  )
}


               
                   
               
   
                                      
        
    
 
   
   
