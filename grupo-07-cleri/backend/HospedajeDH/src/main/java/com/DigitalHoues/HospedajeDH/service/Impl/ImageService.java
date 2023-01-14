package com.DigitalHoues.HospedajeDH.service.Impl;

import com.DigitalHoues.HospedajeDH.dto.ImageDTO;
import com.DigitalHoues.HospedajeDH.entities.Image;
import com.DigitalHoues.HospedajeDH.exception.NotFoundException;
import com.DigitalHoues.HospedajeDH.repository.ImageRepository;
import com.DigitalHoues.HospedajeDH.service.IImageService;
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

public class ImageService implements IImageService {

    @Autowired
    ImageRepository imageRepository;

    @Autowired
    ObjectMapper mappper;

    @Override
    public ImageDTO addImage(ImageDTO imageDto) {
        Image image = mappper.convertValue(imageDto, Image.class);
        imageRepository.save(image);
        ImageDTO imageDTO = mappper.convertValue(image, ImageDTO.class);
        return imageDTO;

    }

    @Override
    public void delete(Long id) {
        this.findById(id);
        imageRepository.deleteById(id);

    }

    @Override
    public Optional<ImageDTO> findById(Long id) {
        Image image = imageRepository.findById(id)
                .orElseThrow(()->new NotFoundException("Image does not exits"));
        ImageDTO imageDTO = mappper.convertValue(image, ImageDTO.class);
        return Optional.ofNullable(imageDTO);
    }

    @Override
    public Set<ImageDTO> findAll() {
        List<Image> image = imageRepository.findAll();
        Set<ImageDTO> imagesDTO = new HashSet<>();

        for(Image imageDto : image){
            imagesDTO.add(mappper.convertValue(imageDto, ImageDTO.class));
        }
        return imagesDTO;
    }
}
