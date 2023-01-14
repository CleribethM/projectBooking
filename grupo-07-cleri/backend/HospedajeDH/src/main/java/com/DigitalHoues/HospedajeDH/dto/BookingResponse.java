package com.DigitalHoues.HospedajeDH.dto;

import com.DigitalHoues.HospedajeDH.entities.Product;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
public class BookingResponse {
    private Long id;
    private Time startTime;
    private LocalDate startDate;
    private LocalDate endDate;
    private Long client_id;
    private Long product_id;
    //private Set<Product> products;
}
