import { useState, useEffect, useContext } from "react"
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import {faStar, faLocationDot, faWifi, faPersonSwimming, faHeart} from '@fortawesome/free-solid-svg-icons'
import style from './recomendado.module.css'
import { useNavigate } from "react-router-dom"
import StarRate from "../starsrate/StarRate"
import Product from "./Product"
import { Link } from "react-router-dom"
import Score from "../score/Score"
import { Feature } from "../features/Feature"
import { ThemeContext } from "../../context/ContextCategoryCity"

const PRODUCT_URL='/product'
const URL_API_CITY = process.env.REACT_APP_API+"/public/api/v1/cities/"
const URL_API_FAVORITES =process.env.REACT_APP_API+"/user/api/v1/fav/"

export default function Recomendado({nombre, url, category, direction,points, descripcion, id, feature}) {
    const navigate = useNavigate()
    // const [cities, setCities] = useState([])
    const [city, setCity] = useState({})
    const {cityApi} = useContext(ThemeContext); 
    


    useEffect(()=>{
        cityApi.filter((val)=>{               
            if(val.id === direction){
                setCity(val)
            }
         })
    },[cityApi])
     

    return (
        <>
            <div className={style.recomendado}>
                <div className={style.favorito}>
                    <img src={url} alt= {nombre}/>
               
                </div>

                <div className={style.sectionInfo}>
                        <div className={style.infoCategory}>
                            <div className={style.recomendadoTitle}>

                            <div className={style.categoryss}>
                                <h3>{category==1?"Hotel":category==2?"Hostel":category==3?"Departamentos":"Bed and Breakfast"} </h3>                           
                                <StarRate
                                points={points}/>
                            </div>
                            <div className={style.nombreRecomendado}>
                            <h3>{nombre}</h3>
                            </div>
                            <div className={style.score}>
                                <span className={style.points}>{points}</span>
                               <Score
                               points={points}/>
                            </div>
                            </div>
        
                        <div className={style.infoRecomendado}>
                           
                            {city.name &&<p><FontAwesomeIcon icon={faLocationDot} /><span className={style.address}>{`${city.name}, ${city.location},  ${city.country}`}</span> <span className={style.text}>MOSTRAR EN EL MAPA</span></p>}
                          
                        
                            <div className={style.featureDisplay}>
                            <Feature                                 
                                feature = {feature}
                                text={false}/>
                            </div>    
                        </div>
                        <div className={style.descrip}>
                        <p>{descripcion.substr(0,120)} <span className={style.text}>más...</span></p>      
                        {/* <button className={style.botonRecomendado} onClick={()=>navigate(`${PRODUCT_URL}/${id}`)}> ver más</button> */}
                        <Link to={`/product/${id}`}><button className={style.botonRecomendado}> ver más</button></Link>
                       
                    </div>
                    </div>
                </div>
            </div>
        </>

        
  )
}



