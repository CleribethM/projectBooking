package com.DigitalHoues.HospedajeDH.service;


import com.DigitalHoues.HospedajeDH.dto.UserClientDTO;
import com.DigitalHoues.HospedajeDH.dto.UserClientDTOv2;
import com.DigitalHoues.HospedajeDH.dto.UserResposeClientDTO;
import com.DigitalHoues.HospedajeDH.entities.Booking;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UserClientService {

    public UserClientDTO addUser(UserClientDTO user);
    public void  delete (Long id);
    public Optional<UserClientDTOv2> findById(Long id);
    public Set<UserClientDTOv2> findAll();

    public Optional<UserResposeClientDTO> findByEmail(String email);


}
