package com.DigitalHoues.HospedajeDH.service.Impl;

import com.DigitalHoues.HospedajeDH.dto.ProductDTO;
import com.DigitalHoues.HospedajeDH.dto.UserClientDTO;
import com.DigitalHoues.HospedajeDH.dto.UserClientDTOv2;
import com.DigitalHoues.HospedajeDH.entities.Audit;
import com.DigitalHoues.HospedajeDH.entities.Booking;

import com.DigitalHoues.HospedajeDH.entities.BookingForCliente;
import com.DigitalHoues.HospedajeDH.repository.AuditRepository;
import com.DigitalHoues.HospedajeDH.repository.BookingForClienteRepository;
import com.DigitalHoues.HospedajeDH.service.IAudit;

import com.DigitalHoues.HospedajeDH.service.IProductService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Optional;

import static com.DigitalHoues.HospedajeDH.Util.Constantes.*;


@Service
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AuditService implements IAudit {


    @Autowired
    AuditRepository auditRepository;


    @Autowired
    UserClientService userClientService;

    @Autowired
    IProductService iProductService;

    @Autowired
    BookingForClienteRepository bf;


    @Override
    public void saveAuditBooking(Booking booking) {

        Optional<UserClientDTOv2> us = userClientService.findById(booking.getClient_id());
        String user = us.get().getEmail();

        Optional<ProductDTO> pr = iProductService.findById(booking.getProduct_id());
        String pro = pr.get().getTitle();
        String f1 = String.valueOf(booking.getStartDate());
        String f2 = String.valueOf(booking.getEndDate());
        LocalTime date = LocalTime.now();

        String ac = ACCION;
        String ds = "Usuario hizo la reserva del producto " + pro + " para el dia " + f1 + " Hasta el dia " + f2 ;

        Audit au = new Audit(ac,user,ds,date);

        auditRepository.save(au);

    }

    @Override
    public void saveAuditLogin(String user) {

        String ac = ACCION2;
        String ds = "Ha iniciado sesion. ";
        LocalTime date = LocalTime.now();
        Audit au = new Audit(ac,user,ds,date);

        auditRepository.save(au);
    }

    @Override
    public void RegistAuditLogin(UserClientDTO user) {


        String ac = ACCION4;
        String ds = "Se ha registrado el usuario: " + user.getName() + " " +user.getLastName();
        LocalTime date = LocalTime.now();
        Audit au = new Audit(ac,user.getEmail(),ds,date);

        auditRepository.save(au);
    }

    @Override
    public void DeleteBookingForUser(Long client_id, Long idBooking) {

        Optional<BookingForCliente> bf2 = bf.findByBooking(idBooking);
        Long bfid = bf2.get().getId();
        bf.deleteById(bfid);

        Optional<UserClientDTOv2> us = userClientService.findById(client_id);
        String user = us.get().getEmail();
        String ac = ACCION3;
        String ds = "El usuario " + user + " a eliminado la reserva " + bfid ;
        LocalTime date = LocalTime.now();
        Audit au = new Audit(ac,user,ds,date);
        auditRepository.save(au);
    }

    @Override
    public void saveAuditProduct(ProductDTO product) {

        String user = "ADMIN";
        String ac = ACCION4;
        String ds = "Se a registrado un producto llamado " + product.getTitle();
        LocalTime date = LocalTime.now();
        Audit au = new Audit(ac,user,ds,date);
        auditRepository.save(au);
    }
}
