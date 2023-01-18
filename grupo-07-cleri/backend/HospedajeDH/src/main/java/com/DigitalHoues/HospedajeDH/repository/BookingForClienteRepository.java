package com.DigitalHoues.HospedajeDH.repository;

import com.DigitalHoues.HospedajeDH.entities.Booking;
import com.DigitalHoues.HospedajeDH.entities.BookingForCliente;
import com.DigitalHoues.HospedajeDH.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookingForClienteRepository extends JpaRepository<BookingForCliente, Long> {

    @Query("SELECT f FROM BookingForCliente f " +
            "WHERE f.id_client = :client_id")
    List<BookingForCliente> findByClient(Long client_id);

    @Query("SELECT f FROM BookingForCliente f " +
            "WHERE f.id_booking = :booking_id")
    Optional<BookingForCliente> findByBooking(Long booking_id);



}
