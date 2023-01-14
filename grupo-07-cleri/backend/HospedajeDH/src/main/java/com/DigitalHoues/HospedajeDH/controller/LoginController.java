package com.DigitalHoues.HospedajeDH.controller;

import com.DigitalHoues.HospedajeDH.Config.AuthenticationReq;
import com.DigitalHoues.HospedajeDH.Config.TokenInfo;
import com.DigitalHoues.HospedajeDH.dto.UserResposeClientDTO;
import com.DigitalHoues.HospedajeDH.entities.UserClient;
import com.DigitalHoues.HospedajeDH.repository.UserClientRepository;
import com.DigitalHoues.HospedajeDH.service.IAudit;
import com.DigitalHoues.HospedajeDH.service.Impl.JwtUtilService;
import com.DigitalHoues.HospedajeDH.service.UserClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Optional;


@RestController
@RequestMapping("public/authenticate/")
public class LoginController {
        @Autowired
        private AuthenticationManager authenticationManager;
        @Autowired
        UserDetailsService usuarioDetailsService;

        @Autowired
        UserClientService userClientService;

        @Autowired
        IAudit iAudit;

        @Autowired
        private JwtUtilService jwtUtilService;



        @PostMapping("")
        public ResponseEntity<ArrayList> authenticate(@Valid @RequestBody AuthenticationReq authenticationReq) {


            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationReq.getUser(),
                            authenticationReq.getPassword()));

            final UserDetails userDetails = usuarioDetailsService.loadUserByUsername(
                    authenticationReq.getUser());

            final String jwt = jwtUtilService.generateToken(userDetails);

            final Optional<UserResposeClientDTO> us = userClientService.findByEmail(userDetails.getUsername());

            TokenInfo tokenInfo = new TokenInfo(jwt);
            ArrayList<Object> ar = new ArrayList<>();
            ar.add(tokenInfo);
            ar.add(us);
            iAudit.saveAuditLogin(us.get().getEmail());



            return ResponseEntity.ok(ar);
        }
    }

