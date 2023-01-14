package com.DigitalHoues.HospedajeDH.repository;

import com.DigitalHoues.HospedajeDH.entities.Image;
import com.DigitalHoues.HospedajeDH.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Long> {


}
