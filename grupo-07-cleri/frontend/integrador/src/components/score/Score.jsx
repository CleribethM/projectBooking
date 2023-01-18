import React from 'react'
import StarRate from '../starsrate/StarRate'
import style from './score.module.css'

const Score = ({points}) => {

    

  return (
    
        <span className={style.rating}>{points<=4?"Malo": points<=6? "Regular": points<=7? "Bueno": points <=8? "Muy bueno": "Excelente"}</span>
           
  )
}

export default Score