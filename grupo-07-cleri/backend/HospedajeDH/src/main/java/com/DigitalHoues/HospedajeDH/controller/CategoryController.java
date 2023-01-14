package com.DigitalHoues.HospedajeDH.controller;

import com.DigitalHoues.HospedajeDH.dto.CategoryDTO;
import com.DigitalHoues.HospedajeDH.entities.Category;
import com.DigitalHoues.HospedajeDH.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;
import java.util.Set;

@RestController
@CrossOrigin
@RequestMapping("")
//@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoryController {

    @Autowired
    private ICategoryService iCategoryService;

    @CrossOrigin(origins = {"http://localhost:3000","http://g7-front-bucket.app.s3-website.us-east-2.amazonaws.com"})
    @PostMapping("admin/api/v1/categories/")
    public ResponseEntity<CategoryDTO> save(@Valid @RequestBody CategoryDTO category) {
        iCategoryService.save((category));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @CrossOrigin(origins = {"http://localhost:3000","http://g7-front-bucket.app.s3-website.us-east-2.amazonaws.com"})
    @GetMapping("public/api/v1/categories")
    public Set<CategoryDTO> findAll() {
        return iCategoryService.findAll();
    }

    @CrossOrigin(origins = {"http://localhost:3000","http://g7-front-bucket.app.s3-website.us-east-2.amazonaws.com"})
    @GetMapping("public/api/v1/categories/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id) {
        Optional<Category> category = iCategoryService.findById(id);
        if (!category.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        }
        return ResponseEntity.ok(category.get());
    }

    @CrossOrigin(origins = {"http://localhost:3000","http://g7-front-bucket.app.s3-website.us-east-2.amazonaws.com"})
    @DeleteMapping("admin/api/v1/categories/{id}")
    public String delete(@PathVariable Long id) {
        Optional<Category> category = iCategoryService.findById(id);
        if (category.isPresent()) {
            iCategoryService.delete(id);
            return "The category has been removed";
        }
        return "Category not found";
    }

    @CrossOrigin(origins = {"http://localhost:3000","http://g7-front-bucket.app.s3-website.us-east-2.amazonaws.com"})
    @PutMapping("admin/api/v1/categories/")
    public ResponseEntity<CategoryDTO> update(@Valid @RequestBody CategoryDTO categoryUpdate) {
        Optional<Category> category = iCategoryService.findById(categoryUpdate.getId());
        if (!category.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(iCategoryService.save(categoryUpdate));
    }

}

