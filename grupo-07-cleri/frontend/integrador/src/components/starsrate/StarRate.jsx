import React from 'react'
import style from './starRate.module.css'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import {faStar, faStarHalf} from '@fortawesome/free-solid-svg-icons'

const StarRate = ({points}) => {
  return (
    <>
    {points && <div className={style.starsContainer}>
                {points%2===0? [...Array((points/2))].map((star) => {        
                    return (
                                              
                        < FontAwesomeIcon icon={faStar} className={style.star}/>
                                
                
                    );
                    }):
                [...Array(((points -1)/2))].map((star) => {        
                    return (         
                        <>
                        <FontAwesomeIcon icon={faStar} className={style.star}/>
                        </>
                    )   
                    })    
                }
            {points%2!==0&&
                <FontAwesomeIcon icon={faStarHalf} className={style.star}/> 
            }    
            </div>
        }
        </>
  )
}

export default StarRate;