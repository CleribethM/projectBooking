import React from 'react'
import style from './termsconditions.module.css'

const Termsconditions = ({policy, security, cancelTerms}) => {
    
  return (
    <>
      {(policy&&security&&cancelTerms)&&
    <div className={style.termsContainer}>
    <h2 className={style.title}>¿Que tenés que saber?</h2>
       <div className={style.terms}>
        <div  className={style.policy}>
            <h4 className={style.subtitle}>Normas de la casa</h4>
            {policy.split('.').map(item =>
                <p className={style.items}>{item}</p>
                )}

        </div>
        <div  className={style.security}>
            <h4 className={style.subtitle}>Salud y seguridad</h4>
            {security.split('.').map(item =>
                <p className={style.items}>{item}</p>
                )}
 

        </div>
        <div  className={style.conditions}>
            <h4 className={style.subtitle}>Política de cancelación</h4>
            {cancelTerms.split('.').map(item =>
                <p className={style.items}>{item}</p>
                )}

        </div>

       </div>
    </div>
}
</>
  )
}

export default Termsconditions