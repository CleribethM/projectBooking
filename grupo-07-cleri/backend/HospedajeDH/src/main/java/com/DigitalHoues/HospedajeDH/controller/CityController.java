package com.DigitalHoues.HospedajeDH.controller;


import com.DigitalHoues.HospedajeDH.dto.CityDTO;
import com.DigitalHoues.HospedajeDH.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.Optional;
import java.util.Set;

@RestController
@CrossOrigin
@RequestMapping("")
public class CityController {

    @Autowired
    private ICityService iCityService;

    @CrossOrigin(origins = {"http://localhost:3000","http://g7-front-bucket.app.s3-website.us-east-2.amazonaws.com"})
    @PostMapping("admin/api/v1/cities/")
    public ResponseEntity<CityDTO> save (@Valid @RequestBody CityDTO city){
        iCityService.addCity(city);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @CrossOrigin(origins = {"http://localhost:3000","http://g7-front-bucket.app.s3-website.us-east-2.amazonaws.com"})
    @GetMapping("public/api/v1/cities/")
    public Set<CityDTO> findAll() {
        return iCityService.findAll();
    }

    @CrossOrigin(origins = {"http://localhost:3000","http://g7-front-bucket.app.s3-website.us-east-2.amazonaws.com"})
    @GetMapping("public/api/v1/cities/{id}")
    public ResponseEntity<CityDTO> findByID (@PathVariable Long id){
        Optional<CityDTO> city = iCityService.findById(id);
        if (!city.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(city.get());
    }

    @CrossOrigin(origins = {"http://localhost:3000","http://g7-front-bucket.app.s3-website.us-east-2.amazonaws.com"})
    @DeleteMapping("admin/api/v1/cities/{id}")
    public String delete (@PathVariable Long id){
        Optional<CityDTO> city = iCityService.findById(id);
        if (city.isPresent()){
            iCityService.delete(id);
            return "the city" + city.get().getLocation() + "has been removed";
        }
        return "City not found";
    }

    @CrossOrigin(origins = {"http://localhost:3000","http://g7-front-bucket.app.s3-website.us-east-2.amazonaws.com"})
    @PutMapping("admin/api/v1/cities/")
    public ResponseEntity<CityDTO> update(@Valid @RequestBody CityDTO cityUpdate) {
        Optional<CityDTO> city = iCityService.findById(cityUpdate.getId());
        if (!city.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(iCityService.addCity(cityUpdate));
    }    
}
