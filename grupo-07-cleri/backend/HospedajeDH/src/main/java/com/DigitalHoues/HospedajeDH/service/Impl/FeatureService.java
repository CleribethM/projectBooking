package com.DigitalHoues.HospedajeDH.service.Impl;

import com.DigitalHoues.HospedajeDH.dto.FeatureDTO;
import com.DigitalHoues.HospedajeDH.entities.Feature;
import com.DigitalHoues.HospedajeDH.exception.NotFoundException;
import com.DigitalHoues.HospedajeDH.repository.FeatureRepository;
import com.DigitalHoues.HospedajeDH.service.IFeatureService;
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
public class FeatureService implements IFeatureService {

    @Autowired
    FeatureRepository featureRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public FeatureDTO addFeature(FeatureDTO featureDTO) {
        Feature feature = mapper.convertValue(featureDTO, Feature.class);
        featureRepository.save(feature);
        FeatureDTO featureDto = mapper.convertValue(feature, FeatureDTO.class);
        return featureDto;
    }

    @Override
    public void delete(Long id) {
        this.findById(id);
        featureRepository.deleteById(id);

    }

    @Override
    public Optional<FeatureDTO> findById(Long id) {
        Feature feature = featureRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Feature does not exist"));
        FeatureDTO featureDTO = mapper.convertValue(feature,FeatureDTO.class);
        return Optional.ofNullable(featureDTO);
    }

    @Override
    public Set<FeatureDTO> findAll() {
        List<Feature> feature = featureRepository.findAll();
        Set<FeatureDTO> featureDTO = new HashSet<>();

        for(Feature featureDto : feature){
            featureDTO.add(mapper.convertValue(featureDto, FeatureDTO.class));
        }
        return featureDTO;
    }
}
