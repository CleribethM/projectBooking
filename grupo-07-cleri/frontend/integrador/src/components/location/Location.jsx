import React from 'react'
import style from './location.module.css'

const Location = ({city}) => {
  return (
    <div className={style.location}>
        <h2 className={style.title}>¿Donde vas a estar?</h2>
        <p className={style.city}>{city}</p>
        <div className={style.map}>

        </div>
    </div>
  )
}

export default Location