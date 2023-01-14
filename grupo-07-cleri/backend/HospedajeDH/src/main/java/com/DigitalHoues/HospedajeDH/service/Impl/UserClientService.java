package com.DigitalHoues.HospedajeDH.service.Impl;


import com.DigitalHoues.HospedajeDH.dto.UserClientDTO;

import com.DigitalHoues.HospedajeDH.dto.UserClientDTOv2;
import com.DigitalHoues.HospedajeDH.dto.UserResposeClientDTO;
import com.DigitalHoues.HospedajeDH.entities.Booking;
import com.DigitalHoues.HospedajeDH.entities.UserClient;
import com.DigitalHoues.HospedajeDH.exception.NotFoundException;
import com.DigitalHoues.HospedajeDH.repository.UserClientRepository;

import com.DigitalHoues.HospedajeDH.service.IAudit;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserClientService implements com.DigitalHoues.HospedajeDH.service.UserClientService {

    @Autowired
    UserClientRepository userClientRepository;

    @Autowired
    ObjectMapper mappper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    EmailSenserService emailSenserService;


    @Override
    public UserClientDTO addUser(UserClientDTO userClientDto) {


        emailSenserService.sendEmail(userClientDto);

        UserClient us = mappper.convertValue(userClientDto, UserClient.class);
        us.setRole_id(1);
        String pass = us.getPassword();
        String passEcript = passwordEncoder.encode(pass);
        us.setPassword(passEcript);
        userClientRepository.save(us);
        UserClientDTO User = mappper.convertValue(us, UserClientDTO.class);

        return User;
    }

    @Override
    public void delete(Long id) {
        userClientRepository.deleteById(id);
    }

    @Override
    public Optional<UserClientDTOv2> findById(Long id) {
        UserClient user = userClientRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("User client does not exist"));
        UserClientDTOv2 userClientDTO = mappper.convertValue(user, UserClientDTOv2.class);
        return Optional.ofNullable(userClientDTO);

    }

    @Override
    public Set<UserClientDTOv2> findAll() {

        List<UserClient> user = userClientRepository.findAll();
        Set<UserClientDTOv2> userClientDTO = new HashSet<>();

        for (UserClient userDto : user) {
            userClientDTO.add(mappper.convertValue(userDto, UserClientDTOv2.class));
        }
        return userClientDTO;
    }

    @Override
    public Optional<UserResposeClientDTO> findByEmail(String email) {
          UserClient us = userClientRepository.findByEmail(email);
          UserResposeClientDTO uso = mappper.convertValue(us, UserResposeClientDTO.class);
          return Optional.ofNullable(uso);

    }

}
