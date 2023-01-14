package com.DigitalHoues.HospedajeDH.service;

import com.DigitalHoues.HospedajeDH.dto.ImageDTO;

import java.util.Optional;
import java.util.Set;

public interface IImageService {


    public ImageDTO addImage(ImageDTO image);
    public void  delete (Long id);
    public Optional<ImageDTO> findById(Long id);
    public Set<ImageDTO> findAll();


}

