import { faAngleLeft } from '@fortawesome/free-solid-svg-icons'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import React from 'react'
import { useState } from 'react'
import { Link } from 'react-router-dom'
import style from './admin.module.css'
import { AdminProduct } from './AdminProduct'
import { AdminUser } from './AdminUser'

const Admin = ({currentUserRole}) => {
    const[render, setRender] = useState('Product')
    const userRole = localStorage.getItem("role")
    

  return (
    <>    {userRole==='ROLE_ADMIN'?
        <div className={style.adminContainer}>
            <div className={style.adminHeader}>
         <div>
            <h2>Administracion</h2>      
        </div>
         <span><Link to= {`/`}><FontAwesomeIcon icon={faAngleLeft} /></Link></span>    
        </div> 
        {/* <div className={style.subNav}>
            <button onClick = {()=>setRender('Product')} className={style.adminButton}>Producto</button>
            <button onClick = {()=>setRender('User')} className={style.adminButton}>Ciudad</button>
            <button onClick = {()=>setRender('Book')}  className={style.adminButton}>Categría</button>
            <button onClick = {()=>setRender('City')} className={style.adminButton}>Atributo</button>
  </div> */}
            {render==='Product' && 
                <AdminProduct/>
            }
    
            {render==='User' && 
                <AdminUser/>
            }
    
    
           
        </div>:
        <div className={style.adminContainer}>
            <h2 className={style.adminForbbiden}>Acceso restringido</h2>
        </div>
        
    }
    </>

  )
}

export default Admin