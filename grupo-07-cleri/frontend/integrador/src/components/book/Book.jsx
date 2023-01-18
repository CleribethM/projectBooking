import React from 'react'
import style from './book.module.css'

import { useState, useEffect } from 'react'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faCircleCheck} from '@fortawesome/free-regular-svg-icons';
import Termsconditions from '../termsConditions/Termsconditions';
import BookConfirmation from '../bookConfirmation/BookConfirmation';
import { Link, useNavigate, useParams } from 'react-router-dom';
import { faAngleLeft } from '@fortawesome/free-solid-svg-icons';
import { ReservationDetail } from '../bookDetail/ReservationDetail';
import { CalendarBook } from '../calendarBook/CalendarBook';
import { useContext } from 'react';
import { ThemeContext } from '../../context/ContextCategoryCity';
import { SearchItemsByCategory } from '../cards/SearchItemsByCategory';





const URL_API_PRODUCT =process.env.REACT_APP_API+"/public/api/v1/products"
const URL_API_POSTBOOK =process.env.REACT_APP_API+"/user/api/v1/bookings/"

const Book = ({currentUser, logOut}) => {
    const navigate = useNavigate()
    const {idproduct} = useParams()
    const {cityApi} = useContext(ThemeContext)    
    const [productBook, setProductBook] = useState({})
    const[city , setCity] = useState();
    const[comment , setComment] = useState();
    const[checkIn , setCheckIn] = useState();
    const [confirmation, setConfirmacion] = useState(false)
    const [response, setResponse] = useState()
    const[image, setImage] = useState()   
    const [cityDetail, setCityDetail] = useState({})
    const [address, setAddress] = useState({})
    const [category, setCategory] = useState({})
    const[errorBook, setErrorBook] = useState('')
    const[bookRangeDates, setBookRangeDates]=useState([])
    const[load, setload]=useState(false) 
    const [info, setInfo] = useState(JSON.parse(localStorage.getItem("info")))
    const [dateRange, setDateRange] = useState([
        {
            startDate: new Date(),
            endDate: new Date(),
            key: 'selection'
        }
    ]);

  
    
    const startDateBook = dateRange[0].startDate
    let day = startDateBook.getDate();
    let month = startDateBook.getMonth() + 1;
    let fullYear = startDateBook.getFullYear();        
    let startDateBookApi = `${fullYear}-${month<10? '0'+month:month}-${day<10? '0'+day:day}`;

    const endDateBook = dateRange[0].endDate
    let endDay = endDateBook.getDate();
    let endMonth = endDateBook.getMonth() + 1;
    let endFullYear = endDateBook.getFullYear();        
    let endDateBookApi = `${endFullYear}-${endMonth<10? '0'+endMonth:endMonth}-${endDay<10? '0'+endDay:endDay}`
   
    const product = parseInt(idproduct)
    
   
    
    useEffect(() => {
        disabledDates()
        cityApi.filter((val )=>{
            if(productBook.city_id === val.id){
                setCityDetail(val)
            }
         })
    }, [])

    function datesCalendar(item){
        setDateRange([item.selection])
    }

    const handleSubmit =(e)=>{
        e.preventDefault()
        registrar()
     
        setload(true)
       
       
    }  
         
   async function disabledDates(){
        fetch(`${process.env.REACT_APP_API}/public/api/v1/fechas/${idproduct}`, {
            method: "GET",           
            headers: {
                'Content-Type': 'application/json',
            }
        })
        .then((res) => res.json())
        .then((res) =>{
            let data = res;    
            console.log(data);
            setBookRangeDates(data)
        })
    }              
    
    console.log(localStorage.getItem("user"));
     
    async function registrar() {
        const user = JSON.parse(localStorage.getItem("user")).jwtToken
        console.log(user);
       fetch(`${process.env.REACT_APP_API}/user/api/v1/bookings/`, {
            method: "POST",
            body: JSON.stringify({
                startTime: `${checkIn}:00`,
                startDate: `${startDateBookApi}`,
                endDate: `${endDateBookApi}`,
                product_id: idproduct,  
                client_id:info.id,
            }),
            headers: {
                'Content-Type': 'application/json',
                'Authorization': 'Bearer '+ `${user}`               
            }
    })   
    .then((res) =>{  
         
        
        if(res.status===201){
            setConfirmacion(true)            
             
        }else if(localStorage.getItem("user")===null){     
            setload(false)     
            setErrorBook('Su sesión ha expirado, por favor vuelva a ingresar')         
        }else if(res.status===403){
            setErrorBook('Para hacer una reserva debe iniciar sesión como usuario')         
            const timeout = setTimeout(() => {
             setload(false)
               }, 500);
                       return () => clearTimeout(timeout);
        }
        else{
            setErrorBook('Debe ingresar la fecha y la hora de la reserva')
            const timeout = setTimeout(() => {
             setload(false)
               }, 500);
                       return () => clearTimeout(timeout);
              
        }
        
    })
        
      };

      

    useEffect(() => {
        async function fetchData() {
     
          const response = await fetch(`${URL_API_PRODUCT}/${idproduct}`);
          const data = await response.json()
          console.log(response);         
            setProductBook(data[0])  
            setImage(data[0].image[0].url)
            setAddress(data[1])
            setCategory(data[2])
            
        }
        fetchData()
      }, []) 
      
    


  return (
    <>{!confirmation&&
    <div className={style.container}>
     <div className={style.productHeader}>
         <div>
            <p>{productBook.category_id==1?"Hotel":productBook.category_id==2?"Hostel":productBook.category_id==3?"Departamentos":"Bed and Breakfast"}</p>
            <h2>{productBook.title}</h2>      
        </div>
        <span><Link to= {`/product/${productBook.id}`}><FontAwesomeIcon icon={faAngleLeft} /></Link></span>    
    </div> 
    <section className={style.mainBookContainer}>
   <div className={style.bookContainer}>
    <h2 className={style.title}>Completá tus datos</h2>
    
    <form className={style.formContainer}>
        <div className={style.formDisplay}>
            <div className={style.displayLeft}>
                <label htmlFor="name">Nombre</label>
                <input className={style.inputText} type="text" name="name" disabled value={info.name}/>
            </div>
            <div  className={style.displayRight}>
                <label htmlFor="lastname">Apellido</label>
                <input className={style.inputText} type="text" name="lastname" disabled value={info.lastName}/>
            </div>
            <div className={style.displayLeft}>
                <label htmlFor="email">Email</label>
                <input className={style.inputText}  type="text" name="email" disabled value={info.email}/>
            </div>
            <div className={style.displayRight}>
                <label htmlFor="city">Ciudad</label>
                <input className={style.inputText} type="text" name="city"placeholder='Ingrese ciudad de residencia' value={city} onChange={(target)=>setCity(target.value)}/>
            </div>
           
            <div className={style.displayLeft}>
                <label htmlFor="info">Comentarios</label>
                <textarea maxlength="100" onChange={(target)=>setComment(target.value)} value={comment}></textarea>
            </div>
            <div className={style.displayRightCovid}>
                <label className={style.covidLabel} htmlFor="covid">Está vacunado contra el COVID-19</label>
                <input className={style.covidInput} type="checkbox" name="covid" value={true}/>
            </div>
        </div>       
  
    </form>
   </div>
   <div className={style.bookContainer}>
   <h2 className={style.title}>Seleccioná tu fecha de reserva</h2>
        <div className={style.calendarContainer}>
            <CalendarBook            
            datesCalendar= {datesCalendar}
            dateRange={dateRange}
            bookRangeDates= {bookRangeDates}   
             
        />
        </div>
   </div>
      
   <div className={style.bookContainer}>
        <h2 className={style.title}>Tu horario de llegada</h2>
        <div className={style.selectContainer}>
            {checkIn&& <p className={style.checkInTitle}> <FontAwesomeIcon  icon={faCircleCheck}/>Tu habitación va a estar lista para el check-in a partir de las {checkIn}</p>}
            <label  className={style.checkInTitle}htmlFor="checkin">Indicá tu horario estimado de llegada</label>
            <select className={style.selectItem} input="time" required name="checkin" id="checkin" value={checkIn} onChange={(e)=>setCheckIn(e.target.value)}>
            <option value="" disabled selected>Seleccione hora</option>
                <option value="1:00">1:00 AM</option>
                <option value="2:00">2:00 AM</option>
                <option value="3:00">3:00 AM</option>
                <option value="4:00">4:00 AM</option>
                <option value="5:00">5:00 AM</option>
                <option value="6:00">6:00 AM</option>
                <option value="7:00">7:00 AM</option>
                <option value="8:00">8:00 AM</option>
                <option value="9:00">9:00 AM</option>
                <option value="10:00">10:00 AM</option>
                <option value="11:00">11:00 AM</option>
                <option value="12:00">12:00 AM</option>
                <option value="13:00">1:00 PM</option>
                <option value="14:00">2:00 PM</option>
                <option value="15:00">3:00 PM</option>
                <option value="16:00">4:00 PM</option>
                <option value="17:00">5:00 PM</option>
                <option value="18:00">6:00 PM</option>
                <option value="19:00">7:00 PM</option>
                <option value="20:00">8:00 PM</option>
                <option value="21:00">9:00 PM</option>
                <option value="22:00">10:00 PM</option>
                <option value="23:00">11:00 PM</option>
                <option value="24:00">12:00 PM</option>
                </select>
        </div>
   </div>
   <div className={style.reserveDetail}>
        
            <ReservationDetail
                points={productBook.punctuation}
                direction={address}
                name={productBook.title}                
                category={category}
                image={image}
                dateRange={dateRange}
                handleSubmit ={handleSubmit}
                error={errorBook}
                currentUser={currentUser}
                post = {load}
            />
        
   </div>     
  
   </section>
   
   <section>
    <Termsconditions
    className={style.line}
    policy={productBook.houseRules}
    security={productBook.healthAndSafety}
    cancelTerms={productBook.cancellationPolicies}

    />

   </section>
   
  
   </div>}
        
 
   {confirmation&&
    <BookConfirmation
    response= {response}/>
   }
    </>
)
}

                


      

export default Book
