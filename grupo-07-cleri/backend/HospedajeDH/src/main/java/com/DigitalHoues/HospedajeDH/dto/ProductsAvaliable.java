package com.DigitalHoues.HospedajeDH.dto;

import com.DigitalHoues.HospedajeDH.entities.Product;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
@Getter
@Setter
@Builder
public class ProductsAvaliable {
    private LocalDate startDate;
    private LocalDate endDate;
    private List<Product> products;
}
