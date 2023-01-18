package com.DigitalHoues.HospedajeDH.repository;

import com.DigitalHoues.HospedajeDH.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    @Query("SELECT b FROM Booking b " +
            "WHERE b.product_id = :product_id")
    List<Booking> findByProductId(Long product_id);

    @Query("SELECT b FROM Booking b " +
            "WHERE b.client_id = :client_id")
    List<Booking> findByClientId(Long client_id);
    @Query("SELECT b FROM Booking b " +
            "WHERE (b.startDate BETWEEN :startDate and :endDate " +
            "OR b.endDate BETWEEN :startDate and :endDate )" +
            "AND b.product_id = :product_id")
    List<Booking> findByProductIdAndStartDateAndEndDate(Long product_id, LocalDate startDate, LocalDate endDate);







}
