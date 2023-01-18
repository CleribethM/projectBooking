package com.DigitalHoues.HospedajeDH.service.Impl;

import com.DigitalHoues.HospedajeDH.dto.BookingDTO;
import com.DigitalHoues.HospedajeDH.entities.Product;
import com.DigitalHoues.HospedajeDH.entities.UserClient;
import com.DigitalHoues.HospedajeDH.exception.NotFoundException;
import com.DigitalHoues.HospedajeDH.repository.ProductRepository;
import com.DigitalHoues.HospedajeDH.repository.UserClientRepository;
import com.twilio.exception.ApiException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import java.util.Optional;

import static com.DigitalHoues.HospedajeDH.Util.Constantes.*;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MessagesService {

    @Autowired
    UserClientRepository ur;

    @Autowired
    ProductRepository pr;


    public String sendSMS(BookingDTO bookingDTO){

        UserClient user = ur.findById(bookingDTO.getClient_id())
                .orElseThrow(()-> new NotFoundException("User does not exist"));
        String name = user.getName();

        Product product = pr.findById(bookingDTO.getProduct_id())
                .orElseThrow(()-> new NotFoundException("Product does not exist"));
        String pro = product.getTitle();
        Long tel = user.getPhone();
        String cel = "+" + String.valueOf(tel);
        Integer  x = cel.length();

        try {



        if (tel != null && x == 13) {

            Twilio.init(ACCOUNT_SID_CO, AUTH_TOKEN_CO);

            Message message = Message.creator(new PhoneNumber(cel),
                    new PhoneNumber(phone_CO),
                    "Hola " + name + " tu reserva en el hotel " + pro + " ha sido confirmada. Tu reserva comienza el dia " +
                            bookingDTO.getStartDate() + " y finaliza el dia " + bookingDTO.getEndDate() + ". Gracias por confiar en BookingG7-DH. Te esperamos!").create();
            System.out.println(message.getSid());


        }

        if (tel != null && x == 14) {

                Twilio.init(ACCOUNT_SID_AR, AUTH_TOKEN_AR);

                Message message = Message.creator(new PhoneNumber(cel),
                        new PhoneNumber(phone_AR),
                        "Hola " + name + " tu reserva en el hotel " + pro + " ha sido confirmada. Tu reserva comienza el dia " +
                                bookingDTO.getStartDate() + " y finaliza el dia " + bookingDTO.getEndDate() + ". Gracias por confiar en BookingG7-DH. Te esperamos!").create();
                  System.out.println(message.getSid());
                  return "SMS SEND";


        }
        }catch (ApiException e){
            System.out.println("no se pudo enviar mensaje");
            return "the phone " + cel + " is invalid";

        }

        return "SMS SEND";

    }
}
