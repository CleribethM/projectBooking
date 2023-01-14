import { faLocationDot } from '@fortawesome/free-solid-svg-icons'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import React from 'react'
import { Link } from 'react-router-dom'
import { Feature } from '../features/Feature'
import Score from '../score/Score'
import StarRate from '../starsrate/StarRate'
import style from './cardsBook.module.css'

export const CardsBook = ({image, name, category, points, city, idProducto, endDate, startDate}) => {
  return (
    <>
    <div className={style.cardBookContainer}>
        <div className={style.image}>
            <img src={image} alt= {name}/>
      
        </div>
        <div className={style.sectionInfo}>
                <div className={style.infoCategory}>
                    <div className={style.recomendadoTitle}>

                    <div className={style.categoryss}>
                        <h3>{category} </h3>                           
                        <StarRate
                        points={points}/>
                    </div>
                    <div className={style.bookName}>
                    <h3>{name}</h3>
                    </div>
                    <div className={style.score}>
                        <span className={style.points}>{points}</span>
                       <Score
                       points={points}/>
                    </div>
                    </div>

                    {startDate&&<div className={style.bookDates}>
                        <span>Fecha de llegada: {startDate}</span>
                        <hr />
                        <span>Fecha de salida: {endDate}</span>
                    </div>}

                <div className={style.infoBook}>
                   
                    <p><FontAwesomeIcon icon={faLocationDot} className={style.locationIcon} /><span className={style.address}>{city}</span> <span className={style.text}>MOSTRAR EN EL MAPA</span></p>
                    
                </div>
                <div className={style.descrip}>
                    <Link to={`/product/${idProducto}`}><button className={style.botonRecomendado}> Ver Producto</button></Link> 
                </div>
            </div>
        </div>
    </div>
</> 
  )
}
