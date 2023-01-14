import React from 'react'
import FeatureItems from './FeatureItems';
import style from './featuresProduct.module.css'

export const Feature = ({feature, text}) => {

   
  return (
    // <div className={style.containerFeature}>
    //     <div>
    //        <h2 className={style.title}>¿Qué ofrece este lugar?</h2>
    //      </div>
    //     <div className={style.block}>
   <>     
            {
                feature.map(item =>
                <FeatureItems
                feature = {item.name}
                text={text}
                key={item.name}
                />    )
            }
            </>
    //     </div>

    // </div>
  )
}

