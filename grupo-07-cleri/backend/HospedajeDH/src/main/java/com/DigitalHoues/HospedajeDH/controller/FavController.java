package com.DigitalHoues.HospedajeDH.controller;

import com.DigitalHoues.HospedajeDH.dto.FavDTO;
import com.DigitalHoues.HospedajeDH.entities.Fav;
import com.DigitalHoues.HospedajeDH.entities.UserClient;
import com.DigitalHoues.HospedajeDH.repository.FavRepository;
import com.DigitalHoues.HospedajeDH.repository.UserClientRepository;
import com.DigitalHoues.HospedajeDH.service.IFav;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@CrossOrigin
@RequestMapping("")
public class FavController {

    @Autowired
    IFav iFav;

    @Autowired
    FavRepository favRepository;

    @Autowired
    UserClientRepository user;

    @CrossOrigin(origins = {"http://localhost:3000", "http://g7-front-bucket.app.s3-website.us-east-2.amazonaws.com"})
    @PostMapping("user/api/v1/fav/")
    public ResponseEntity<String> Fav(@RequestBody FavDTO favDTO) {

        Optional<UserClient> user2 = user.findById(favDTO.getId_client());
        if(user2.isPresent()){


                    iFav.saveFav(favDTO);
                    List<Fav> fvr = favRepository.findByClient(favDTO.getId_client());
                    Integer id = fvr.size();


                        if(id == 1){
                            Long idFav = fvr.get(0).getId();
                            System.out.println(idFav);
                            return ResponseEntity.status(HttpStatus.CREATED).body("FavID: " + idFav  );

                        }

                        if(id >=1 ){
                            Integer xs = id -1;
                            Long idFav = fvr.get(xs).getId();
                            System.out.println(idFav);
                            return ResponseEntity.status(HttpStatus.CREATED).body("FavID: " + idFav  );

                        }
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("Error al guardar favorito, cliente no existe"  );


    }


    @CrossOrigin(origins = {"http://localhost:3000", "http://g7-front-bucket.app.s3-website.us-east-2.amazonaws.com"})
    @GetMapping("user/api/v1/fav/{id}")
    public ResponseEntity<List<Fav>> findAll(@PathVariable Long id) {
        List fv = iFav.FavForClien(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(fv);
    }

    @CrossOrigin(origins = {"http://localhost:3000", "http://g7-front-bucket.app.s3-website.us-east-2.amazonaws.com"})
    @DeleteMapping("user/api/v1/fav/{id}")
    public String delete(@PathVariable Long id) {
        Optional<Fav> fav = favRepository.findById(id);
        if (fav.isPresent()) {
            iFav.deletFavForClient(id);
            return "The product " + fav.get().getId() + " has been removed";
        }
        return "Product not found";
    }
}