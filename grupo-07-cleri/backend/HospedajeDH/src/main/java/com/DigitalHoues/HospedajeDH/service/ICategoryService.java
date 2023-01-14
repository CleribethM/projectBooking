package com.DigitalHoues.HospedajeDH.service;

import com.DigitalHoues.HospedajeDH.dto.CategoryDTO;
import com.DigitalHoues.HospedajeDH.dto.CategoryResponseDTO;
import com.DigitalHoues.HospedajeDH.entities.Category;

import java.util.Optional;
import java.util.Set;

public interface ICategoryService  {

    public Optional<Category> findById(Long id) ;
    public void delete(Long id);
    public CategoryDTO save(CategoryDTO categoryDto);
    public Set<CategoryDTO> findAll();

    public CategoryResponseDTO findCategory(Long id);
}
