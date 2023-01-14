package com.DigitalHoues.HospedajeDH.controller;

import com.DigitalHoues.HospedajeDH.dto.CityDTO;
import com.DigitalHoues.HospedajeDH.dto.FechasDTO;
import com.DigitalHoues.HospedajeDH.dto.ProductDTO;
import com.DigitalHoues.HospedajeDH.entities.Fechas;
import com.DigitalHoues.HospedajeDH.service.IFeatureService;
import com.DigitalHoues.HospedajeDH.service.IFechas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("")
public class FechasController {

    @Autowired
    IFechas iFechas;

    @CrossOrigin(origins = {"http://localhost:3000","http://g7-front-bucket.app.s3-website.us-east-2.amazonaws.com"})
    @GetMapping("public/api/v1/fechas/{id}")
    public ResponseEntity<List<Fechas>> FechasForProduct (@PathVariable Long id){
        Optional<List<Fechas>> fechas = iFechas.FechasForProduct(id);
        if (!fechas.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(fechas.get());
    }

}
