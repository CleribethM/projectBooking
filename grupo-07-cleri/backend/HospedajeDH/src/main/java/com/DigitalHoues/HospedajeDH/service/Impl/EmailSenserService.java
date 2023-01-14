package com.DigitalHoues.HospedajeDH.service.Impl;

import com.DigitalHoues.HospedajeDH.dto.BookingDTO;
import com.DigitalHoues.HospedajeDH.dto.UserClientDTO;
import com.DigitalHoues.HospedajeDH.entities.Product;
import com.DigitalHoues.HospedajeDH.entities.UserClient;
import com.DigitalHoues.HospedajeDH.exception.NotFoundException;
import com.DigitalHoues.HospedajeDH.repository.BookingForClienteRepository;
import com.DigitalHoues.HospedajeDH.repository.ProductRepository;
import com.DigitalHoues.HospedajeDH.repository.UserClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.util.ArrayList;

import java.util.Optional;
import java.util.Properties;


@Service
public class EmailSenserService {

    @Autowired
    JavaMailSender mailSender;

    @Autowired
    UserClientRepository userClientRepository;

    @Autowired
    BookingForClienteRepository bfr;

    @Autowired
    ProductRepository productRepository;

    public void sendEmail(UserClientDTO user){
        ArrayList<UserClientDTO> us = new ArrayList<>();
        us.add(user);


        SimpleMailMessage message =new SimpleMailMessage();
        message.setFrom("BookingGrupo7@gmail.com");
        message.setTo(us.get(0).getEmail());
        message.setText("Hola " + us.get(0).getName() + "!" + '\n' +  '\n' +
                "Gracias por regístrate en BookingG7, el lugar donde podrás gestionar tus reservar de hoteles favoritos." + '\n' +  '\n' +
                "En bookingG7 podrás encontrar hoteles con desayunos incluidos, Hosteles de tus ciudades favoritas, con amplios espacios sociales, piscina, restaurantes y demás." + '\n' +
                "No olvides revisar las normas de cada lugar para evitar inconvenientes con tu reservas. Debe tener encuentra la hora del CheckIn y CheckOut." + '\n' +  '\n' +
                "Recuerda suscribirte a nuestras noticias para obtener codigos de descuento exclusivos para nuestro cliente."+ '\n' +  '\n' +

                "Puede comunicarte a nuestro correo bookinggrupo7@gmail.com para obtener soporte de nuestros servicios" + '\n' + '\n' +
                "Bienvenido!!!");
        message.setSubject("Registro Exitoso!");


        mailSender.send(message);

        System.out.println("Mail sent successfully");
    }

    public void sendEmailBookig(BookingDTO booking) {

        Long userid = booking.getClient_id();
        UserClient user = userClientRepository.findById(userid)
                .orElseThrow(()-> new NotFoundException("User client not exist"));
        String name = user.getName();
        Product pd = productRepository.findById(booking.getProduct_id())
                .orElseThrow(()-> new NotFoundException("Product does not exist"));


        SimpleMailMessage message =new SimpleMailMessage();
        message.setFrom("BookingGrupo7@gmail.com");
        message.setTo(user.getEmail());
        message.setText("Hola " + name + "!" + '\n' +  '\n' +
                "Confirmamos que tu reserva ha sido exitosa" + '\n' +  '\n' +
                "Estos son tus datos de la reserva: " + '\n' +  '\n' +

                        "Producto:   " + pd.getTitle() + '\n' +
                        "Dia de llegada:   "  + booking.getStartDate() + '\n' +
                        "Dia de salida:    "    + booking.getEndDate()  + '\n' +  '\n' +  '\n' +

                        "Esperamos que disfrutes tu estadia. Gracias por confiar en nosotros.!");

        message.setSubject("Reserva exitosa! ");

        mailSender.send(message);


    }
}
