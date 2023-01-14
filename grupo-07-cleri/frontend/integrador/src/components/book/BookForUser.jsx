import { faAngleLeft, faCircleExclamation } from '@fortawesome/free-solid-svg-icons'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import React, { useEffect, useState } from 'react'
import { Link, useParams } from 'react-router-dom'
import style from './bookForUser.module.css'
import { CardsBook } from './CardsBook'



export const BookForUser = () => {

    const [books, setBooks] = useState([])
    const [image, setImage] = useState()

    const [cardsBook, setCardsBook] = useState([])

    const user = JSON.parse(localStorage.getItem("info")).id
    const jwt = JSON.parse(localStorage.getItem("user")).jwtToken
    
  
    useEffect(()=>{
        fetch(`${process.env.REACT_APP_API}/user/api/v1/client/${user}/bookings`, {
        headers: {
          'Content-Type': 'application/json',             
          'Authorization': 'Bearer '+ `${jwt}` }             
      })
        .then((resp) =>resp.json())
        .then((resp) =>{
          setBooks(resp)
          setImage(resp[1].image.slice(12,-1))
          console.log(resp);
        })
        
      }, [])

    
console.log(books);

  return (
    <div>
        <div className={style.container}>
            <div className={style.productHeader}>
                <div>
                    <h2>Mis reservas</h2>
                </div>      
                <span><Link to= {`/`}><FontAwesomeIcon icon={faAngleLeft}  className={style.backButton}/></Link></span>  
            </div>

               {books.length>0 && 
              
               <div className={style.booksTitle}>
                <h3>Alojamientos reservados para ti</h3>
                <div className={style.containerCard}>
                    {books.map(item => {
                      return(
                        <CardsBook
                          className={style.containerCard}
                          image= {item.image.slice(12,-1)}
                          name={item.product}
                          category={item.category}
                          points={item.puntuation}
                          city={item.city}
                          idProducto= {item.product_id}
                          startDate={item.startDay}
                          endDate={item.endDay}
                        />
                    )}
                    )}
                    </div>
                  </div>
                }

                {books.length<= 0 &&
                  <div className={style.noBook}>
                    <h3><FontAwesomeIcon  icon={faCircleExclamation} className={style.noBookIcon}/>Aún no has efectuado ninguna reserva</h3>
                    <Link to={`/`}><button>Reserva aqui</button></Link>
                  </div>
                }
            
        </div>

    </div>
  )
}
