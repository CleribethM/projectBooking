package com.DigitalHoues.HospedajeDH.repository;

import com.DigitalHoues.HospedajeDH.entities.Booking;
import com.DigitalHoues.HospedajeDH.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p " +
            "WHERE p.city_id = :city_id")
    List<Product> findByCity(Long city_id);


    @Query("SELECT p FROM Product p " +
           "ORDER BY p.id DESC")
    ArrayList<Product> findProductID();
}
