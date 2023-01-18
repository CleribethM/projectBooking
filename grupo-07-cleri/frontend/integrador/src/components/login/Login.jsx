import React from 'react'
import{useRef, useState, useEffect} from 'react'
import{Link, useNavigate, useLocation} from 'react-router-dom'
import { Footer } from '../footer/Footer';

import style from './login.module.css'
import AuthService from '../../service/AuthService';


export const Login = () => {


   // const credenciales = useUserContext() 
    const navigate = useNavigate();    
    const userRef = useRef()    
    const location = useLocation()
    const bookLogin = location.state;    
    const [loginErrors, setLoginErrors] = useState()
    const [loginErrorsServer, setLoginErrorsServer] = useState(false)
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    
    useEffect(()=>{
         userRef.current.focus();
        },[])
        
    const handleLogin = async (e) => {
        e.preventDefault();
       if(password.length<6){
           
           setLoginErrors(true)
           setTimeout(()=>{
            setLoginErrors(false)
          
          },3000)
       }            
        else{
        try {
            await AuthService.login(email, password).then(
                () => {
                    bookLogin? navigate(`/product/${bookLogin}/book`):
                    navigate("/");
                    // navigate(`${LOGIN_URL}/${credenciales.user.name.charAt(0)}${credenciales.user.lastName.charAt(0)}`)
                     window.location.reload();
                     
            },
            (error) => {
                setLoginErrorsServer(true)
                setTimeout(()=>{
                    setLoginErrorsServer(false)
                  console.log(error);
                  },3000)
              

            }
          );
        } catch (err) {
         
        }
        }
      };
    
    /* const handleSubmit = (e)=>{
        e.preventDefault() 
        validate(loginValues)
    }*/
    
    /*const validate = (credentials)=>{
        if (credentials.email!==credenciales.user.user){
            setLoginErrors(['el mail es invalido'])
        }
        else if(credentials.password.length<6){
            setLoginErrors(['contraseña menor a 6 caracteres'])
        }
        else if(credentials.password!==credenciales.user.password){
            setLoginErrors(['contraseña invalida'])
        }
        else if((credentials.email===credenciales.user.user)&&(credentials.password===credenciales.user.password)){
            navigate(`${LOGIN_URL}/${credenciales.user.name.charAt(0)}${credenciales.user.lastName.charAt(0)}`)
        }
    }*/

       

    return (
        <>
        {/* <Header login="true"/> */}
        {/* <Search/>  */}
        <section className={style.containerLogin}>
                <div className={style.formContainerLogin}>
                  <h1>Iniciar sesión</h1>
                    <p className={loginErrors ? style.errorLogin : style.errorHidden}> Por favor vuelva a 
                    intentarlo, sus credenciales son inválidas</p>  
                   <p className={loginErrorsServer ? style.errorLogin : style.errorHidden}>Lamentablemente no ha podido iniciar sesión. Por favor, intente más tarde</p> 
                    <form action="login" onSubmit={handleLogin} >
                        <label htmlFor="email">Correo electronico</label>
                        <input 
                            type="email" 
                            id='email'
                            ref={userRef}
                            autoComplete='on'
                            // onChange={(e)=>setLoginValues({...loginValues, email:e.target.value})}
                            onChange={({target})=>setEmail(target.value)}
                            // value={loginValues.email}
                            value={email}
                            required
                            />
                        <label htmlFor="password">Contraseña</label>
                        <input 
                            type="password" 
                            id='password'
                            ref={userRef}
                            // onChange={(e)=>setLoginValues({...loginValues, password:e.target.value})}
                            onChange={({target})=>setPassword(target.value)}
                            // value={loginValues.password}
                            value= {password}
                            required
                            />
                        <button className={style.formButtonLogin}>Iniciar sesion</button>
                    </form>
                </div>
                <div className={style.loginBottom}>                   
                    <p>¿Aún no tienes cuenta? <span>
                    <Link to='/register'>Registrarse</Link> 
                        </span></p>
                </div>
            </section>
            <Footer/>  
        </>
    )
}
                        
