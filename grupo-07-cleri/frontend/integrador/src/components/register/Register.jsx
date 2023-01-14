import React, { useEffect, useRef, useState } from 'react'
import{Link, useNavigate} from 'react-router-dom'
import { Footer } from '../footer/Footer';
import { Header } from '../header/Header';
import style from './register.module.css'
import AuthService from '../../service/AuthService';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faCircleExclamation } from '@fortawesome/free-solid-svg-icons';
import Spinner from '../spinner/Spiner'

const URL_API_CREATE_USER =process.env.REACT_APP_API+"/public/api/v1/users/"


export const Register = () => {

  const navigate = useNavigate(); 
  const userRef = useRef()  
  const [error, setError] = useState(false)
  const[errorRegister, setErrorRegister] = useState('')
  const [confirmation, setConfirmacion] = useState(false)
  const [post, setPost] = useState(false)
  

  useEffect(()=>{
    userRef.current.focus();
},[])

  const initialForm = {
    name:'',
    lastname: '',
    email: '',
    password: '',
    passwordTwo: '',
    phone: ''
  }

  const [registerData, setRegisterData] = useState(initialForm);

  const handleChange = (e) => {
    const {nombre, value} = e.target.value
    
    setRegisterData({
        ...registerData,
        nombre: value
    })
  };

  const handleSubmit = async(e) => {
    e.preventDefault();
    validate(registerData)
    
  }


  async function register(){
    fetch( URL_API_CREATE_USER, {
      method: "POST",
      body: JSON.stringify({
        name: `${registerData.nombre}`,
        lastName: `${registerData.apellido}`,
        email: `${registerData.email}`,
        password: `${registerData.password}`,
        phone:`${registerData.phone}`

      }),
      headers: {
        'Content-Type': 'application/json'
                   
    }
    })
    .then((res) =>{    
      if(res.status===201){
        setConfirmacion(true)
        navigate("/login")
      }else{
        setPost(false) 
        setErrorRegister('Lamentablemente no ha podido registrarse. Por favor intente más tarde')
        setConfirmacion(false)
        setError(true)
      }
    
    
  })
    
    
  }

  const validate = (registerData) => {
    if((registerData.password===registerData.passwordTwo) && (registerData.password.length >= 6)){
      register()
      setPost(true)
    }
    else{
      setError(true)
      //navigate("/register")
    }
  } 

        
    return (
        <>
         {/* <Header register="true"/>  */}
        <section className={style.registerContainer}>
          <div className={style.registerFormContainer}>
                <h1>Crear cuenta</h1>
                    <form action="register" onSubmit={handleSubmit} >
                      <div className={style.registerName}>
                        <div className={style.labelName}>
                          <label htmlFor="nombre">Nombre</label>
                          <input 
                              type="text" 
                              id='nombre'
                              onChange={(e) => setRegisterData({
                                ...registerData,
                                nombre: e.target.value
                              })}
                              value={registerData.nombre}
                              ref= {userRef}
                              autoComplete='on'
                              required
                              />
                        </div>

                        <div className={style.labelLastName}>
                          <label htmlFor="apellido">Apellido</label>
                          <input 
                            type="text" 
                            id='apellido'
                            onChange={(e) => setRegisterData({
                              ...registerData,
                              apellido: e.target.value
                            })}
                            value= {registerData.apellido}
                            autoComplete='on'
                            required
                          />
                        </div>
                      </div>
                      <label htmlFor="text">Telefono</label>
                        <input 
                            type="number" 
                            id='phone'
                            onChange={(e) => setRegisterData({
                              ...registerData,
                              phone: e.target.value
                            })}
                            value= {registerData.phone}
                            autoComplete='on'
                            required
                            placeholder='Ingrese el tel 549123456789'
                            />
                            <label htmlFor="email">Correo electrónico</label>
                        <input 
                            type="email" 
                            id='email'
                            onChange={(e) => setRegisterData({
                              ...registerData,
                              email: e.target.value
                            })}
                            value= {registerData.email}
                            autoComplete='on'
                            required
                            />
                        <label htmlFor="password">Contraseña</label>
                        <input 
                            type="password" 
                            id='password'
                            onChange={(e) => setRegisterData({
                              ...registerData,
                              password: e.target.value
                            })}
                            value= {registerData.password}
                            required
                            />
                            <label htmlFor="passwordTwo">Confirmar contraseña</label>
                        <input 
                            className={error? style.errorRegister: ''}
                            type="password" 
                            id='passwordTwo'
                            onChange={(e) => setRegisterData({
                              ...registerData,
                              passwordTwo: e.target.value
                            })}
                            value= {registerData.passwordTwo}
                            required
                            />
                          <p className={error? style.errorText:style.hiddenText }>Este campo es obligatorio</p>
                          {confirmation && <p className={style.errorBook}> <FontAwesomeIcon icon={faCircleExclamation}/>     {error}</p>}
                          
                            {post? <Spinner/> :  <button className={style.registerFormButton}>Crear cuenta </button>}
                          
                    </form>
                </div>
                          
                <div className={style.registerBottom}>                  
                    <p>¿Aún no tienes cuenta? <span>
                    <Link to='/login'>Iniciar sesión</Link> 
                        </span></p>
                </div>
          
            </section>
           
        </>
    )
}