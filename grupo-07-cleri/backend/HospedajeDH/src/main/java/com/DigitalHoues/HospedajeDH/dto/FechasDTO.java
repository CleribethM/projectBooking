package com.DigitalHoues.HospedajeDH.dto;

import com.DigitalHoues.HospedajeDH.entities.Product;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter

public class FechasDTO {

    public LocalDate fechaNoDisponible;
    public LocalDate fechaFinal;
    public Long product_id;

}
