package com.DigitalHoues.HospedajeDH.controller;


import com.DigitalHoues.HospedajeDH.dto.CategoryResponseDTO;
import com.DigitalHoues.HospedajeDH.dto.CityResponseDTO;
import com.DigitalHoues.HospedajeDH.dto.ProductsAvaliable;
import com.DigitalHoues.HospedajeDH.dto.ProductDTO;
import com.DigitalHoues.HospedajeDH.entities.Product;
import com.DigitalHoues.HospedajeDH.repository.ProductRepository;
import com.DigitalHoues.HospedajeDH.service.IAudit;
import com.DigitalHoues.HospedajeDH.service.ICategoryService;
import com.DigitalHoues.HospedajeDH.service.ICityService;
import com.DigitalHoues.HospedajeDH.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Set;

@RestController
@CrossOrigin
@RequestMapping("")
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @Autowired
    private ICityService cityService;

    @Autowired
    IAudit iAudit;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    private ICategoryService categoryService;

    @CrossOrigin(origins = {"http://localhost:3000","http://g7-front-bucket.app.s3-website.us-east-2.amazonaws.com"})
    @PostMapping("admin/api/v1/products")
    public ResponseEntity<String> save (@RequestBody ProductDTO product){
        iProductService.addProduct(product);
        iAudit.saveAuditProduct(product);
        ArrayList<Product> pr = productRepository.findProductID();
        Long id = pr.get(0).getId();
        return ResponseEntity.status(HttpStatus.CREATED).body("Product id: " + id);
    }

    @CrossOrigin(origins = {"http://localhost:3000","http://g7-front-bucket.app.s3-website.us-east-2.amazonaws.com"})
    @GetMapping("public/api/v1/products")
    public ResponseEntity<Set<ProductDTO>> findAll(){
        return ResponseEntity.ok(iProductService.findAll());
    }

    @CrossOrigin(origins = {"http://localhost:3000","http://g7-front-bucket.app.s3-website.us-east-2.amazonaws.com"})
    @GetMapping("public/api/v1/products/{id}")
    public ResponseEntity<ArrayList> findByID (@PathVariable Long id){
        Optional<ProductDTO> product = iProductService.findById(id);


        ArrayList<Object> pr = new ArrayList<>();
        pr.add(product);
        Long cityid = product.get().getCity_id();
        CityResponseDTO ct = cityService.findCity(cityid);
        pr.add(ct);
        Long category = product.get().getCategory_id();
        CategoryResponseDTO ca = categoryService.findCategory(category);
        pr.add(ca);
        if (!product.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(pr);
    }

    @CrossOrigin(origins = {"http://localhost:3000","http://g7-front-bucket.app.s3-website.us-east-2.amazonaws.com"})
    @DeleteMapping("admin/api/v1/products/{id}")
    public String delete (@PathVariable Long id){
        Optional<ProductDTO> product = iProductService.findById(id);
        if (product.isPresent()){
            iProductService.delete(id);
            return "The product" + product.get().getTitle() + "has been removed";
        }
        return "Product not found";
    }

    @CrossOrigin(origins = {"http://localhost:3000","http://g7-front-bucket.app.s3-website.us-east-2.amazonaws.com"})
    @PutMapping("admin/api/v1/products/")
    public ResponseEntity<ProductDTO> update(@Valid @RequestBody ProductDTO productUpdate) {
        Optional<ProductDTO> product = iProductService.findById(productUpdate.getId());
        if (!product.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(iProductService.addProduct(productUpdate));
    }

    //Query ejemplo public/api/v1/products/available?startDate=1/1/2011&endDate=2/2/2011
    @CrossOrigin(origins = {"http://localhost:3000","http://g7-front-bucket.app.s3-website.us-east-2.amazonaws.com"})
    @GetMapping("public/api/v1/products/available")
    public ResponseEntity<ProductsAvaliable> findProductsByAvailableDate(
            @RequestParam(name = "startDate") String startDate,
            @RequestParam(name = "endDate") String endDate
            ){

        return ResponseEntity.ok(iProductService.findProductsByAvailableDate(startDate, endDate));
    }

//Query ejemplo public/api/v1/products/available?cityId=1&startDate=1/1/2011&endDate=2/2/2011
    @CrossOrigin(origins = {"http://localhost:3000","http://g7-front-bucket.app.s3-website.us-east-2.amazonaws.com"})
    @GetMapping("public/api/v1/products/available2")
    public ResponseEntity<ProductsAvaliable> findProductsByCityAndAvailableDate(
            @RequestParam(name = "cityId") Long cityId,
            @RequestParam(name = "startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) String startDate,
            @RequestParam(name = "endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) String endDate
    ){
        return ResponseEntity.ok(iProductService.findProductsByCityAndAvailableDate(cityId, startDate, endDate));
    }
}