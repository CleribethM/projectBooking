package com.DigitalHoues.HospedajeDH.repository;

import com.DigitalHoues.HospedajeDH.entities.BookingForCliente;
import com.DigitalHoues.HospedajeDH.entities.Fav;
import com.DigitalHoues.HospedajeDH.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface FavRepository extends JpaRepository<Fav, Long> {

    @Query("SELECT f FROM Fav f " +
            "WHERE f.id_client = :client_id")
    List<Fav> findByClient(Long client_id);




}
