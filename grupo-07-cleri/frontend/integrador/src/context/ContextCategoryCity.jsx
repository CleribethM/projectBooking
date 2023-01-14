import React from 'react'
import { useState, useEffect } from 'react'
export const ThemeContext = React.createContext()

const URL_API_CATEGORY = process.env.REACT_APP_API+"/public/api/v1/categories"
const URL_API_CITY = process.env.REACT_APP_API+"/public/api/v1/cities/"

const ContextCategoryCity = (props) => {
    const[cityApi, setCityApi] = useState([]);
    const[category, setCategory] = useState([]);


    useEffect(()=>{
    
        fetch(URL_API_CATEGORY)
        .then((res) => res.json())
        .then((res) =>{
          let data = res
          setCategory(data)
        });
    
    }, [])

    useEffect(()=>{    
        fetch(URL_API_CITY)
        .then((res) => res.json())
        .then((res) =>{
          let data = res;
         
         setCityApi(data)
        });
       
    }, [])

  return (
    <ThemeContext.Provider value={{cityApi, category}}>
        {props.children}
    </ThemeContext.Provider>
    
  )
}

export default ContextCategoryCity