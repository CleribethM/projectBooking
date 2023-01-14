import React from 'react'
import { Search } from '../search/Search'
import {CardsProducto} from '../cards/CardsProducto'
import { useParams } from 'react-router-dom'



export const Home = ({currentUser, currentUserInfo}) => {
  const {idproduct} = useParams()
  
   
  return (
    <div>
      
        {!idproduct && <Search/>} 
       
        <CardsProducto
        currentUser={currentUser}     
        currentUserInfo={currentUserInfo}/>      
        
        
        
    </div>
  )
}
