import { faAngleLeft, faCircleExclamation } from '@fortawesome/free-solid-svg-icons'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import React, { useEffect } from 'react'
import { useState } from 'react'
import { Link } from 'react-router-dom'
import { CardsBook } from '../book/CardsBook'
import style from './favorites.module.css'


const URL_API_FAVORITES =process.env.REACT_APP_API+"/user/api/v1/fav/"

const Favorites = ({user, userInfo}) => {
    const[favorites, setFavorites] = useState([])
    
    const userId = JSON.parse(localStorage.getItem("info")).id
    const jwt = JSON.parse(localStorage.getItem("user")).jwtToken
    console.log(jwt);
    

    useEffect(()=>{
        fetch(`${URL_API_FAVORITES}${userId}`,{
        headers: {
            'Content-Type': 'application/json',             
            'Authorization': 'Bearer '+ `${jwt}`               
            }
        })
        .then((resp) =>resp.json())
        .then((resp) =>{          
          setFavorites(resp)
        })        
      }, [])
      

  return (
    
    <div className={style.favContainer}>

        <div className={style.productHeader}>
                <div >
                    <h2>Mis Favoritos</h2>
                </div>      
                <span><Link to= {`/`}><FontAwesomeIcon icon={faAngleLeft}  className={style.backButton}/></Link></span>  
          </div>

      {(favorites.length>0 )&& 
      <>
      <h3 className={style.favTitle}>Tus alojamientos favoritos:</h3>
      <div className={style.containerCard}>
       { favorites.map( info => {

                            return(                                                     
                                   
                                   <CardsBook                                   
                                      city = {info.city}
                                      image= {info.image.slice(12,-1)}
                                      name={info.product}
                                      idProducto= {info.product_id}
                                      points={info.puntuation}
                                    />
                                  
                                    )}
                                    )
                                  }
                                  </div>   
            </>}
            {favorites.length<= 0 &&
                  <div className={style.noFav}>
                    <h3><FontAwesomeIcon  icon={faCircleExclamation} className={style.noFavIcon}/>Aún no has agregado favoritos</h3>
                    <Link to={`/`}><button>Ver alojamientos</button></Link>
                  </div>
                }
                    
    </div>
                           
  )
                    
}

export default Favorites