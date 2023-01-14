package com.DigitalHoues.HospedajeDH.service.Impl;

import com.DigitalHoues.HospedajeDH.dto.CategoryDTO;
import com.DigitalHoues.HospedajeDH.dto.CategoryResponseDTO;
import com.DigitalHoues.HospedajeDH.entities.Category;
import com.DigitalHoues.HospedajeDH.exception.NotFoundException;
import com.DigitalHoues.HospedajeDH.repository.CategoryRepository;
import com.DigitalHoues.HospedajeDH.service.ICategoryService;
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
public class CategoryService implements ICategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ObjectMapper mappper;

    @Override
    public Optional<Category> findById(Long id)  {
        Category category = categoryRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Category does not exist"));
        return Optional.ofNullable(category);
    }

    @Override
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }


    @Override
    public CategoryDTO save(CategoryDTO categoryDto) {
        Category category = mappper.convertValue(categoryDto, Category.class);
        categoryRepository.save(category);
        CategoryDTO categoryDto1 = mappper.convertValue(category, CategoryDTO.class);
        return categoryDto1;
    }
    @Override
    public Set<CategoryDTO> findAll() {

        List<Category> category = categoryRepository.findAll();
        Set<CategoryDTO> categoryDTO = new HashSet<>();

        for (Category categoryDto: category){
            categoryDTO.add(mappper.convertValue(categoryDto, CategoryDTO.class));
        }
        return categoryDTO;
    }

    @Override
    public CategoryResponseDTO findCategory(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Category does not exist"));
        CategoryResponseDTO ca = mappper.convertValue(category, CategoryResponseDTO.class);
        return ca;
    }

}
