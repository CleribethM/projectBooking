import React from 'react'
import style from './productConfirmation.module.css'
import { Link } from 'react-router-dom';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faCircleCheck } from '@fortawesome/free-solid-svg-icons';

const ProductConfirmation = () => {
    return (
        <div className={style.confirmContainer}>
            <div className={style.confirmBox}>
                <FontAwesomeIcon icon={faCircleCheck} className={style.iconConf}/>
                <h2 className={style.greatingText}>¡Muchas gracias!</h2>
                <p className={style.confirmText}>El alojamiento se ha creado con exito</p>
                <Link to='/'> <button className={style.confirmButton}>ok </button></Link>
            </div>
        </div>
    
  )
}

export default ProductConfirmation