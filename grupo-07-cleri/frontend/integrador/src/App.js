import './App.css';
import { Home } from './components/home/Home';
import { Register } from './components/register/Register';
import {BrowserRouter, Route, Routes} from 'react-router-dom'
import { Login } from './components/login/Login';
import SearchItems from './components/searchItems.jsx/SearchItems';
import { Header } from './components/header/Header'
import { useState, useEffect, useContext } from 'react';
import { Footer } from './components/footer/Footer'
import { SearchItemsByCategory } from './components/cards/SearchItemsByCategory';
import AuthService from './service/AuthService';
import  ThemeContext from './context/ContextCategoryCity';
import Product from './components/cards/Product';
import Book from './components/book/Book';
import Admin from './components/admin/Admin';
import Favorites from './components/favorites/Favorites';
import { BookForUser } from './components/book/BookForUser';



function App() { 
  const [currentUser, setCurrentUser] = useState(); 
  const [currentUserInfo, setCurrentUserInfo] = useState({});
  const [currentUserRole, setCurrentUserRole] = useState('');
  const user = AuthService.getCurrentUser();
  const info = AuthService.getCurrentUserInfo();
  const role = AuthService.getCurrentUserRole();
 

 
 console.log(currentUserInfo);
 console.log(currentUser);
  useEffect(() => {
    if (user) {
      setCurrentUser(user);
    
    }
  },[]);

  useEffect(() => {
    if (info) {        
      setCurrentUserInfo(info);
    //   parseJwt (currentUser)
    }
  },[]);

  useEffect(() => {
    if (role) {        
      setCurrentUserRole(role);
    //   parseJwt (currentUser)
    }
  },[]);

 
  
  
  const logOut = () => {
    AuthService.logout();
    setCurrentUser()
    setCurrentUserInfo()
    setCurrentUserRole();
   
  };

  return (
    <div className="App">
    <ThemeContext>
    <BrowserRouter>
    <Header
      currentUser={currentUser}  
      info = {currentUserInfo}   
      role = {currentUserRole}   
      logOut={logOut}/>  
       
        <Routes>
          <Route path='/'element ={<Home  currentUser={currentUser} currentUserInfo ={currentUserInfo}/>}> 
          <Route path='/product/:idproduct' element={<Product/>}></Route> 
          </Route>
          <Route path='/product/:idproduct/book' element={<Book currentUser={currentUser} logOut={logOut}/>}></Route>
          <Route path='/category/:categoryid' element={<SearchItemsByCategory/>}></Route> 
          <Route path='/city/:city' element={<SearchItems/>}></Route>  
          <Route path='/register' element={<Register/>}></Route>
          <Route path='/login' element={<Login/>}></Route>
          <Route path='/user/:userid'element ={<Home/>}></Route>
          <Route path='/admin'element ={<Admin role = {currentUserRole}/>}></Route>  
          <Route path='/books' element={<BookForUser/>}></Route>        
          <Route path='/fav'element ={<Favorites user = {currentUser} userInfo={currentUserInfo}/>}></Route>          
          <Route path="*" element="Error 404" />
        </Routes>
      <Footer/> 
    </BrowserRouter>
    </ThemeContext>
    </div>
  );
}

export default App;
