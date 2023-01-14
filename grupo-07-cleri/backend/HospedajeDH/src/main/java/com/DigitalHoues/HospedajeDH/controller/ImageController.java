
package com.DigitalHoues.HospedajeDH.controller;

import com.DigitalHoues.HospedajeDH.dto.ImageDTO;
import com.DigitalHoues.HospedajeDH.service.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("")
public class ImageController {
    @Autowired
    private IImageService iImageService;

    @CrossOrigin(origins = {"http://localhost:3000","http://g7-front-bucket.app.s3-website.us-east-2.amazonaws.com"})
    @PostMapping("/admin/api/v1/images/")
    public ResponseEntity<ImageDTO> save (@Valid @RequestBody ImageDTO image){
        iImageService.addImage(image);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @CrossOrigin(origins = {"http://localhost:3000","http://g7-front-bucket.app.s3-website.us-east-2.amazonaws.com"})
    @GetMapping("/public/api/v1/images/")
    public ResponseEntity<Set<ImageDTO>> findAll(){
        return ResponseEntity.ok(iImageService.findAll());
    }

    @CrossOrigin(origins = {"http://localhost:3000","http://g7-front-bucket.app.s3-website.us-east-2.amazonaws.com"})
    @GetMapping("/public/api/v1/images/{id}")
    public ResponseEntity<ImageDTO> findByID (@PathVariable Long id){
        Optional<ImageDTO> image = iImageService.findById(id);
        if (!image.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(image.get());
    }

    @CrossOrigin(origins = {"http://localhost:3000","http://g7-front-bucket.app.s3-website.us-east-2.amazonaws.com"})
    @DeleteMapping("/admin/api/v1/images/{id}")
    public String delete (@PathVariable Long id){
        Optional<ImageDTO> image = iImageService.findById(id);
        if (image.isPresent()){
            iImageService.delete(id);
            return "The image " + image.get().getTitle() + "has been removed";
        }
        return "Image not found " ;
    }

    @CrossOrigin(origins = {"http://localhost:3000","http://g7-front-bucket.app.s3-website.us-east-2.amazonaws.com"})
    @PutMapping("/admin/api/v1/images/")
    public ResponseEntity<ImageDTO> update(@Valid @RequestBody ImageDTO imageUpdate) {
        Optional<ImageDTO> image = iImageService.findById(imageUpdate.getId());
        if (!image.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(iImageService.addImage(imageUpdate));
    }
}
