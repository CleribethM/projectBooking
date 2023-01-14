
import { useEffect } from 'react';
import { useState } from 'react';
import { Calendar } from 'react-date-range';
import { Link, useNavigate, useParams } from 'react-router-dom';
import Book from '../book/Book';
import style from './bookingCalendar.module.css';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faCircleExclamation } from '@fortawesome/free-solid-svg-icons';
import { addDays } from 'date-fns';


export const BookingCalendar = ({id, currentUser, bookRangeDates }) => {
    const navigate = useNavigate();  
    const {idproduct} = useParams()
    const[mobile, setMobile] = useState();    
    const [width, setWidth] = useState(window.innerWidth)
    const[days, setDays] = useState([])
    
        
   useEffect(()=>{
        let eachDay =[]
        bookRangeDates.map(item =>{     
        let fechaInicio = new Date(item.startDate);
        let fechaFin    = new Date(item.endDate);

        while(fechaFin.getTime() >= fechaInicio.getTime()){
            fechaInicio.setDate(fechaInicio.getDate() + 1);    
       
            eachDay.push((fechaInicio.getMonth() + 1) + '/' + fechaInicio.getDate() + '/' +fechaInicio.getFullYear());
            }      
        
        })
         setDays(eachDay)
        },[bookRangeDates])
        
        console.log(days);
        
        const disableDate = days.map (eachDay =>{
        new Date (eachDay)
        
    })
    

    const updateWindowDimensions = () => {
        const newWidth = window.innerWidth;
        setWidth(newWidth);
    };

    
    
    useEffect(() => {
        window.addEventListener('onclick', updateWindowDimensions);
        width>460? setMobile(false): setMobile(true)
       
    }, [width]);
    
    window.addEventListener("resize", function() {
        if (window.matchMedia("(min-width:460px)").matches) {
            setMobile(false)
        } else {
            setMobile(true)
        }
    })
 
    const handleBook = ()=>{
        if(currentUser){
            navigate(`/product/${id}/book`)
        }else{
            navigate('/login', {state:idproduct})         
        }
    }
   
    return (
        <div className={style.containerCalendar}>
            <h2 className={style.title}>Fechas disponibles</h2>
            <div className={style.blockCalendar}>
                <div >
                    <Calendar
                        className={style.calendar}
                        disabledDates={ days.map(eachDay =>{
                               return  new Date (eachDay)
                                })}                           
                        direction={'horizontal'}
                        months={mobile? 1:2}                    
                    />
                </div>
            </div>
            <div className={style.reserve}>
                <div className={style.description}>
                    <span>Agregá tus fechas de viaje para obtener precios exactos</span>
                </div>
                <div>
                {!currentUser&& 
                 <p className={style.loginBook}> <FontAwesomeIcon  icon={faCircleExclamation}/>   Para realizar una reserva necesita estar logueado</p>  }
                {/* <Link to={`/product/${id}/book`} id={id} category={category}><button onClick={handleBook} className={style.buttonReserve}>  Iniciar reserva</button> </Link> */}
                <button onClick={handleBook} className={style.buttonReserve}>  Iniciar reserva</button> 
                </div>
            </div>
        </div>
    )    
}
