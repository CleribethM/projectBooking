import React from 'react'
import { useState } from 'react'
import { useEffect } from 'react'
import { useParams } from 'react-router-dom'
import styleCat from './searchItems.module.css'
import { useNavigate } from "react-router-dom"
import Item from './Item'
import { useContext } from 'react';
import { ThemeContext } from '../../context/ContextCategoryCity';
import prodStyle from './producto.module.css'
import Recomendado from './Recomendado'


const URL_API_PRODUCT_CATEGORY =process.env.REACT_APP_API+"/public/api/v1/categories"
const PRODUCT_URL='/product'
const URL_API_PRODUCT =process.env.REACT_APP_API+"/public/api/v1/products"


export const SearchItemsByCategory = () => {

    const {categoryid} = useParams(); 
    console.log(categoryid);
    const {category} = useContext(ThemeContext);
    const {cityApi} = useContext(ThemeContext);    
    const [categoryName, setCategoryName] = useState([])


        useEffect(()=>{    
            fetch(URL_API_PRODUCT)
            .then((res) => res.json())
            .then((res) =>{
                let data = res
              setCategoryName(data)
              
            });
           
        }, [])    
                

  return (

    <>    
        
        <section className={styleCat.categoryContainer}>                          
              <h2>Buscar por categoria </h2>
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
        {<section className={styleCat.itemsContainer}>          
                <h2>Hospedajes de tipo {categoryid==1?"Hotel":categoryid==2?"Hostel":categoryid ==3?"Departamentos":"Bed and Breakfast"} </h2>
                <div className={styleCat.containerRecomendaciones}>
                {
                  categoryName.filter(item=> item.category_id == categoryid )
                        .map( info => {

                            return(                                                         
                                    <Recomendado 
                                    category={info.category_id}
                                    descripcion={info.description}
                                    url= {info.image[1].url}
                                    direction = {info.city_id}
                                    id = {info.id}
                                    nombre= {info.title}
                                    stock = {info.stock}
                                    points= {info.punctuation}
                                    raiting={info.raiting}
                                    feature={info.feature}     
                                                            
                                    />                        
                         
                            )}
                        )
                      }
                  </div>
              </section>
          }
          </>
        )
      }
                  
      

  
        
