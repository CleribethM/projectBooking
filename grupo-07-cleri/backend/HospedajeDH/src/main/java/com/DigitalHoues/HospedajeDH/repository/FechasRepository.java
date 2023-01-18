package com.DigitalHoues.HospedajeDH.repository;

import com.DigitalHoues.HospedajeDH.entities.Fechas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.SecondaryTable;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface FechasRepository extends JpaRepository<Fechas, Long> {

    @Query("SELECT f FROM Fechas f WHERE f.product_id =:id ")
    Optional<List<Fechas>> FechasForProduct(Long id);
}
