package com.DigitalHoues.HospedajeDH.service;

import com.DigitalHoues.HospedajeDH.dto.ProductDTO;
import com.DigitalHoues.HospedajeDH.dto.UserClientDTO;
import com.DigitalHoues.HospedajeDH.entities.Booking;

import java.util.ArrayList;
import java.util.Optional;

public interface IAudit {

    void saveAuditBooking(Booking booking);
    void saveAuditLogin(String user);

    void RegistAuditLogin(UserClientDTO user);

    void DeleteBookingForUser(Long client_id, Long idBooking);

    void saveAuditProduct(ProductDTO product);



}
