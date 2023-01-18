import  React from 'react'
import style from './product.module.css'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import {faAngleLeft, faLocationDot, faShareNodes} from '@fortawesome/free-solid-svg-icons'
import { faHeart } from '@fortawesome/free-regular-svg-icons'
import { Link } from 'react-router-dom'
import StarRate from '../starsrate/StarRate'
import { useState, useEffect } from 'react'
import ImageSliderMobile from '../carrusel/ImageSliderMobile'
import { BookingCalendar } from '../calendar/BookingCalendar'
import Location from '../location/Location'
import Termsconditions from '../termsConditions/Termsconditions'
import { Feature } from '../features/Feature'
import Score from '../score/Score'


const URL_API_CITY = process.env.REACT_APP_API+"/public/api/v1/cities/"
const URL_API_CATEGORY = process.env.REACT_APP_API+"/public/api/v1/categories"
const URL_API_FAV_ADD = process.env.REACT_APP_API+"/user/api/v1/fav/"
const URL_API_FAVORITES =process.env.REACT_APP_API+"/user/api/v1/fav/"
const URL_API_FAV_DELETE = process.env.REACT_APP_API+"/user/api/v1/fav/"


const Product = ({id ,category, nombre, url,address, rating, points, security, cancelTerms, policy, feature, key,title, description, currentUser, currentUserInfo}) => {
    
    const [carrousel, setCarrousel]= useState(false)    
    const [cities, setCities] = useState([])
    const [city, setCity] = useState({})      
    const [favID, setFavID] = useState()
    const[favorites, setFavorites] = useState([])
    const[bookRangeDates, setBookRangeDates]=useState([])

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

    function datesCalendar(item){
        setDateRange([item.selection])
    }


    useEffect(()=>{    
        fetch(URL_API_CITY)
        .then((res) => res.json())
        .then((res) =>{           
                setCities(res)
                res.filter((val)=>{               
                if(val.id === address){
                    setCity(val)
                }
                })
            });
            
        }, [])

        async function disabledDates(){
            const response = await fetch(`${process.env.REACT_APP_API}/public/api/v1/products/${id}/bookings/`, {
            })
            .then((res) => res.json())
            .then((res) =>{
                let data = res;    
                console.log(data);
                setBookRangeDates(data)
            })
        }

        useEffect(()=>{
            disabledDates()        
            if(currentUser){
            fetch(`${URL_API_FAVORITES}${currentUserInfo.id}`,{
            headers: {
                'Content-Type': 'application/json',             
                'Authorization': 'Bearer '+ `${currentUser.jwtToken}`               
                }
            })
            .then((resp) =>resp.json())
            .then((resp) =>{ 
              console.log(resp);              
              resp.filter((val) =>{
              if(val.product_id === id){
                  console.log(val.id);
                  setFavID(val.id)
                }
            })          
            setFavorites(resp)                
          
            })}    
          }, [])

   
         
 
          
         
    console.log(bookRangeDates);
     

    const handleFav = ()=>{
        favID===undefined? addFav():deleteFav(favID)
    }


    
                
    const addFav = async () =>{    
        await fetch(URL_API_FAV_ADD, {
             method: "POST",
             body:
               JSON.stringify(
                {product_id:id,
                    id_client:currentUserInfo.id}
              )
             ,
             headers: {
                 'Content-Type': 'application/json',             
                 'Authorization': 'Bearer '+ `${currentUser.jwtToken}`               
             }
        })
        .then((res) => res.text())
        .then((res) =>{           
            setFavID(res.slice(7))            
         })
        };   

        const deleteFav = async (favID) =>{    
            await fetch(`${URL_API_FAV_DELETE}${favID}`, {
                 method: "DELETE",
                
                 headers: {
                     'Content-Type': 'application/json',             
                     'Authorization': 'Bearer '+ `${currentUser.jwtToken}`               
                 }
            })
            .then((res) => res.text())
            .then((res) =>{           
                console.log(res);   
                setFavID()     
             })
            };   
        
            
    
  
    
        
    const handleCaruselOn = ()=>{
        setCarrousel(true)
    }
    
    const handleCaruselOff = ()=>{
        setCarrousel(false)
    }

  

   
  return (    
              
      <>
     <section className={style.product} key={key}>
        <div className={style.productHeader}>
            <div>
                <p>{category==1?"Hotel":category==2?"Hostel":category==3?"Departamentos":"Bed and Breakfast"}</p>
                <h2>{nombre}</h2>      
            </div>
             <span><Link to= '/'><FontAwesomeIcon icon={faAngleLeft} /></Link></span>    
        </div>
        <div className={style.productInfo}>
            <div>
                <span className={style.icon}><FontAwesomeIcon icon={faLocationDot} /></span>
                <span className={style.address}>{`${city.name}, ${city.location},  ${city.country}`}</span>
            </div>
            <div className={style.calification}>
                <div className={style.score}>
                    <Score
                    points={points}/>
                    <StarRate
                    points={points}/>
                </div>     
                <div className={style.pointsContainer}>
                    <span className={style.points}>{points}</span>
                </div>
            </div>       
        </div>
        <div className={style.mainContainer}>
            <div className={style.iconContainer}>
                <span className={style.icon}><FontAwesomeIcon icon={faShareNodes} /></span>
               {currentUser&& <span  onClick={handleFav}><FontAwesomeIcon icon={faHeart} className={favID != undefined?style.iconTrue:style.icon} /></span>}
            </div>
              
            {url &&< div className={style.imagesContainer}>
                             
                <img key={0}className={style.mainImg} src={url[0].url} alt={nombre}  />
                <img src={url[1].url} alt={url[1].title} />
                <img src={url[2].url} alt={url[2].title}/>                
                <img src={url[3].url} alt={url[3].title}  />
                <img src={url[4].url} alt={url[4].title}  /> 
                <p className={style.text} onClick={handleCaruselOn}>Ver más</p>
            </div>}
            <div className={style.imagesContainerMobile}>
                <ImageSliderMobile images = {url}/>
            </div>
        </div >
        
       <div className={carrousel? style.gallery: style.hiddenCarrousel}>
            <div className={carrousel?style.imagesContainerCarrusel: style.hiddenCarrousel}>
                <ImageSliderMobile
                    images={url}                   
                />
            </div>
            <div className={carrousel?style.close:style.hiddenCarrousel}> 
                <span onClick={handleCaruselOff}>x</span>
            </div> 
        </div> 
    </section>
    <section>
    <div className={style.locationContainer}>
        <div>
           <h2 className={style.titleDescription}>{title}</h2>
         </div>
        <div className={style.block}>        
           <p className={style.city}>{description}</p>
        </div>

    </div>
    </section>

    <section>
    <div className={style.containerFeature}>
        <div>
           <h2 className={style.title}>¿Qué ofrece este lugar?</h2>
         </div>
        <div className={style.block}>
        
            <Feature
            feature = {feature}
            text={true}/>
        </div>

    </div>
    </section>

    <section>
        <BookingCalendar
        // key={key}
         id={id}
        // category={category}
        // nombre={nombre}
        // url={url}
        // address = {address}
        // feature = {feature}
        // points={points}
        // policy={policy}
        // security={security}
        // cancelTerms={cancelTerms}
         currentUser={currentUser}
        // datesCalendar= {datesCalendar}
        // dateRange={dateRange}
        // bookRangeDates= {bookRangeDates}
        datesCalendar= {datesCalendar}
        dateRange={dateRange}
        bookRangeDates = {bookRangeDates}
         
       
        />
    </section>

    <section className={style.locationContainer}>
        <Location
        city={city.name}
        />
    </section>   
     <section>
        <Termsconditions
        policy={policy}
        security={security}
        cancelTerms= {cancelTerms}/>
    </section>   
     {/* <section className={style.hidden}>
            <Book 
                key={key}
                id={id}
                category={category}
                nombre={nombre}
                url={url}
                address = {address}
                feature = {feature}
                points={points}
                policy={policy}
                security={security}
                cancelTerms={cancelTerms}
            />
        
     
      </section> */}
     </>
    
        

     
)
}



export default Product
