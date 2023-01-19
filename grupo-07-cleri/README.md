Para el Front End:

Para poder iniciar el proyecto y poder visualizarlo lo que se debe hacer es clonar el mismo, ingresar a VS code u otro IDE de confianza, descargar node_modules con el comando npm install, agregar a la carpeta environments el siguiente archivo:

//Nombre del archivo: 
.env.local 

//Codigo a copiar en el archivo
REACT_APP_ENV=local
REACT_APP_API=http://localhost:8080 

Luego, npm run start:local para correr el FRONT END 

Para el Backend:  
Abrir el proyecto desde la carpeta backend/hospedajeDH 
Ingresar al archivo src > main > resources > application.yml 
Donde se deberá completar la informacion de la base de datos local
Correr la aplicacion

Para la Base de datos:
Se debe cargar el script que se encuentra en la carpeta Database y copiar el archivo Script.sql para cargar la información del sitio web

Cualquier consulta contactarse con Cleribethm@gmail.com

