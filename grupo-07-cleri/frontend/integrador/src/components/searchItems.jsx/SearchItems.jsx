import React, { useContext } from 'react'
import { useState } from 'react'
import { useEffect } from 'react'
import { useParams } from 'react-router-dom'
import style from './searchItems.module.css'
import { useNavigate, useLocation } from "react-router-dom"
import { Search } from '../search/Search'
import { ThemeContext } from '../../context/ContextCategoryCity'
import SearchItemsByDate from './SearchItemsByDate'

const URL_API_PRODUCT_CITY = process.env.REACT_APP_API+"/public/api/v1/cities/"
const PRODUCT_URL='/product'
const URL_API_CITY = process.env.REACT_APP_API+"/public/api/v1/cities/"
const URL_API_PRODUCT =process.env.REACT_APP_API+"/public/api/v1/products"
const URL_API_PRODUCT_DATE =process.env.REACT_APP_API+`/public/api/v1/products/available?startDate`
const URL_API_PRODUCT_CITY_DATE =process.env.REACT_APP_API+`/public/api/v1/products/available2?cityId=`

const SearchItems = () => {
    const navigate = useNavigate()
    const location = useLocation()
    const[status, setStatus] =useState()
    const {city}= useParams()   
    const [info, setInfo] = useState([])
    const [cityName, setCityName] = useState()    
    const {cityApi} = useContext(ThemeContext) 
      
    const datesRange = location.search.split('?')    
    const startDate = datesRange[1]
    const endDate = datesRange[2]   
        
    console.log(location);
    useEffect(()=>{
        setStatus(location.state)
    },[])

    useEffect(()=>{ 
        let newStatus = location.state
        setStatus(newStatus)
        if(location.state==='date'){
             fetch(`${URL_API_PRODUCT_DATE}=${startDate}&endDate=${endDate}`)
             .then((res) => res.json())
             .then((res) =>{
                console.log("info es de fechas"+res);
                setInfo(res.products);    
              
             }); 
         }else if(location.state==='city'){
         fetch(URL_API_PRODUCT_CITY+city)
         .then((res) => res.json())
         .then((res) =>{
             console.log("info es de ciudades"+res);    
            setInfo(res.product);
            setCityName(res.name)
           
         });
          } else if(location.state==='cityDate'){            
            fetch(`${URL_API_PRODUCT_CITY_DATE}${city}&startDate=${startDate}&endDate=${endDate}`)
            .then((res) => res.json())
            .then((res) =>{
                console.log("info es de fecha  ciudades"+res);       
                setInfo(res.products);
               
             
            });
          }else if(location.state==='cityDateAll'){
            fetch(`${process.env.REACT_APP_API}/public/api/v1/products`)
            .then((res) => res.json())
            .then((res) =>{
                console.log("info es de TODO"+res);        
                setInfo(res);
               
             
            });
        }
        
    }, [location])


   
            

    return (  

        <>        
            <Search/>
            <>
            {((status==='city')&&(info.length>0))&& 
            <section className={style.itemsContainer}>          
                    <h2>Hospedajes en {cityName}</h2>
                <div className={style.containerRecomendaciones}>
                    {
                      info.map( product => {
                        return(
                            <SearchItemsByDate
                                key={product.id}
                                cities={ cityApi.filter((val)=>{                             
                                    if(val.id == product.city_id) return val
                                    })}
                                image = {product.image[0].url}
                                product= {product}
                                category ={product.category_id}    
                            />
                        )}
                    )}
                </div>
            </section>
            }
           </>
           <>
            {((info.length===0) && (status==='city')) &&
            <div className={style.itemsContainer}>
                <h2>No se encontraron alojamientos en la ciudad seleccionada</h2>
            </div>    
            }
            </>
            <>
             {((info.length>0) && (status==='date'))&& 
                <section className={style.itemsContainer}>          
                <h2>Hospedajes disponibles entre {startDate} y {endDate}</h2>
                <div className={style.containerRecomendaciones}>
                {
                  info.map( product => {               
                    
                    return(
                        <SearchItemsByDate
                        key={product.id}
                        cities={ cityApi.filter((val)=>{                             
                            if(val.id == product.city_id) return val
                            })}
                        image = {product.image[0].url}
                        product= {product}
                        category ={product.category_id}

                        />
                )}
            )}
            </div>
        </section>
            } 
            </> 
            <>
            {((info.length===0) && (status==='date')) &&
            <div className={style.itemsContainer}>
                <h2>No se encontraron alojamientos en las fechas seleccionadas</h2>
            </div>    
            }
            </>
            <>
            {((status==='cityDate')&&(info.length>0))&& 
            <section className={style.itemsContainer}>          
                    <h2>Hospedajes disponibles </h2>
                <div className={style.containerRecomendaciones}>
                {
                      info.map( product => {

                        return(
                            <SearchItemsByDate
                            key={product.id}
                            cities={ cityApi.filter((val)=>{                             
                                if(val.id == product.city_id) return val
                                })}
                            image = {product.image[0].url}
                            product= {product}
                            category ={product.category_id}
                            />
                  
                    )}
                )}                   
                </div>
            </section>
            }
            </>
            <>
            {((info.length===0) && (status==='cityDate')) &&
            <div className={style.itemsContainer}>
                <h2>No se encontraron alojamientos para las fechas y ciudad seleccionada</h2>
            </div>    
            }
            </>
            <>
             {((info.length>0) && (status==='cityDateAll'))&& 
                <section className={style.itemsContainer}>          
                <h2>Todos los hospedajes disponibles</h2>
                <div className={style.containerRecomendaciones}>
                {
                  info.map( product => {
                    return(
                        <SearchItemsByDate
                        key={product.id}
                        cities={ cityApi.filter((val)=>{                             
                            if(val.id == product.city_id) return val
                            })}
                        image = {product.image[0].url}
                        product= {product}
                        category ={product.category_id}
                    />
                    )}
                )}
            </div>
        </section>
            } 
            </> 
        </>
       
      ) 
}

        

                       

export default SearchItems