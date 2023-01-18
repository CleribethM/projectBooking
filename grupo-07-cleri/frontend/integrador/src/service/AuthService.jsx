import axios from "axios";

const API_URL = process.env.REACT_APP_API+"/public/authenticate/";
const URL_API_CREATE_USER =process.env.REACT_APP_API+"/public/api/v1/users/"


const signup = (name, lastname, email, password) => {
  return axios
    .post(URL_API_CREATE_USER, {
      name,
      lastname,
      email,
      password
    })
    .then((response) => {
      if (response.data.accessToken) {
        
        //localStorage.setItem("user", JSON.stringify(response.data));
      }

      return response.data;
    });
};



const login = (user, password) => {
  return axios
    .post(API_URL, {
      user,
      password,
    })
    .then((response) => {
      console.log(response);
      if (response.data[0].jwtToken) {
        let token = response.data[0].jwtToken
        var base64Url = token.split('.')[1];
        var base64 = base64Url.replace('-', '+').replace('_', '/');
        let role =JSON.parse(window.atob(base64)) 
        window.localStorage.setItem("user", JSON.stringify(response.data[0]));
        window.localStorage.setItem("role", role.rol.authority);
        window.localStorage.setItem("info", JSON.stringify(response.data[1]));
        
      }

      return response.data;
    });
};

const logout = () => {
  localStorage.removeItem("user");
  localStorage.removeItem("info");
  localStorage.removeItem("role");
  
};

const getCurrentUser = () => {
  // return (localStorage.getItem("user"))
  return JSON.parse(localStorage.getItem("user"));
};

const getCurrentUserInfo = () => {
  // return (localStorage.getItem("user"))
  return JSON.parse(localStorage.getItem("info"));
};

const getCurrentUserRole = () => {
  // return (localStorage.getItem("user"))
  return (localStorage.getItem("role"));
};


const authService = {
  signup,
  login,
  logout,
  getCurrentUser,
  getCurrentUserInfo,
  getCurrentUserRole,
};

export default authService;
