
import prodStyle from './producto.module.css'

import { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import { SearchItemsByCategory } from './SearchItemsByCategory';


const URL_API_PRODUCT = process.env.REACT_APP_API+"/public/api/v1/products"
export default function Item({nombre, stock, url, id, key}) {

  

  const[recommended, setRecommended] = useState([])  
  
  const[idCat, setIdCat]=useState()
  
  /*useEffect(()=>{
    fetch(URL_API_PRODUCT)
    .then((resp) =>resp.json())
    .then((resp) =>{
      setRecommended(resp)
    })
  }, [])*/

  
    
    /*const extract = recommended.filter(function(el){
      return el.category_id == id 
    });
    console.log(extract); */
  

  return (
    <>
        <div className={prodStyle.producto} key={id}>
          <Link className={prodStyle.linkto} to={`/category/${id}`}> 
          <div>
                <img src={url} alt= {nombre}/>
          </div>
          <div className={prodStyle.infoCategory}>
             <h3>{nombre}</h3>
              <p>{stock}</p>
          </div></Link>
        </div>
        
    </>
  )
}