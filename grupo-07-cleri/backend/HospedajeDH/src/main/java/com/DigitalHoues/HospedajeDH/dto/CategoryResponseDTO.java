package com.DigitalHoues.HospedajeDH.dto;

import com.DigitalHoues.HospedajeDH.entities.Product;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
public class CategoryResponseDTO implements Serializable {

    private Long id;
    private String title;
    private String description;

}
