package com.DigitalHoues.HospedajeDH.service.Impl;

import com.DigitalHoues.HospedajeDH.dto.CityDTO;
import com.DigitalHoues.HospedajeDH.dto.CityResponseDTO;
import com.DigitalHoues.HospedajeDH.entities.City;
import com.DigitalHoues.HospedajeDH.exception.NotFoundException;
import com.DigitalHoues.HospedajeDH.repository.CityRepository;
import com.DigitalHoues.HospedajeDH.service.ICityService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CityService implements ICityService {

    @Autowired
    CityRepository cityRepository;

    @Autowired
    ObjectMapper mappper;

    @Override
    public CityDTO addCity(CityDTO CityDto) {
        City city = mappper.convertValue(CityDto, City.class);
        cityRepository.save(city);
        CityDTO cityDTO1 = mappper.convertValue(city, CityDTO.class);
        return cityDTO1;
    }

    @Override
    public void delete(Long id) {
        this.findById(id);
        cityRepository.deleteById(id);
    }

    @Override
    public Optional<CityDTO> findById(Long id) {
        City city = cityRepository.findById(id).orElseThrow(()-> new NotFoundException("City does not exist"));
        CityDTO cityDTO = mappper.convertValue(city, CityDTO.class);
        return Optional.ofNullable(cityDTO);

    }

    @Override
    public Set<CityDTO> findAll() {

        List<City> city = cityRepository.findAll();
        Set<CityDTO> cityDTO = new HashSet<>();

        for (City cityDto : city) {
            cityDTO.add(mappper.convertValue(cityDto, CityDTO.class));
        }
        return cityDTO;
    }

    @Override
    public CityResponseDTO findCity(Long id) {
        City city = cityRepository.findById(id).orElseThrow(()-> new NotFoundException("City does not exist"));
        return mappper.convertValue(city, CityResponseDTO.class);
    }
}
