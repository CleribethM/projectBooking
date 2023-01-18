package com.DigitalHoues.HospedajeDH.service;

import com.DigitalHoues.HospedajeDH.dto.CityDTO;
import com.DigitalHoues.HospedajeDH.dto.CityResponseDTO;

import java.util.Optional;
import java.util.Set;

public interface ICityService {

    public CityDTO addCity(CityDTO city);
    public void  delete (Long id);
    public Optional<CityDTO> findById(Long id);
    public Set<CityDTO> findAll();

    public CityResponseDTO findCity(Long id);


}
