import React from 'react'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import {faFacebook, faLinkedinIn, faTwitter, faInstagram} from '@fortawesome/free-brands-svg-icons'
import style from './footer.module.css'

export const Footer = () => {
  return (
    
        <footer className={style.footer}>
          <p className={style.footerData}>2022 Digital Booking</p>        
          <div className={style.icons}>
          <span><FontAwesomeIcon icon={faFacebook} /></span>
          <span><FontAwesomeIcon icon={faLinkedinIn} /> </span>
          <span><FontAwesomeIcon icon={faTwitter} /> </span>
          <span><FontAwesomeIcon icon={faInstagram} /> </span>
        </div>
      </footer>
    
  )
}
