package com.DigitalHoues.HospedajeDH.controller;

import com.DigitalHoues.HospedajeDH.dto.FeatureDTO;
import com.DigitalHoues.HospedajeDH.service.IFeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("")
public class FeatureController {

    @Autowired
    private IFeatureService iFeatureService;

    @CrossOrigin(origins = {"http://localhost:3000","http://g7-front-bucket.app.s3-website.us-east-2.amazonaws.com"})
    @PostMapping("admin/api/v1/features/")
    public ResponseEntity<FeatureDTO> save (@Valid @RequestBody FeatureDTO feature){
        iFeatureService.addFeature(feature);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @CrossOrigin(origins = {"http://localhost:3000","http://g7-front-bucket.app.s3-website.us-east-2.amazonaws.com"})
    @GetMapping("public/api/v1/features/")
    public ResponseEntity<Set<FeatureDTO>> findAll(){
        return ResponseEntity.ok(iFeatureService.findAll());
    }

    @CrossOrigin(origins = {"http://localhost:3000","http://g7-front-bucket.app.s3-website.us-east-2.amazonaws.com"})
    @GetMapping("public/api/v1/features/{id}")
    public ResponseEntity<FeatureDTO> findByID (@PathVariable Long id){
        Optional<FeatureDTO> feature = iFeatureService.findById(id);
        if (!feature.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(feature.get());
    }

    @CrossOrigin(origins = {"http://localhost:3000","http://g7-front-bucket.app.s3-website.us-east-2.amazonaws.com"})
    @DeleteMapping("admin/api/v1/features/{id}")
    public String delete (@PathVariable Long id){
        Optional<FeatureDTO> feature = iFeatureService.findById(id);
        if (feature.isPresent()){
            iFeatureService.delete(id);
            return "Feature has been removed";
        }
        return "Feature not found";
    }

    @CrossOrigin(origins = {"http://localhost:3000","http://g7-front-bucket.app.s3-website.us-east-2.amazonaws.com"})
    @PutMapping("admin/api/v1/features/")
    public ResponseEntity<FeatureDTO> update(@Valid @RequestBody FeatureDTO featureUpdate) {
        Optional<FeatureDTO> feature = iFeatureService.findById(featureUpdate.getId());
        if (!feature.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(iFeatureService.addFeature(featureUpdate));
    }
}


