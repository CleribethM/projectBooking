package com.DigitalHoues.HospedajeDH.dto;
import com.DigitalHoues.HospedajeDH.entities.Product;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter

public class CityDTO implements Serializable {
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String location;
    @NotBlank
    private String country;
    @NotNull
    private String postalCode;
    private Set<Product> product;
}
