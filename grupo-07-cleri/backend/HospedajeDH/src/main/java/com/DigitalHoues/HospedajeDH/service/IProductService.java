package com.DigitalHoues.HospedajeDH.service;

import com.DigitalHoues.HospedajeDH.dto.ProductsAvaliable;
import com.DigitalHoues.HospedajeDH.dto.ProductDTO;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;

public interface IProductService {

    public ProductDTO addProduct(ProductDTO product);
    public void  delete (Long id);
    public Optional<ProductDTO> findById(Long id);
    public Set<ProductDTO> findAll();

    ProductsAvaliable findProductsByAvailableDate(String startDate, String endDate);
    ProductsAvaliable findProductsByCityAndAvailableDate(Long cityId, String startDate, String endDate);
}
