#4 categorias
INSERT INTO hospedajes.category ( title,description, url) VALUES ('Hotel', '123.540 Hoteles', 'https://descubreteviajando.com/wp-content/uploads/2016/09/001.jpg');
INSERT INTO hospedajes.category ( title,description, url) VALUES ('Hostel',  '123.587 Hostel', 'https://www.palladiumhotelgroup.com/content/dam/palladium/content-fragments/hoteles/es/trs-ibiza-hotel/galeria/imagenes/hotel/02-TRS-IBIZA-PISCINA-GAIA_MG_6077-min.jpg.transform/rendition-md/image.jpg');
INSERT INTO hospedajes.category ( title,description, url) VALUES ('Departamentos','95.325 Departamento', 'https://www.zonaprop.com.ar/noticias/wp-content/uploads/2016/08/depto.jpg');
INSERT INTO hospedajes.category ( title,description, url) VALUES ('Bed and Breakfast','324.254 Bed and Breakfast', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQUOtkCkEnEP7ExGHYRrGj82DNTJXDD6ssbzM_ss1D_6ogLGqXT6Gc4R-pQwpi5iL8O8cU&usqp=CAU');

#20 ciudades
INSERT INTO hospedajes.city (country,location,name,postalcode) VALUES ('Argentina','Cordoba','Villa General Belgrano', 5194);
INSERT INTO hospedajes.city (country,location,name,postalcode) VALUES ('Argentina','Buenos Aires','Mar del Plata', 7600);
INSERT INTO hospedajes.city (country,location,name,postalcode) VALUES ('Argentina','Rio Negro','Bariloche',8400);
INSERT INTO hospedajes.city (country,location,name,postalcode) VALUES ('Argentina','Salta','Salta',4400);
INSERT INTO hospedajes.city (country,location,name,postalcode) VALUES ('Argentina','Misiones','Iguazú', 3370);
INSERT INTO hospedajes.city (country,location,name,postalcode) VALUES ('Argentina','Santa Fe','Rosario',2000);
INSERT INTO hospedajes.city (country,location,name,postalcode) VALUES ('Argentina','Santa Cruz','El Calafate',9405);
INSERT INTO hospedajes.city (country,location,name,postalcode) VALUES ('Argentina','Buenos Aires','Tandil',7000);
INSERT INTO hospedajes.city (country,location,name,postalcode) VALUES ('Argentina','Tierra del Fuego','Ushuaia',9410);
INSERT INTO hospedajes.city (country,location,name,postalcode) VALUES ('Argentina','Neuquén','San Martin de los Andes',8370);
INSERT INTO hospedajes.city (country,location,name,postalcode) VALUES ('Colombia','Magdalena','Santa Marta', 47001);
INSERT INTO hospedajes.city (country,location,name,postalcode) VALUES ('Colombia','Cundinamarca','Bogota', 110110);
INSERT INTO hospedajes.city (country,location,name,postalcode) VALUES ('Colombia','Bolivar','Cartagena', 30201);
INSERT INTO hospedajes.city (country,location,name,postalcode) VALUES ('Colombia','Atlantico','Barranquilla', 080001);
INSERT INTO hospedajes.city (country,location,name,postalcode) VALUES ('Colombia','Santander','Bucaramanga', 680001);
INSERT INTO hospedajes.city (country,location,name,postalcode) VALUES ('Colombia','Santander','Cúcuta', 540001);
INSERT INTO hospedajes.city (country,location,name,postalcode) VALUES ('Colombia','Córdoba','Montería', 230001);
INSERT INTO hospedajes.city (country,location,name,postalcode) VALUES ('Colombia','Quindio','Armenia', 630001);
INSERT INTO hospedajes.city (country,location,name,postalcode) VALUES ('Colombia','Bahia Solano','Chocó', 274057);
INSERT INTO hospedajes.city (country,location,name,postalcode) VALUES ('Colombia','La Guajira','Riohacha', 440001);

#7 caracteristicas
INSERT INTO hospedajes.feature(name) values('Televisor');
INSERT INTO hospedajes.feature(name) values('Cocina');
INSERT INTO hospedajes.feature(name) values('Estacionamiento gratuito');
INSERT INTO hospedajes.feature(name) values('Apto mascotas');
INSERT INTO hospedajes.feature(name) values('Aire acondicionado');
INSERT INTO hospedajes.feature(name) values('Pileta');
INSERT INTO hospedajes.feature(name) values('Wifi');

#4 Hoteles
INSERT INTO hospedajes.product (title, titledescription, description, houserules, healthandsafety, cancelattionpolicies, punctuation,city_id, category_id) VALUES ('Nuevo Hotizonte', 'Alojate en uno de los mas exclusivos de la zona', 'Exclusivo hotel en el centro de una ciudad unica', 'Check-out: 11:00. No fumar. No se permiten fiestas ', ' Se aplican las prácticas de seguridad contra la COVID-19. No consta que el alojamiento tenga un detector de humo ', ' Reembolso completo: recupera el 100 % de lo que pagaste.', 8, 11, 1);
INSERT INTO hospedajes.product (title, titledescription, description, houserules, healthandsafety, cancelattionpolicies, punctuation,city_id, category_id) VALUES ('Hotel Hermitage', 'Con vista al mar', 'Exclusivo hotel en el centro de una ciudad unica', 'Check-out: 11:00 No fumar. No se permiten fiestas', ' Se aplican las prácticas de seguridad contra la COVID-19. No consta que el alojamiento tenga un detector de humo ', ' Reembolso completo: recupera el 100 % de lo que pagaste.', 7, 2, 1);
INSERT INTO hospedajes.product (title, titledescription, description, houserules, healthandsafety, cancelattionpolicies, punctuation,city_id, category_id) VALUES ('Hotel del golf', 'Excelente ubicación', 'Exclusivo hotel en el centro de una ciudad unica', 'Check-out: 11:00 No fumar. No se permiten fiestas', ' Se aplican las prácticas de seguridad contra la COVID-19. No consta que el alojamiento tenga un detector de humo ', ' Reembolso completo: recupera el 100 % de lo que pagaste.', 9, 11, 1);
INSERT INTO hospedajes.product (title, titledescription, description, houserules, healthandsafety, cancelattionpolicies, punctuation,city_id, category_id) VALUES ('Hotel NH', 'Ideal para disfrutar en familia', 'Exclusivo hotel en el centro de una ciudad unica', 'Check-out: 11:00 No fumar.', ' Se aplican las prácticas de seguridad contra la COVID-19. No consta que el alojamiento tenga un detector de humo ', ' Reembolso completo: recupera el 100 % de lo que pagaste.', 7, 8, 1);

#4 Hosteles
INSERT INTO hospedajes.product (title, titledescription, description, houserules, healthandsafety, cancelattionpolicies, punctuation,city_id, category_id) VALUES ('Casona del Sol', 'Hostel para disfrutar la naturaleza', 'Armonioso hostel en el corazon de la naturaleza, podras disfrutar de una vista increible junto al confort que ofrece esta apasionante opcion', 'Check-in: 10:00 a 11:00 hs. No se admiten mascotas', ' Cámara de seguridad/dispositivo de grabación. Detector de humo', ' Consulta la política de cancelación completa ', 7, 2, 2);
INSERT INTO hospedajes.product (title, titledescription, description, houserules, healthandsafety, cancelattionpolicies, punctuation,city_id, category_id) VALUES ('Acantilados Hostel', 'Hostel para disfrutar con amigos', 'Armonioso hostel en el corazon de la naturaleza, podras disfrutar de una vista increible junto al confort que ofrece esta apasionante opcion', 'Check-in: 10:00 a 11:00 hs. No se admiten mascotas', ' Cámara de seguridad/dispositivo de grabación. Detector de humo', ' Consulta la política de cancelación completa ', 7, 5, 2);
INSERT INTO hospedajes.product (title, titledescription, description, houserules, healthandsafety, cancelattionpolicies, punctuation,city_id, category_id) VALUES ('Hostel La puerta', 'Hostel con excelente ubicación', 'Armonioso hostel en el corazon de la naturaleza, podras disfrutar de una vista increible junto al confort que ofrece esta apasionante opcion', 'Check-in: 10:00 a 11:00 hs. No se admiten mascotas', ' Cámara de seguridad/dispositivo de grabación. Detector de humo', ' Consulta la política de cancelación completa ', 9, 11, 2);
INSERT INTO hospedajes.product (title, titledescription, description, houserules, healthandsafety, cancelattionpolicies, punctuation,city_id, category_id) VALUES ('Hostel Puerto Alegre', 'Hostel a dos cuadras del mar', 'Armonioso hostel en el corazon de la naturaleza, podras disfrutar de una vista increible junto al confort que ofrece esta apasionante opcion', 'Check-in: 10:00 a 11:00 hs. No se admiten mascotas', ' Cámara de seguridad/dispositivo de grabación. Detector de humo', ' Consulta la política de cancelación completa ', 10, 8, 2);

#4 Departamentos
INSERT INTO hospedajes.product (title, titledescription, description, houserules, healthandsafety, cancelattionpolicies, punctuation,city_id, category_id) VALUES ('Departamento Luxury', 'Departamento exclusivo', 'Increible departamento con todas las comodidades que uno necesita para una estadia mas que confortable', 'Check-in: 14:00 hs. Check-out: 16:00 hs. Prohibido fumar. No se permiten fiestas o eventos', ' Alarma de monoxido de carbono. Alarma de humo', ' Esta reserva no es reembolsable. Consulta la política de cancelación completa del anfitrión', 9,11, 3);
INSERT INTO hospedajes.product (title, titledescription, description, houserules, healthandsafety, cancelattionpolicies, punctuation,city_id, category_id) VALUES ('Sucre suitis', 'Departamento con vista al mar', 'Increible departamento con todas las comodidades que uno necesita para una estadia mas que confortable', 'Check-in: 14:00 hs. Check-out: 16:00 hs. Prohibido fumar. No se permiten fiestas o eventos', ' Alarma de monoxido de carbono. Alarma de humo', ' Esta reserva no es reembolsable. Consulta la política de cancelación completa del anfitrión', 7,5, 3);
INSERT INTO hospedajes.product (title, titledescription, description, houserules, healthandsafety, cancelattionpolicies, punctuation,city_id, category_id) VALUES ('Recoleta Apartment', 'Departamento con excelente ubicación', 'Increible departamento con todas las comodidades que uno necesita para una estadia mas que confortable', 'Check-in: 14:00 hs. Check-out: 16:00 hs. Prohibido fumar. No se permiten fiestas o eventos', ' Alarma de monoxido de carbono. Alarma de humo', ' Esta reserva no es reembolsable. Consulta la política de cancelación completa del anfitrión', 7,12, 3);
INSERT INTO hospedajes.product (title, titledescription, description, houserules, healthandsafety, cancelattionpolicies, punctuation,city_id, category_id) VALUES ('Luxury Loft', 'Departamento calido y luminoso', 'Increible departamento con todas las comodidades que uno necesita para una estadia mas que confortable', 'Check-in: 14:00 hs. Check-out: 16:00 hs. Prohibido fumar. No se permiten fiestas o eventos', ' Alarma de monoxido de carbono. Alarma de humo', ' Esta reserva no es reembolsable. Consulta la política de cancelación completa del anfitrión', 8,8, 3);

#4 B&B
INSERT INTO hospedajes.product (title, titledescription, description, houserules, healthandsafety, cancelattionpolicies, punctuation, city_id, category_id) VALUES ('Casa balcón', 'Armonioso bed and breakfast', ' Todas nuestras habitaciones  tienen terraza y vistas panorámicas a la ciudad. Destacamos el confort y el buen gusto. Cuidamos el más mínimo detalle, haciendo de tu estancia una visita inolvidable.', 'Llegada: 15:00 a 23:00. No se admiten mascotas. No se permite fiestas y/o eventos. Prohibido fumar', 'No hay alarma de monóxido de carbono. Alarma de humos', ' Consulta la política de cancelación completa del anfitrión', 7, 5, 4);
INSERT INTO hospedajes.product (title, titledescription, description, houserules, healthandsafety, cancelattionpolicies, punctuation, city_id, category_id) VALUES ('Barcelona B&B', 'Sentite comodo y a gusto en este bed and breakfast', ' Todas nuestras habitaciones  tienen terraza y vistas panorámicas a la ciudad. Destacamos el confort y el buen gusto. Cuidamos el más mínimo detalle, haciendo de tu estancia una visita inolvidable.', 'Llegada: 15:00 a 23:00. No se admiten mascotas. No se permite fiestas y/o eventos. Prohibido fumar', 'No hay alarma de monóxido de carbono. Alarma de humos', ' Consulta la política de cancelación completa del anfitrión', 9, 11, 4);
INSERT INTO hospedajes.product (title, titledescription, description, houserules, healthandsafety, cancelattionpolicies, punctuation, city_id, category_id) VALUES ('Casa Urban B&B', 'Exclusivo bed and breakfast', ' Todas nuestras habitaciones  tienen terraza y vistas panorámicas a la ciudad. Destacamos el confort y el buen gusto. Cuidamos el más mínimo detalle, haciendo de tu estancia una visita inolvidable.', 'Llegada: 15:00 a 23:00. No se admiten mascotas. No se permite fiestas y/o eventos. Prohibido fumar', 'No hay alarma de monóxido de carbono. Alarma de humos', ' Consulta la política de cancelación completa del anfitrión', 8, 12, 4);
INSERT INTO hospedajes.product (title, titledescription, description, houserules, healthandsafety, cancelattionpolicies, punctuation, city_id, category_id) VALUES ('Casona del sol B&B', 'Bed and breakfast para disfrutar en familia', ' Todas nuestras habitaciones  tienen terraza y vistas panorámicas a la ciudad. Destacamos el confort y el buen gusto. Cuidamos el más mínimo detalle, haciendo de tu estancia una visita inolvidable.', 'Llegada: 15:00 a 23:00. No se admiten mascotas. No se permite fiestas y/o eventos. Prohibido fumar', 'No hay alarma de monóxido de carbono. Alarma de humos', ' Consulta la política de cancelación completa del anfitrión', 10, 8, 4);


#5 Imagenes por producto
INSERT INTO hospedajes.image (title, url, product_id) values ('bed and breakfast', 'https://static.hosteltur.com/app/public/uploads/img/articles/2015/08/01/L_5c1a43aeea480_breakfast.jpg', 15);
INSERT INTO hospedajes.image (title, url, product_id) values ('bed and breakfast', 'https://cf.bstatic.com/xdata/images/hotel/max1024x768/263391552.jpg?k=77c466bf3439a93b0c2a4fe5660e23e1add5e5b940b0eff35eaa224b461d95a3&o=&hp=1', 15);
INSERT INTO hospedajes.image (title, url, product_id) values ('bed and breakfast', 'https://dynaimage.cdn.cnn.com/cnn/c_fill,g_auto,w_1200,h_675,ar_16:9/https%3A%2F%2Fcdn.cnn.com%2Fcnnnext%2Fdam%2Fassets%2F220908140555-01-big-breakfast-stock.jpeg', 15);
INSERT INTO hospedajes.image (title, url, product_id) values ('bed and breakfast', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRbIsBkVh6KzHO1RQUTsxVf-GkZMq-4sL-IVNRGBfzZj6cFD2iWFOfglT-1eceJiuF3RZU&usqp=CAU', 15);
INSERT INTO hospedajes.image (title, url, product_id) values ('bed and breakfast', 'https://www.bedandbreakfast.eu/blog/wp-content/uploads/2015/11/bb_italy_breakfast.jpg', 15);

INSERT INTO hospedajes.image (title, url, product_id) values ('bed and breakfast', 'https://static.hosteltur.com/app/public/uploads/img/articles/2015/08/01/L_5c1a43aeea480_breakfast.jpg', 13);
INSERT INTO hospedajes.image (title, url, product_id) values ('bed and breakfast', 'https://cf.bstatic.com/xdata/images/hotel/max1024x768/263391552.jpg?k=77c466bf3439a93b0c2a4fe5660e23e1add5e5b940b0eff35eaa224b461d95a3&o=&hp=1', 13);
INSERT INTO hospedajes.image (title, url, product_id) values ('bed and breakfast', 'https://dynaimage.cdn.cnn.com/cnn/c_fill,g_auto,w_1200,h_675,ar_16:9/https%3A%2F%2Fcdn.cnn.com%2Fcnnnext%2Fdam%2Fassets%2F220908140555-01-big-breakfast-stock.jpeg', 13);
INSERT INTO hospedajes.image (title, url, product_id) values ('bed and breakfast', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRbIsBkVh6KzHO1RQUTsxVf-GkZMq-4sL-IVNRGBfzZj6cFD2iWFOfglT-1eceJiuF3RZU&usqp=CAU', 13);
INSERT INTO hospedajes.image (title, url, product_id) values ('bed and breakfast', 'https://www.bedandbreakfast.eu/blog/wp-content/uploads/2015/11/bb_italy_breakfast.jpg', 13);

INSERT INTO hospedajes.image (title, url, product_id) values ('bed and breakfast', 'https://static.hosteltur.com/app/public/uploads/img/articles/2015/08/01/L_5c1a43aeea480_breakfast.jpg', 14);
INSERT INTO hospedajes.image (title, url, product_id) values ('bed and breakfast', 'https://cf.bstatic.com/xdata/images/hotel/max1024x768/263391552.jpg?k=77c466bf3439a93b0c2a4fe5660e23e1add5e5b940b0eff35eaa224b461d95a3&o=&hp=1', 14);
INSERT INTO hospedajes.image (title, url, product_id) values ('bed and breakfast', 'https://dynaimage.cdn.cnn.com/cnn/c_fill,g_auto,w_1200,h_675,ar_16:9/https%3A%2F%2Fcdn.cnn.com%2Fcnnnext%2Fdam%2Fassets%2F220908140555-01-big-breakfast-stock.jpeg', 14);
INSERT INTO hospedajes.image (title, url, product_id) values ('bed and breakfast', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRbIsBkVh6KzHO1RQUTsxVf-GkZMq-4sL-IVNRGBfzZj6cFD2iWFOfglT-1eceJiuF3RZU&usqp=CAU', 14);
INSERT INTO hospedajes.image (title, url, product_id) values ('bed and breakfast', 'https://www.bedandbreakfast.eu/blog/wp-content/uploads/2015/11/bb_italy_breakfast.jpg', 14);


INSERT INTO hospedajes.image (title, url, product_id) values ('bed and breakfast', 'https://static.hosteltur.com/app/public/uploads/img/articles/2015/08/01/L_5c1a43aeea480_breakfast.jpg', 16);
INSERT INTO hospedajes.image (title, url, product_id) values ('bed and breakfast', 'https://cf.bstatic.com/xdata/images/hotel/max1024x768/263391552.jpg?k=77c466bf3439a93b0c2a4fe5660e23e1add5e5b940b0eff35eaa224b461d95a3&o=&hp=1', 16);
INSERT INTO hospedajes.image (title, url, product_id) values ('bed and breakfast', 'https://dynaimage.cdn.cnn.com/cnn/c_fill,g_auto,w_1200,h_675,ar_16:9/https%3A%2F%2Fcdn.cnn.com%2Fcnnnext%2Fdam%2Fassets%2F220908140555-01-big-breakfast-stock.jpeg', 16);
INSERT INTO hospedajes.image (title, url, product_id) values ('bed and breakfast', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRbIsBkVh6KzHO1RQUTsxVf-GkZMq-4sL-IVNRGBfzZj6cFD2iWFOfglT-1eceJiuF3RZU&usqp=CAU', 16);
INSERT INTO hospedajes.image (title, url, product_id) values ('bed and breakfast', 'https://www.bedandbreakfast.eu/blog/wp-content/uploads/2015/11/bb_italy_breakfast.jpg', 16);


INSERT INTO hospedajes.image (title, url, product_id) values ('Hotel 1', 'https://www.palladiumhotelgroup.com/content/dam/palladium/content-fragments/hoteles/es/trs-ibiza-hotel/galeria/imagenes/hotel/02-TRS-IBIZA-PISCINA-GAIA_MG_6077-min.jpg.transform/rendition-md/image.jpg', 1);
INSERT INTO hospedajes.image (title, url, product_id) values ('Hotel 1', 'https://www.palladiumhotelgroup.com/content/dam/palladium/content-fragments/hoteles/es/trs-ibiza-hotel/galeria/imagenes/hotel/02-TRS-IBIZA-PISCINA-GAIA_MG_6077-min.jpg.transform/rendition-md/image.jpg', 2);
INSERT INTO hospedajes.image (title, url, product_id) values ('Hotel 1', 'https://www.palladiumhotelgroup.com/content/dam/palladium/content-fragments/hoteles/es/trs-ibiza-hotel/galeria/imagenes/hotel/02-TRS-IBIZA-PISCINA-GAIA_MG_6077-min.jpg.transform/rendition-md/image.jpg', 3);
INSERT INTO hospedajes.image (title, url, product_id) values ('Hotel 1', 'https://www.palladiumhotelgroup.com/content/dam/palladium/content-fragments/hoteles/es/trs-ibiza-hotel/galeria/imagenes/hotel/02-TRS-IBIZA-PISCINA-GAIA_MG_6077-min.jpg.transform/rendition-md/image.jpg', 4);

INSERT INTO hospedajes.image (title, url, product_id) values ('Hotel 2', 'https://media.istockphoto.com/id/908258590/es/foto/render-3d-de-entrada-del-hotel-y-recepci%C3%B3n.jpg?s=612x612&w=0&k=20&c=buzWvYnreV3ulLlIyIILEWxn48qjxa3NQhJqPz0rwps=', 1);
INSERT INTO hospedajes.image (title, url, product_id) values ('Hotel 2', 'https://media.istockphoto.com/id/908258590/es/foto/render-3d-de-entrada-del-hotel-y-recepci%C3%B3n.jpg?s=612x612&w=0&k=20&c=buzWvYnreV3ulLlIyIILEWxn48qjxa3NQhJqPz0rwps=', 2);
INSERT INTO hospedajes.image (title, url, product_id) values ('Hotel 2', 'https://media.istockphoto.com/id/908258590/es/foto/render-3d-de-entrada-del-hotel-y-recepci%C3%B3n.jpg?s=612x612&w=0&k=20&c=buzWvYnreV3ulLlIyIILEWxn48qjxa3NQhJqPz0rwps=', 3);
INSERT INTO hospedajes.image (title, url, product_id) values ('Hotel 2', 'https://media.istockphoto.com/id/908258590/es/foto/render-3d-de-entrada-del-hotel-y-recepci%C3%B3n.jpg?s=612x612&w=0&k=20&c=buzWvYnreV3ulLlIyIILEWxn48qjxa3NQhJqPz0rwps=', 4);

INSERT INTO hospedajes.image (title, url, product_id) values ('Hotel 3', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRbIsBkVh6KzHO1RQUTsxVf-GkZMq-4sL-IVNRGBfzZj6cFD2iWFOfglT-1eceJiuF3RZU&usqp=CAU', 1);
INSERT INTO hospedajes.image (title, url, product_id) values ('Hotel 3', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRbIsBkVh6KzHO1RQUTsxVf-GkZMq-4sL-IVNRGBfzZj6cFD2iWFOfglT-1eceJiuF3RZU&usqp=CAU', 2);
INSERT INTO hospedajes.image (title, url, product_id) values ('Hotel 3', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRbIsBkVh6KzHO1RQUTsxVf-GkZMq-4sL-IVNRGBfzZj6cFD2iWFOfglT-1eceJiuF3RZU&usqp=CAU', 3);
INSERT INTO hospedajes.image (title, url, product_id) values ('Hotel 3', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRbIsBkVh6KzHO1RQUTsxVf-GkZMq-4sL-IVNRGBfzZj6cFD2iWFOfglT-1eceJiuF3RZU&usqp=CAU', 4);

INSERT INTO hospedajes.image (title, url, product_id) values ('Hotel 4', 'https://media.cntraveler.com/photos/59dc0961d74f3663416ffe8b/3:2/w_2046,h_1364,c_limit/Pool-COMOMetropolitanMiamiBeach-Florida-CRHotel.jpg', 1);
INSERT INTO hospedajes.image (title, url, product_id) values ('Hotel 4', 'https://media.cntraveler.com/photos/59dc0961d74f3663416ffe8b/3:2/w_2046,h_1364,c_limit/Pool-COMOMetropolitanMiamiBeach-Florida-CRHotel.jpg', 2);
INSERT INTO hospedajes.image (title, url, product_id) values ('Hotel 4', 'https://media.cntraveler.com/photos/59dc0961d74f3663416ffe8b/3:2/w_2046,h_1364,c_limit/Pool-COMOMetropolitanMiamiBeach-Florida-CRHotel.jpg', 3);
INSERT INTO hospedajes.image (title, url, product_id) values ('Hotel 4', 'https://media.cntraveler.com/photos/59dc0961d74f3663416ffe8b/3:2/w_2046,h_1364,c_limit/Pool-COMOMetropolitanMiamiBeach-Florida-CRHotel.jpg', 4);

INSERT INTO hospedajes.image (title, url, product_id) values ('Hotel 5', 'https://www.almanacnews.com/news/photos/2021/november/2/57299_col.jpg', 1);
INSERT INTO hospedajes.image (title, url, product_id) values ('Hotel 5', 'https://www.almanacnews.com/news/photos/2021/november/2/57299_col.jpg', 2);
INSERT INTO hospedajes.image (title, url, product_id) values ('Hotel 5', 'https://www.almanacnews.com/news/photos/2021/november/2/57299_col.jpg', 3);
INSERT INTO hospedajes.image (title, url, product_id) values ('Hotel 5', 'https://www.almanacnews.com/news/photos/2021/november/2/57299_col.jpg', 4);

INSERT INTO hospedajes.image (title, url, product_id) values ('Hostel 1', 'https://milhousehostel.com/wp-content/uploads/2021/03/4476180-1394672_702_0_3538_2829_1000_800-605x605.jpg', 5);
INSERT INTO hospedajes.image (title, url, product_id) values ('Hostel 1', 'https://milhousehostel.com/wp-content/uploads/2021/03/4476180-1394672_702_0_3538_2829_1000_800-605x605.jpg', 6);
INSERT INTO hospedajes.image (title, url, product_id) values ('Hostel 1', 'https://milhousehostel.com/wp-content/uploads/2021/03/4476180-1394672_702_0_3538_2829_1000_800-605x605.jpg', 7);
INSERT INTO hospedajes.image (title, url, product_id) values ('Hostel 1', 'https://milhousehostel.com/wp-content/uploads/2021/03/4476180-1394672_702_0_3538_2829_1000_800-605x605.jpg', 8);
 
INSERT INTO hospedajes.image (title, url, product_id) values ('Hostel 2', 'https://cf.bstatic.com/xdata/images/hotel/max1024x768/263391552.jpg?k=77c466bf3439a93b0c2a4fe5660e23e1add5e5b940b0eff35eaa224b461d95a3&o=&hp=1', 5);
INSERT INTO hospedajes.image (title, url, product_id) values ('Hostel 2', 'https://cf.bstatic.com/xdata/images/hotel/max1024x768/263391552.jpg?k=77c466bf3439a93b0c2a4fe5660e23e1add5e5b940b0eff35eaa224b461d95a3&o=&hp=1', 6);
INSERT INTO hospedajes.image (title, url, product_id) values ('Hostel 2', 'https://cf.bstatic.com/xdata/images/hotel/max1024x768/263391552.jpg?k=77c466bf3439a93b0c2a4fe5660e23e1add5e5b940b0eff35eaa224b461d95a3&o=&hp=1', 7);
INSERT INTO hospedajes.image (title, url, product_id) values ('Hostel 2', 'https://cf.bstatic.com/xdata/images/hotel/max1024x768/263391552.jpg?k=77c466bf3439a93b0c2a4fe5660e23e1add5e5b940b0eff35eaa224b461d95a3&o=&hp=1', 8);

INSERT INTO hospedajes.image (title, url, product_id) values ('Hostel 3', 'https://hqbeds.com/wp-content/uploads/2019/11/hostel1-e1573156979842.jpg',  5);
INSERT INTO hospedajes.image (title, url, product_id) values ('Hostel 3', 'https://hqbeds.com/wp-content/uploads/2019/11/hostel1-e1573156979842.jpg',  6);
INSERT INTO hospedajes.image (title, url, product_id) values ('Hostel 3', 'https://hqbeds.com/wp-content/uploads/2019/11/hostel1-e1573156979842.jpg',  7);
INSERT INTO hospedajes.image (title, url, product_id) values ('Hostel 3', 'https://hqbeds.com/wp-content/uploads/2019/11/hostel1-e1573156979842.jpg',  8);


INSERT INTO hospedajes.image (title, url, product_id) values ('Hostel 4', 'https://cf.bstatic.com/xdata/images/hotel/max1024x768/296554071.jpg?k=895c8920044643a4dffea5ef322d8157f094e0142d3d8d9281b21ab08bca69a7&o=&hp=1', 5);
INSERT INTO hospedajes.image (title, url, product_id) values ('Hostel 4', 'https://cf.bstatic.com/xdata/images/hotel/max1024x768/296554071.jpg?k=895c8920044643a4dffea5ef322d8157f094e0142d3d8d9281b21ab08bca69a7&o=&hp=1', 6);
INSERT INTO hospedajes.image (title, url, product_id) values ('Hostel 4', 'https://cf.bstatic.com/xdata/images/hotel/max1024x768/296554071.jpg?k=895c8920044643a4dffea5ef322d8157f094e0142d3d8d9281b21ab08bca69a7&o=&hp=1', 7);
INSERT INTO hospedajes.image (title, url, product_id) values ('Hostel 4', 'https://cf.bstatic.com/xdata/images/hotel/max1024x768/296554071.jpg?k=895c8920044643a4dffea5ef322d8157f094e0142d3d8d9281b21ab08bca69a7&o=&hp=1', 8);

INSERT INTO hospedajes.image (title, url, product_id) values ('Hostel 5', 'https://www.marazzigroup.com/media/filer_public_thumbnails/filer_public/11/85/1185e6af-1b31-40cc-b396-0b5dab9aceca/marazzi_horeca_lobby_hotel_001.jpg__1920x0_q75_crop_subsampling-2.jpg', 5);
INSERT INTO hospedajes.image (title, url, product_id) values ('Hostel 5', 'https://www.marazzigroup.com/media/filer_public_thumbnails/filer_public/11/85/1185e6af-1b31-40cc-b396-0b5dab9aceca/marazzi_horeca_lobby_hotel_001.jpg__1920x0_q75_crop_subsampling-2.jpg', 6);
INSERT INTO hospedajes.image (title, url, product_id) values ('Hostel 5', 'https://www.marazzigroup.com/media/filer_public_thumbnails/filer_public/11/85/1185e6af-1b31-40cc-b396-0b5dab9aceca/marazzi_horeca_lobby_hotel_001.jpg__1920x0_q75_crop_subsampling-2.jpg', 7);
INSERT INTO hospedajes.image (title, url, product_id) values ('Hostel 5', 'https://www.marazzigroup.com/media/filer_public_thumbnails/filer_public/11/85/1185e6af-1b31-40cc-b396-0b5dab9aceca/marazzi_horeca_lobby_hotel_001.jpg__1920x0_q75_crop_subsampling-2.jpg', 8);


INSERT INTO hospedajes.image (title, url, product_id) values ('Departamento 1', 'https://www.triada.com.pe/noticias/wp-content/uploads/2019/07/triada-aprovechar-espacios-departamento-pequeno.jpg', 9);
INSERT INTO hospedajes.image (title, url, product_id) values ('Departamento 1', 'https://www.triada.com.pe/noticias/wp-content/uploads/2019/07/triada-aprovechar-espacios-departamento-pequeno.jpg', 10);
INSERT INTO hospedajes.image (title, url, product_id) values ('Departamento 1', 'https://www.triada.com.pe/noticias/wp-content/uploads/2019/07/triada-aprovechar-espacios-departamento-pequeno.jpg', 11);
INSERT INTO hospedajes.image (title, url, product_id) values ('Departamento 1', 'https://www.triada.com.pe/noticias/wp-content/uploads/2019/07/triada-aprovechar-espacios-departamento-pequeno.jpg', 12);

INSERT INTO hospedajes.image (title, url, product_id) values ('Departamento 2', 'https://i.pinimg.com/736x/0d/1e/6d/0d1e6d886d320b15c17bb18cff2a8b85.jpg', 9);
INSERT INTO hospedajes.image (title, url, product_id) values ('Departamento 2', 'https://i.pinimg.com/736x/0d/1e/6d/0d1e6d886d320b15c17bb18cff2a8b85.jpg', 10);
INSERT INTO hospedajes.image (title, url, product_id) values ('Departamento 2', 'https://i.pinimg.com/736x/0d/1e/6d/0d1e6d886d320b15c17bb18cff2a8b85.jpg', 11);
INSERT INTO hospedajes.image (title, url, product_id) values ('Departamento 2', 'https://i.pinimg.com/736x/0d/1e/6d/0d1e6d886d320b15c17bb18cff2a8b85.jpg', 12);

INSERT INTO hospedajes.image (title, url, product_id) values ('Departamento 3', 'https://webmediums.com/media/webp_max_1600/1*imXHUKcEN7HP5jSEnz85Ew*png.webp', 9);
INSERT INTO hospedajes.image (title, url, product_id) values ('Departamento 3', 'https://webmediums.com/media/webp_max_1600/1*imXHUKcEN7HP5jSEnz85Ew*png.webp', 10);
INSERT INTO hospedajes.image (title, url, product_id) values ('Departamento 3', 'https://webmediums.com/media/webp_max_1600/1*imXHUKcEN7HP5jSEnz85Ew*png.webp', 11);
INSERT INTO hospedajes.image (title, url, product_id) values ('Departamento 3', 'https://webmediums.com/media/webp_max_1600/1*imXHUKcEN7HP5jSEnz85Ew*png.webp', 12);

INSERT INTO hospedajes.image (title, url, product_id) values ('Departamento 4', 'https://www.zonaprop.com.ar/noticias/wp-content/uploads/2016/08/depto.jpg', 9);
INSERT INTO hospedajes.image (title, url, product_id) values ('Departamento 4', 'https://www.zonaprop.com.ar/noticias/wp-content/uploads/2016/08/depto.jpg', 10);
INSERT INTO hospedajes.image (title, url, product_id) values ('Departamento 4', 'https://www.zonaprop.com.ar/noticias/wp-content/uploads/2016/08/depto.jpg', 11);
INSERT INTO hospedajes.image (title, url, product_id) values ('Departamento 4', 'https://www.zonaprop.com.ar/noticias/wp-content/uploads/2016/08/depto.jpg', 12);

INSERT INTO hospedajes.image (title, url, product_id) values ('Departamento 5', 'https://www.sancharbel.pe/blog/wp-content/uploads/2018/06/san-charbel-departamento-dormitorio-redecoracion.jpg', 9);
INSERT INTO hospedajes.image (title, url, product_id) values ('Departamento 5', 'https://www.sancharbel.pe/blog/wp-content/uploads/2018/06/san-charbel-departamento-dormitorio-redecoracion.jpg', 10);
INSERT INTO hospedajes.image (title, url, product_id) values ('Departamento 5', 'https://www.sancharbel.pe/blog/wp-content/uploads/2018/06/san-charbel-departamento-dormitorio-redecoracion.jpg', 11);
INSERT INTO hospedajes.image (title, url, product_id) values ('Departamento 5', 'https://www.sancharbel.pe/blog/wp-content/uploads/2018/06/san-charbel-departamento-dormitorio-redecoracion.jpg', 12);


# carateristica por producto
INSERT INTO hospedajes.product_has_features (idproduct, idfeature) values(1,1);
INSERT INTO hospedajes.product_has_features (idproduct, idfeature) values(1,2);
INSERT INTO hospedajes.product_has_features (idproduct, idfeature) values(1,3);
INSERT INTO hospedajes.product_has_features (idproduct, idfeature) values(1,5);
INSERT INTO hospedajes.product_has_features (idproduct, idfeature) values(1,7);
INSERT INTO hospedajes.product_has_features (idproduct, idfeature) values(2,6);
INSERT INTO hospedajes.product_has_features (idproduct, idfeature) values(2,5);
INSERT INTO hospedajes.product_has_features (idproduct, idfeature) values(2,1);
INSERT INTO hospedajes.product_has_features (idproduct, idfeature) values(2,3);
INSERT INTO hospedajes.product_has_features (idproduct, idfeature) values(2,4);
INSERT INTO hospedajes.product_has_features (idproduct, idfeature) values(2,2);
INSERT INTO hospedajes.product_has_features (idproduct, idfeature) values(3,1);
INSERT INTO hospedajes.product_has_features (idproduct, idfeature) values(3,2);
INSERT INTO hospedajes.product_has_features (idproduct, idfeature) values(3,3);
INSERT INTO hospedajes.product_has_features (idproduct, idfeature) values(3,5);
INSERT INTO hospedajes.product_has_features (idproduct, idfeature) values(3,6);
INSERT INTO hospedajes.product_has_features (idproduct, idfeature) values(3,7);
INSERT INTO hospedajes.product_has_features (idproduct, idfeature) values(4,7);
INSERT INTO hospedajes.product_has_features (idproduct, idfeature) values(4,3);
INSERT INTO hospedajes.product_has_features (idproduct, idfeature) values(4,2);
INSERT INTO hospedajes.product_has_features (idproduct, idfeature) values(4,5);
INSERT INTO hospedajes.product_has_features (idproduct, idfeature) values(5,1);
INSERT INTO hospedajes.product_has_features (idproduct, idfeature) values(5,4);
INSERT INTO hospedajes.product_has_features (idproduct, idfeature) values(5,7);
INSERT INTO hospedajes.product_has_features (idproduct, idfeature) values(5,3);
INSERT INTO hospedajes.product_has_features (idproduct, idfeature) values(5,2);
INSERT INTO hospedajes.product_has_features (idproduct, idfeature) values(5,5);


INSERT INTO hospedajes.product_has_features (idproduct, idfeature) values(6,7);
INSERT INTO hospedajes.product_has_features (idproduct, idfeature) values(6,3);
INSERT INTO hospedajes.product_has_features (idproduct, idfeature) values(6,5);
INSERT INTO hospedajes.product_has_features (idproduct, idfeature) values(6,1);
INSERT INTO hospedajes.product_has_features (idproduct, idfeature) values(6,4);

INSERT INTO hospedajes.product_has_features (idproduct, idfeature) values(7,7);
INSERT INTO hospedajes.product_has_features (idproduct, idfeature) values(7,3);
INSERT INTO hospedajes.product_has_features (idproduct, idfeature) values(7,2);
INSERT INTO hospedajes.product_has_features (idproduct, idfeature) values(7,1);
INSERT INTO hospedajes.product_has_features (idproduct, idfeature) values(7,4);

INSERT INTO hospedajes.product_has_features (idproduct, idfeature) values(8,7);
INSERT INTO hospedajes.product_has_features (idproduct, idfeature) values(8,3);
INSERT INTO hospedajes.product_has_features (idproduct, idfeature) values(8,2);
INSERT INTO hospedajes.product_has_features (idproduct, idfeature) values(8,5);
INSERT INTO hospedajes.product_has_features (idproduct, idfeature) values(8,4);

INSERT INTO hospedajes.product_has_features (idproduct, idfeature) values(9,7);
INSERT INTO hospedajes.product_has_features (idproduct, idfeature) values(9,3);
INSERT INTO hospedajes.product_has_features (idproduct, idfeature) values(9,1);
INSERT INTO hospedajes.product_has_features (idproduct, idfeature) values(9,6);
INSERT INTO hospedajes.product_has_features (idproduct, idfeature) values(9,4);

INSERT INTO hospedajes.product_has_features (idproduct, idfeature) values(10,7);
INSERT INTO hospedajes.product_has_features (idproduct, idfeature) values(10,3);
INSERT INTO hospedajes.product_has_features (idproduct, idfeature) values(10,2);
INSERT INTO hospedajes.product_has_features (idproduct, idfeature) values(10,1);
INSERT INTO hospedajes.product_has_features (idproduct, idfeature) values(10,6);
INSERT INTO hospedajes.product_has_features (idproduct, idfeature) values(10,4);

INSERT INTO hospedajes.product_has_features (idproduct, idfeature) values(11,7);
INSERT INTO hospedajes.product_has_features (idproduct, idfeature) values(11,3);
INSERT INTO hospedajes.product_has_features (idproduct, idfeature) values(11,2);
INSERT INTO hospedajes.product_has_features (idproduct, idfeature) values(11,6);
INSERT INTO hospedajes.product_has_features (idproduct, idfeature) values(11,4);

INSERT INTO hospedajes.product_has_features (idproduct, idfeature) values(12,7);
INSERT INTO hospedajes.product_has_features (idproduct, idfeature) values(12,3);
INSERT INTO hospedajes.product_has_features (idproduct, idfeature) values(12,2);
INSERT INTO hospedajes.product_has_features (idproduct, idfeature) values(12,5);
INSERT INTO hospedajes.product_has_features (idproduct, idfeature) values(12,1);

INSERT INTO hospedajes.product_has_features (idproduct, idfeature) values(13,7);
INSERT INTO hospedajes.product_has_features (idproduct, idfeature) values(13,3);
INSERT INTO hospedajes.product_has_features (idproduct, idfeature) values(13,1);
INSERT INTO hospedajes.product_has_features (idproduct, idfeature) values(13,6);
INSERT INTO hospedajes.product_has_features (idproduct, idfeature) values(13,4);


INSERT INTO hospedajes.product_has_features (idproduct, idfeature) values(14,7);
INSERT INTO hospedajes.product_has_features (idproduct, idfeature) values(14,3);
INSERT INTO hospedajes.product_has_features (idproduct, idfeature) values(14,2);
INSERT INTO hospedajes.product_has_features (idproduct, idfeature) values(14,5);
INSERT INTO hospedajes.product_has_features (idproduct, idfeature) values(14,1);
INSERT INTO hospedajes.product_has_features (idproduct, idfeature) values(14,4);

INSERT INTO hospedajes.product_has_features (idproduct, idfeature) values(15,7);
INSERT INTO hospedajes.product_has_features (idproduct, idfeature) values(15,3);
INSERT INTO hospedajes.product_has_features (idproduct, idfeature) values(15,2);
INSERT INTO hospedajes.product_has_features (idproduct, idfeature) values(15,1);
INSERT INTO hospedajes.product_has_features (idproduct, idfeature) values(15,6);
INSERT INTO hospedajes.product_has_features (idproduct, idfeature) values(15,4);

INSERT INTO hospedajes.product_has_features (idproduct, idfeature) values(16,3);
INSERT INTO hospedajes.product_has_features (idproduct, idfeature) values(16,2);
INSERT INTO hospedajes.product_has_features (idproduct, idfeature) values(16,5);
INSERT INTO hospedajes.product_has_features (idproduct, idfeature) values(16,1);
INSERT INTO hospedajes.product_has_features (idproduct, idfeature) values(16,6);
INSERT INTO hospedajes.product_has_features (idproduct, idfeature) values(16,4);