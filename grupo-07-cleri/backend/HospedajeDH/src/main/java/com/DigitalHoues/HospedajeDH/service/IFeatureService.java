package com.DigitalHoues.HospedajeDH.service;

import com.DigitalHoues.HospedajeDH.dto.FeatureDTO;

import java.util.Optional;
import java.util.Set;

public interface IFeatureService {

    public FeatureDTO addFeature(FeatureDTO feature);
    public void  delete (Long id);
    public Optional<FeatureDTO> findById(Long id);
    public Set<FeatureDTO> findAll();
}
