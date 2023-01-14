import React, {useState, useEffect } from 'react'
import { Link, useParams, useLocation, useNavigate } from 'react-router-dom'
import style from './header.module.css'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faAngleDown, faArrowCircleLeft, faBars, faBellConcierge, faClipboardUser, faHotel } from '@fortawesome/free-solid-svg-icons'
import {faFacebook, faLinkedinIn, faTwitter, faInstagram, faAccessibleIcon} from '@fortawesome/free-brands-svg-icons'
import authService from '../../service/AuthService'
import { faHeart } from '@fortawesome/free-regular-svg-icons'


export const Header = (props) => {
  
    const navigate = useNavigate()   
    const currentUser = props.currentUser;
    const info = props.info;
    const role = props.role;
    const location = useLocation();
    
    const[mobile, setMobile] = useState();                                                                                                                                                                                                              
    const [width, setWidth] = useState(window.innerWidth)
    const [open, setOpen] = useState(false);
    const [list, setList] = useState(false);

    

    const updateWindowDimensions = () => {
        const newWidth = window.innerWidth;
        setWidth(newWidth);
    };

   

    useEffect(() => {
        window.addEventListener('onclick', updateWindowDimensions);
        width>420? setMobile(false): setMobile(true)
       
    }, [width]);
    
    window.addEventListener("resize", function() {
        if (window.matchMedia("(min-width:460px)").matches) {
            setMobile(false)
        } else {
            setMobile(true)
        }
    })

    const handleOpen= ()=>{
        setOpen(false)
    }

    const handleLogOut = () =>{
        props.logOut()
        navigate('/')
       
    }

    
    return (
            <>                
            {(!mobile)&&
                <header className={style.header}>                    
                    <>
                    <div className={style.logo}>
                       <Link to='/' className={style.logoImg}><p></p></Link>
                        </div>
                        <>
                        {role==='ROLE_ADMIN'?
                        
                        <Link to='/admin'className={style.admin}><p >Administración</p> </Link>:<></>}
                        </>
                        {(currentUser)&&
                        <>
                            <div className={style.userInfoContainer}>
                                <p onClick={handleLogOut} className={style.userCross}>x</p> 
                              
                                <div className={style.userLoginInfo}>
                                 
                                    <div className={style.userAvatar}>
                                        
                                        {Object.entries(info).length>0? <span>{`${info.name.charAt(0).toUpperCase()} ${info.lastName.charAt(0).toUpperCase()}`}</span>:<></>}
                                    </div>
                                    <div className={style.userInfo}>
                                        <p>Hola, </p>
                                        {/* <p className={style.userName}>{`${userData.user.name} ${userData.user.lastName}`} </p> */}
                                        {Object.entries(info).length>0? <span onClick={()=>setList(!list)} className={style.userName}>{info.name} {info.lastName} {role==='ROLE_USER'&&<FontAwesomeIcon icon={faAngleDown} />}</span> :<></>}
                                        
                                    </div>
                                    
                                        {(list && role==='ROLE_USER')&&
                                    <div className={style.list}>
                                        <ul className={style.ulList}>
                                            <li className={style.userOptions} onClick={() => setList(false)}> <Link to='/books'><p><FontAwesomeIcon icon={faBellConcierge}/>   Reservas</p></Link></li>
                                            <li className={style.userOptions} onClick={() => setList(false)}> <Link to='/fav'>  <p ><FontAwesomeIcon icon={faHeart}/>   Favoritos</p></Link></li>
                                            <li className={style.userOptions} onClick={() => setList(false)}> <p onClick={handleLogOut}> <FontAwesomeIcon icon={faArrowCircleLeft}/>   Cerrar sesión</p></li>
                                        </ul>
                                    </div>
                                        }
                                </div>
                                {/* } */}
                            </div>  

                                           
                        </>
                        }
                        {(!currentUser)&&
                            <>
                                <div className={style.botonesHeader}>
                                    {location.pathname==='/register'?
                                    <button className={style.hiddenButton}>Crear cuenta</button>:location.pathname==='/login'?
                                    <button className={style.hiddenButton}>Iniciar sesión</button>:
                                    <Link to='/register'><button className={style.boton1}>Crear cuenta</button></Link>
                                    }
                                    {location.pathname==='/register'?<Link to='/login'> <button>Iniciar sesión</button></Link>:
                                    location.pathname==='/login' ?<Link to='/register'><button className={style.boton1}>Crear cuenta</button></Link>:
                                    <Link to='/login'> <button>Iniciar sesión</button></Link>}
                                </div>
                            </>
                        }
                    </>
                </header>

            }{(mobile)&&
                <>
                   <header className={style.containerMobile}>
     {(!open )&&           
        <>
        <div className={style.logoMobile}>
          <Link to='/'>         
            <p></p>                    
          </Link>
        </div>
        <div>
          <FontAwesomeIcon icon={faBars} className={style.iconMenu} onClick={()=>setOpen(true)}/>  
        </div>
        </>
      }
      {(open)&&  
        <div className={style.navListMobile}>  
              <div className={style.navMenuMobile}>
                  <p className={style.close} onClick={()=>setOpen(false)}>x</p>
                  {(currentUser)?
                 <div className={style.userInfoContainerMobile}>
                    <div className={style.userLoginInfoMobile}>
                        <div className={style.userAvatarMobile}>                       
                             {Object.entries(info).length>0? <span>{`${info.name.charAt(0).toUpperCase()} ${info.lastName.charAt(0).toUpperCase()}`}</span>:<></>}
                         </div>
                        <div className={style.userInfoMobile}>
                             <p>Hola, </p>
                            {Object.entries(info).length>0? <p className={style.userNameMobile}>{info.name} {info.lastName}</p> :<></>}
                        </div>
                    </div>                    
             </div> 
             :
                  <p className={style.menuText}>Menu</p>}
              </div>          

              <div className={style.navMenuItems}>
            {location.pathname==='/register'?
            <>
              <Link to='/login'>Iniciar sesión</Link>
            </>:
            location.pathname==='/login'?
            <>
              <Link to='/register'>Crear cuenta</Link>
            </>:
            currentUser?
            
            <>
            <div className={style.navMenuItems}>
                        <Link to='/books'><FontAwesomeIcon icon={faBellConcierge}/> Reservas</Link>         
                        <Link to='/fav'> <FontAwesomeIcon icon={faHeart}/>  Favoritos</Link>        
                        
                            
                    </div>
            <p className={style.userCloseSession}>¿Deseas<span onClick={props.logOut}><Link to='/'>cerrar sesion?</Link></span></p>
            </>:
            <>
              <Link to='/register'><p onClick={()=>setOpen(false)}>Crear cuenta</p></Link>
              <hr className={style.line}/>                      
              <Link to='/login'><p onClick={()=>setOpen(false)} >Iniciar sesión</p></Link>
            </>
            }
              </div>
              <div className={style.navMenuBottom}>
                <div className={style.icons}>
                    <FontAwesomeIcon icon={faFacebook} className={style.navBarIcon}/>
                    <FontAwesomeIcon icon={faLinkedinIn}className={style.navBarIcon} />                 
                    <FontAwesomeIcon icon={faTwitter} className={style.navBarIcon}/> 
                    <FontAwesomeIcon icon={faInstagram} className={style.navBarIcon}/> 
                </div>
              </div>
      </div>
      }
      </header>
    
                </>
                }
            </>
        )
    }
                    
                         
                            
                            
