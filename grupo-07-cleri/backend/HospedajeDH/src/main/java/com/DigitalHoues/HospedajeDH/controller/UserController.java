package com.DigitalHoues.HospedajeDH.controller;


import com.DigitalHoues.HospedajeDH.dto.UserClientDTO;
import com.DigitalHoues.HospedajeDH.dto.UserClientDTOv2;
import com.DigitalHoues.HospedajeDH.dto.UserResposeClientDTO;
import com.DigitalHoues.HospedajeDH.service.IAudit;
import com.DigitalHoues.HospedajeDH.service.UserClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Set;

@RestController
@CrossOrigin
@RequestMapping("")
public class UserController {

    @Autowired
    private UserClientService userClientService;

    @Autowired
    private IAudit iAudit;

    @CrossOrigin(origins = {"http://localhost:3000","http://g7-front-bucket.app.s3-website.us-east-2.amazonaws.com"})
    @PostMapping("public/api/v1/users/")
    public ResponseEntity<UserClientDTO> save (@RequestBody UserClientDTO user){

        ArrayList<UserClientDTO> us = new ArrayList<>();
        us.add(user);
        String email = us.get(0).getEmail();


        Optional<UserResposeClientDTO> ur = userClientService.findByEmail(email);
        if(ur.isEmpty()){
            userClientService.addUser(user);
            iAudit.RegistAuditLogin(user);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }else {
            throw new DataIntegrityViolationException("Conflict with your data");
        }
    }

    @CrossOrigin(origins = {"http://localhost:3000","http://g7-front-bucket.app.s3-website.us-east-2.amazonaws.com"})
    @GetMapping("admin/api/v1/users/")
    public Set<UserClientDTOv2> findAll() {
        return userClientService.findAll();
    }

    @CrossOrigin(origins = {"http://localhost:3000","http://g7-front-bucket.app.s3-website.us-east-2.amazonaws.com"})
    @GetMapping("user/api/v1/users/{id}")
    public ResponseEntity<UserClientDTOv2> findByID (@PathVariable Long id){
        Optional<UserClientDTOv2> user = userClientService.findById(id);
        if (!user.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(user.get());
    }

    @CrossOrigin(origins = {"http://localhost:3000","http://g7-front-bucket.app.s3-website.us-east-2.amazonaws.com"})
    @DeleteMapping("admin/api/v1/users/{id}")
    public String delete (@PathVariable Long id){
        Optional<UserClientDTOv2> user = userClientService.findById(id);
        if (user.isPresent()){
            userClientService.delete(id);
            return "the user " + user.get().getName() + " has been removed.";
        }
        return "UserCliente not found";
    }

    @CrossOrigin(origins = {"http://localhost:3000","http://g7-front-bucket.app.s3-website.us-east-2.amazonaws.com"})
    @PutMapping("user/api/v1/users/")
    public ResponseEntity<UserClientDTO> update(@Valid @RequestBody UserClientDTO userUpdate) {
        Optional<UserClientDTOv2> user = userClientService.findById(userUpdate.getId());
        if (!user.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(userClientService.addUser(userUpdate));
    }    
}
