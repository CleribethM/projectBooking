package com.DigitalHoues.HospedajeDH.service.Impl;

import com.DigitalHoues.HospedajeDH.dto.ProductDTO;
import com.DigitalHoues.HospedajeDH.dto.ProductsAvaliable;
import com.DigitalHoues.HospedajeDH.entities.Booking;
import com.DigitalHoues.HospedajeDH.entities.Product;
import com.DigitalHoues.HospedajeDH.exception.NotFoundException;
import com.DigitalHoues.HospedajeDH.repository.BookingRepository;
import com.DigitalHoues.HospedajeDH.repository.ProductRepository;
import com.DigitalHoues.HospedajeDH.service.IProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class ProductService implements IProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    BookingRepository bookingRepository;


    @Autowired
    ObjectMapper mapper;

    @Override
    public ProductDTO addProduct(ProductDTO productDto) {

        Product product = mapper.convertValue(productDto, Product.class);
        Product newProduct = productRepository.save(product);
        return mapper.convertValue(newProduct, ProductDTO.class);
    }

    @Override
    public void delete(Long id) {
        this.findById(id);
        productRepository.deleteById(id);

    }

    @Override
    public Optional<ProductDTO> findById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Product does not exits"));
        ProductDTO productDTO =mapper.convertValue(product, ProductDTO.class);
        return Optional.ofNullable(productDTO);
    }

    @Override
    public Set<ProductDTO> findAll() {
        List<Product> product = productRepository.findAll();
        Set<ProductDTO> productDTO = new HashSet<>();

        for(Product productoDto : product){
            productDTO.add(mapper.convertValue(productoDto, ProductDTO.class));
        }
        return productDTO;
    }

    @Override
    public ProductsAvaliable findProductsByAvailableDate(String startDate, String endDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startLocalDate = LocalDate.parse(startDate, formatter);
        LocalDate endLocalDate = LocalDate.parse(endDate, formatter);
        List<Product> products = productRepository.findAll();
        return getProductsAvaliable(startLocalDate, endLocalDate, products);
    }

    @Override
    public ProductsAvaliable findProductsByCityAndAvailableDate(Long cityId, String startDate, String endDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startLocalDate = LocalDate.parse(startDate, formatter);
        LocalDate endLocalDate = LocalDate.parse(endDate, formatter);
        List<Product> products = productRepository.findByCity(cityId);
        return getProductsAvaliable(startLocalDate, endLocalDate, products);
    }

    private ProductsAvaliable getProductsAvaliable(LocalDate startLocalDate, LocalDate endLocalDate, List<Product> products) {
        List<Product> avaliableProducts = new ArrayList<>();
        products.forEach(product -> {
            List<Booking> bookings = bookingRepository.findByProductIdAndStartDateAndEndDate(product.getId(),
                    startLocalDate, endLocalDate);
            if (bookings.isEmpty()) {
                avaliableProducts.add(product);
            }
        });
        System.out.println(avaliableProducts);
        return ProductsAvaliable.builder().startDate(startLocalDate).endDate(endLocalDate).products(avaliableProducts)
                .build();
    }
}
