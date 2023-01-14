package com.DigitalHoues.HospedajeDH.service;

import com.DigitalHoues.HospedajeDH.dto.BookingDTO;
import com.DigitalHoues.HospedajeDH.dto.BookingResponse;
import com.DigitalHoues.HospedajeDH.entities.Booking;
import com.DigitalHoues.HospedajeDH.entities.BookingForCliente;

import java.util.List;
import java.util.Optional;

public interface IBookingService {

    BookingDTO save(BookingDTO bookingDTO);

    List<BookingResponse> findByProductId(Long productId);
    List<BookingForCliente> BookingForCliente(Long client_id);

    void deleteBooking(Long id);

    Optional<Booking> findById(Long id);
}
