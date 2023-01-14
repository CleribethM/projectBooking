import React, { useEffect } from 'react'
import { useState } from 'react'
import { useNavigate, useLocation } from "react-router-dom"
import style from './searchItems.module.css'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import {faLocationDot, faWifi, faPersonSwimming, faHeart} from '@fortawesome/free-solid-svg-icons'
import StarRate from "../starsrate/StarRate"
import Score from '../score/Score'
import { Feature } from '../features/Feature'

const PRODUCT_URL='/product'
const SearchItemsByDate = ({cities,image, product, key,category}) => {
    const [cityLocation, setCityLocation] = useState({})
    const navigate = useNavigate()

    useEffect(()=>{ 
    cities.filter((val)=>{                             
        if(val.id == product.city_id){                          
            setCityLocation(val)
        }
        })
    },[])
    


  return (
  <div  key ={key} className={style.recomendado}>
    <div className={style.favorito}>
        <img src={image} alt= {product.name}/>
       
    </div>

    <div className={style.sectionInfo}>
        <div className={style.infoCategory}>
            <div className={style.recomendadoTitle}>
                <div className={style.categoryss}>
                    <p>{category==1?"Hotel":category==2?"Hostel":category==3?"Departamentos":"Bed and Breakfast"} </p>
                    <StarRate
                    points={product.punctuation}/>
                </div>
                    <h3 className={style.nombreRecomendado}>{product.title}</h3>                           
                {/* <div className={style.nombreRecomendado}>
                    <h3 className={style.nombreRecomendadoTitle}>{product.name}</h3>
                </div> */}
                <div className={style.score}>
                    <span className={style.points}>{product.punctuation}</span>
                    <Score 
                    points={product.punctuation}/>
                </div>
            </div>

            <div className={style.infoRecomendado}>          
               
                <p><FontAwesomeIcon icon={faLocationDot} /><span className={style.location}>{`${cityLocation.name}, ${cityLocation.location},  ${cityLocation.country}`}</span> <span>MOSTRAR EN EL MAPA</span></p>
                 <div className={style.featureDisplay}>
                            <Feature                                 
                                feature = {product.feature}
                                text={false}
                              />
                            </div>  
                
            </div>

            <div className={style.descrip}>
                <p className={style.descriptionText}>{product.description.substr(0,120)} <span className={style.descriptionTextSpan}>más...</span></p>      
                <button className={style.botonRecomendado} onClick={()=>navigate(`${PRODUCT_URL}/${product.id}`)}> ver más</button>
            </div>
        </div>
    </div>
</div>

  )
}

export default SearchItemsByDate