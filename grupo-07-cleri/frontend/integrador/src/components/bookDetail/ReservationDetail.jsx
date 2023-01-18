import { faAngleLeft, faCircleExclamation, faLocationDot } from '@fortawesome/free-solid-svg-icons'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import React, { useContext, useEffect, useState } from 'react'
import { Link } from 'react-router-dom'
import { ThemeContext } from '../../context/ContextCategoryCity'
import Spinner from '../spinner/Spiner'
import StarRate from '../starsrate/StarRate'
import style from './reservationDetail.module.css'



export const ReservationDetail = ({category, name, points, direction, image, dateRange, handleSubmit, error, currentUser, post}) => {
   

    const startDate= dateRange[0].startDate.toDateString().split(' ');
    const endDate= dateRange[0].endDate.toDateString().split(' ');
    

      return (
   
            <div className={style.containerReserve}>
                    <h2>Detalle de la reserva</h2>
                <div className={style.descriptionReserve}>
                    <div className={style.img}>
                      <img src={image} alt={name} />  
                    </div>
                    <div className={style.descriptionText}>
                        <div className={style.divCategory}>
                            <span className={style.category}>{category.title}</span>
                            <h2 className={style.name}>{name}</h2>
                            <StarRate points={points}/>
                        </div>

                       <div className={style.direction}>
                            <span><span className={style.iconDirection}><FontAwesomeIcon icon={faLocationDot}/></span>{`${direction.name}, ${direction.location},  ${direction.country}`}</span>
                        </div>

                        <hr />

                        <div className={style.check}>
                            <span>Check in: {startDate[1]+' '+startDate[2]+' '+startDate[3]}</span>
                        </div>

                        <hr />

                        <div className={style.check}>
                            <span>Check out: {endDate[1]+' '+endDate[2]+' '+endDate[3]}</span>
                        </div>
                        <hr />
                        <div >
                        {!currentUser&& 
                        <p className={style.loginBook}> <FontAwesomeIcon  icon={faCircleExclamation}/>   Para realizar una reserva necesita estar logueado</p>  }
                            {error && <p className={style.errorBook}> <FontAwesomeIcon  icon={faCircleExclamation}/>{error}</p>}
                       {post? <Spinner/>: <button className={style.buttonReserve}  onClick={handleSubmit}>Confirmar reserva</button> 
                       }
                        </div>
                    </div>
                </div>
            </div>
       
  )
}
