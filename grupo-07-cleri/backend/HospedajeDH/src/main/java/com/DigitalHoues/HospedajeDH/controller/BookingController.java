package com.DigitalHoues.HospedajeDH.controller;

import com.DigitalHoues.HospedajeDH.dto.BookingDTO;
import com.DigitalHoues.HospedajeDH.dto.BookingResponse;
import com.DigitalHoues.HospedajeDH.entities.Booking;
import com.DigitalHoues.HospedajeDH.entities.BookingForCliente;
import com.DigitalHoues.HospedajeDH.service.IAudit;
import com.DigitalHoues.HospedajeDH.service.IBookingService;
import com.DigitalHoues.HospedajeDH.service.Impl.EmailSenserService;
import com.DigitalHoues.HospedajeDH.service.Impl.MessagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("")
public class BookingController {
    @Autowired
    private IBookingService iBookingService;

    @Autowired
    IAudit iAudit;

    @Autowired
    EmailSenserService mail;

    @Autowired
    MessagesService sms;



    @CrossOrigin(origins = {"http://localhost:3000","http://g7-front-bucket.app.s3-website.us-east-2.amazonaws.com"})
    @PostMapping("user/api/v1/bookings")
    public ResponseEntity<String> save(@RequestBody BookingDTO booking) {
        iBookingService.save(booking);
        mail.sendEmailBookig(booking);
        String SMS =  sms.sendSMS(booking);
        return ResponseEntity.status(HttpStatus.CREATED).body(SMS);
    }
    @CrossOrigin(origins = {"http://localhost:3000","http://g7-front-bucket.app.s3-website.us-east-2.amazonaws.com"})
    @GetMapping("public/api/v1/products/{productId}/bookings")
    public ResponseEntity<List<BookingResponse>> findByProductId(@PathVariable Long productId){
        List<BookingResponse> booking = iBookingService.findByProductId(productId);
        if (booking.isEmpty()){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(booking);
    }

    @CrossOrigin(origins = {"http://localhost:3000","http://g7-front-bucket.app.s3-website.us-east-2.amazonaws.com"})
    @GetMapping("user/api/v1/client/{client_id}/bookings")
    public ResponseEntity<List<BookingForCliente>> findByClientID(@PathVariable Long client_id){

        ArrayList<Object> bt = new ArrayList<>();

        List<BookingForCliente> booking = iBookingService.BookingForCliente(client_id);
        if (booking.isEmpty()){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(booking);
    }

    @CrossOrigin(origins = {"http://localhost:3000","http://g7-front-bucket.app.s3-website.us-east-2.amazonaws.com"})
    @DeleteMapping("user/api/v1/booking/{id}/bookings")
    public String delete (@PathVariable Long id){
        Optional<Booking> booking = iBookingService.findById(id);
        if (booking.isPresent()){
             final Long idclient = booking.get().getClient_id();

            iBookingService.deleteBooking(id);
            iAudit.DeleteBookingForUser(idclient, id);
            return "The booking has been removed";
        }

        return "Product not found";
    }

}
