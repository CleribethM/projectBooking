import React from 'react';
import { useState, useContext } from 'react';
import { addDays } from 'date-fns'
import style from './search.module.css'
import 'react-date-range/dist/styles.css'; // main css file
import 'react-date-range/dist/theme/default.css'; // theme css file
import { DateRange } from 'react-date-range';
import {format} from 'date-fns'; //formato fecha
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faCalendar, faLocationDot } from '@fortawesome/free-solid-svg-icons'
import { useNavigate} from 'react-router-dom';
import { ThemeContext } from '../../context/ContextCategoryCity';

const URL_API_CITY = process.env.REACT_APP_API+"/public/api/v1/cities/"
const LOGIN_URL='/city'

export const Search = () => {
    const navigate = useNavigate()   
    const[city , setCity] = useState({});   
    const [selection, setSelection] = useState('')
    const [classHidden, setClassHidden] = useState(false)    
    const {cityApi} = useContext(ThemeContext) 
       

    const [dateRange, setDateRange] = useState([
         {
             startDate: new Date(),
             endDate: new Date(),
             key: 'selection'
         }
    ]);

    const [calendar, setCalendar] = useState(false)
    const [valueInput, setValueInput] = useState('check in - check out')
    const [calendarDirection, setCalendarDirection] = useState('')

    const startDateBook = dateRange[0].startDate
    let day = startDateBook.getDate();
    let month = startDateBook.getMonth() + 1;
    let fullYear = startDateBook.getFullYear();        
    let startDateApi = `${fullYear}-${month<10? '0'+month:month}-${day<10? '0'+day:day}`;

    const endDateBook = dateRange[0].endDate
    let endDay = endDateBook.getDate();
    let endMonth = endDateBook.getMonth() + 1;
    let endFullYear = endDateBook.getFullYear();        
    let endDateApi = `${endFullYear}-${endMonth<10? '0'+endMonth:endMonth}-${endDay<10? '0'+endDay:endDay}`

    const handleSubmit =(e)=>{
        e.preventDefault();              
        setClassHidden(false)  
        if((city.id!=undefined)&&(valueInput==='check in - check out')){
            setSelection('')
            navigate(`${LOGIN_URL}/${city.id}`,{state:'city'})
            // window.location.reload()
        }          
        else if((city.id===undefined)&&(valueInput!=='check in - check out')){
            setSelection('')
            setValueInput('check in - check out')
            navigate(`${LOGIN_URL}/0?${startDateApi}?${endDateApi}`,{state:'date'})
            //  window.location.reload()
        }
        else if((city.id!=undefined)&&(valueInput !=='check in - check out')){
            setSelection('')
            setValueInput('check in - check out')
            navigate(`${LOGIN_URL}/${city.id}?${startDateApi}?${endDateApi}`,{state:'cityDate'})
            //  window.location.reload()
        }else{
            setSelection('')
            setValueInput('check in - check out')
            navigate(`${LOGIN_URL}/0?${startDateApi}?${endDateApi}`,{state:'cityDateAll'})
            //  window.location.reload()
        }
        setCity({})
    } 
    
    const handleClickCalendar = ()=>{
        if(classHidden){
            setClassHidden(false)
        }
        setCalendar(!calendar)
        setValueInput(`${format(dateRange[0].startDate ,'dd/MM/yyyy')} to ${format(dateRange[0].endDate, "dd/MM/yyyy")}`)
    }    
  
   window.addEventListener("resize", function() {
    if (window.matchMedia("(min-width:786px)").matches) {
        setCalendarDirection('horizontal')
    } else {        
        setCalendarDirection('vertical')
    }
  })
    
  return (
    <div className={style.searchContainer}>
       <h1>Busca ofertas en hoteles, casas y mucho más</h1>
        <form onSubmit={handleSubmit}>
           <div className={style.searchInput}>
            <FontAwesomeIcon icon={faLocationDot}  className={style.icon}/>
            <input 
                className={style.inputList}
                placeholder={Object.entries(city).length===0 ? "¿A donde vamos?":{city}}
                aria-label='Search for a city'
                aria-autocomplete='both'
                aria-controls='autocomplete-results'
                onClick={()=> setClassHidden(!classHidden)}
                value={city.name}
                onChange={(e)=>setSelection(e.target.value)}                
            />
            
            <ol className={classHidden ? '': style.hidden}>
                {cityApi.filter((val)=>{
                    if(selection ===''){
                        return val
                    }else if (val.name.toLocaleLowerCase().includes(selection.toLocaleLowerCase())){
                        return val
                    }
                }).map(item =>
                    <li onClick={()=>setCity(item)} key={item.id} value={item.name.toString()}><i> <FontAwesomeIcon icon={faLocationDot} /></i>{item.name}
                    <li className={style.country}>{item.country}</li> 
                </li>)}
            </ol>
                
            </div>           
            <div className={style.searchInput} >
                    <FontAwesomeIcon icon={faCalendar} className={style.icon}/>  
              
                <input type='text' value={valueInput} placeholder={valueInput} onClick={handleClickCalendar}/>
                {calendar && <DateRange                              
                    editableDateInputs={true}                    
                    onChange={item => setDateRange([item.selection])}
                    moveRangeOnFirstSelection={false}
                    ranges={dateRange}
                    months={2}
                    direction={calendarDirection}                
                    className={style.date}
                    minDate={addDays(new Date(), 0)}                   
                    
                    />}          
            </div> 
            
            <button className={style.searchContainerButton}>Buscar</button>
            
        </form>
    </div>
  )
}
