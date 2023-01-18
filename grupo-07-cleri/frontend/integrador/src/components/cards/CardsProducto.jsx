import React from 'react'
import Item from './Item';
import Recomendado from './Recomendado';
import './styles.css'
import style from './recomendado.module.css'
import prodStyle from './producto.module.css'
import { useLocation, useParams } from 'react-router-dom';
import Product from './Product';
import { useState } from 'react';
import { useEffect } from 'react';
import { useContext } from 'react';
import { ThemeContext } from '../../context/ContextCategoryCity';
import Book from '../book/Book';



const URL_API_CATEGORY = process.env.REACT_APP_API+"/public/api/v1/categories"
const URL_API_PRODUCT =process.env.REACT_APP_API+"/public/api/v1/products"


export const CardsProducto = ({currentUser, currentUserInfo}) => {
  const {idproduct} = useParams();    
  const[recommended, setRecommended] = useState([]);
  const {category} = useContext(ThemeContext);
  const {cityApi} = useContext(ThemeContext);
  
  


useEffect(()=>{
  fetch(URL_API_PRODUCT)
  .then((resp) =>resp.json())
  .then((resp) =>{    
    setRecommended(resp)
  })
  
}, [])      

  return (
   
      
    <main>
     
      {(!idproduct)&&
      <>
        <section className={prodStyle.categorys}>                          
              <h2>Buscar por tipo de alojamiento</h2>
              <div className={prodStyle.containerCards}>
                  {
                    category.map( data => {
                      return(
                    <Item 
                    url= {data.url}
                    key = {data.id}
                    id = {data.id}
                    nombre= {data.title}
                    stock = {data.description}
                    />
                    )}
                    )}
                </div>
        </section>
        <section className={style.recomendaciones}>          
                <h2>Recomendaciones</h2>
        {<div className={style.containerRecomendaciones}>
                {
                  recommended.filter(item => item.punctuation>8).map( info => {
                    console.log(info);
                    return(
                  <Recomendado 
                  category={info.category_id}
                  descripcion={info.description}
                  url= {info.image[1].url}
                  direction = {info.city_id}
                  id = {info.id}
                  nombre ={info.title}                      
                  stock = {info.stock}
                  points= {info.punctuation}
                  raiting={info.raiting}
                  feature={info.feature}
                  currentUser={currentUser}
                  currentUserInfo = {currentUserInfo}
                  
                  />
                  )}
                  )}
                  </div>}
            </section>
      </>
      }
      {idproduct&&
      <>        
        {recommended.filter(
          item => item.id == idproduct).map(filteredProduct =>(
            
            <Product
              key={filteredProduct.id}
              id={filteredProduct.id}
              title ={filteredProduct.titleDescription}
              description ={filteredProduct.description}
              category={filteredProduct.category_id}
              nombre={filteredProduct.title}
              url={filteredProduct.image}
              address = {filteredProduct.city_id}
              feature = {filteredProduct.feature}
              points={filteredProduct.punctuation}
              policy={filteredProduct.houseRules}
              security={filteredProduct.healthAndSafety}
              cancelTerms={filteredProduct.cancellationPolicies}
              currentUser={currentUser}
              currentUserInfo={currentUserInfo}
             
              />
            ))}
        
      </>
      }
      

      </main>
    
  
   

    
  )
}
