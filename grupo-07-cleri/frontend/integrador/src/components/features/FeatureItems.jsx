import React from 'react'
import style from './featuresProduct.module.css'
import { faSnowflake } from '@fortawesome/free-regular-svg-icons';
import { faTv, faWifi, faPaw, faCar, faPersonSwimming, faKitchenSet } from '@fortawesome/free-solid-svg-icons';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { te } from 'date-fns/locale';

const FeatureItems = ({feature, text}) => {
  
    
    function validateFeature (name){
        switch (name) {
            case 'Cocina':
                return(
                    <div className={style.feature}>
                        <span key={1} className={style.nameFeature}> 
                            <span className={text?style.iconFeature:style.iconCard}><FontAwesomeIcon icon={faKitchenSet}/></span> 
                               {text?name:""} 
                        </span>
                    </div>
                ) 
                                
            case 'Televisor':
                
                return(
                    <div  className={style.feature}>
                        <span key={2} className={style.nameFeature}> 
                            <span className={text?style.iconFeature:style.iconCard}><FontAwesomeIcon icon={faTv}/></span> 
                            {text?name:""} 
                        </span>
                    </div>
                )                
            case 'Aire acondicionado':
                return(
                    <div  className={style.feature}>
                        <span key={3} className={style.nameFeature}> 
                            <span className={text?style.iconFeature:style.iconCard}><FontAwesomeIcon icon={faSnowflake}/></span> 
                            {text?name:""} 
                        </span>
                    </div>
                )                
            case 'Apto mascotas':
             
                return(
                    <div className={style.feature}>
                        <span key={4} className={style.nameFeature}> 
                            <span className={text?style.iconFeature:style.iconCard}><FontAwesomeIcon icon={faPaw}/></span> 
                            {text?name:""} 
                        </span>
                    </div>
                )                
            case 'Estacionamiento gratuito':
            
                return(
                    <div className={style.feature}>
                        <span key={5}  className={style.nameFeature}> 
                            <span className={text?style.iconFeature:style.iconCard}><FontAwesomeIcon icon={faCar}/></span> 
                            {text?name:""} 
                        </span>
                    </div>
                )                
            case 'Pileta':
                return(
                    <div className={style.feature}>
                        <span key={6} className={style.nameFeature}> 
                            <span className={text?style.iconFeature:style.iconCard}><FontAwesomeIcon icon={faPersonSwimming}/></span> 
                            {text?name:""} 
                        </span>
                    </div>
                )            
            case 'Wifi':
                
                return(
                    <div className={style.feature}>
                        <span key={7} className={style.nameFeature}> 
                            <span className={text?style.iconFeature:style.iconCard}><FontAwesomeIcon icon={faWifi}/></span> 
                            {text?name:""} 
                        </span>
                    </div>
                )          
        
            default:
                break;
        }
    }


  return (
    <>
    {validateFeature(feature)}
    </>
   
  )
}

export default FeatureItems