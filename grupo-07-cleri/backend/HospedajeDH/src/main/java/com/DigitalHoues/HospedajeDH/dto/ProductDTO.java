package com.DigitalHoues.HospedajeDH.dto;
import com.DigitalHoues.HospedajeDH.entities.Booking;
import com.DigitalHoues.HospedajeDH.entities.Feature;
import com.DigitalHoues.HospedajeDH.entities.Image;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter

public class ProductDTO implements Serializable {
    private Long id;
    @NotBlank
    private String title;
    @NotBlank
    private String description;
    @NotNull
    private Integer punctuation;
    @NotBlank
    private String healthAndSafety;
    @NotBlank
    private String cancellationPolicies;
    @NotNull
    private Set<Image> Image;
    @NotBlank
    private String houseRules;
    @NotBlank
    private String titleDescription;
    @NotNull
    private Long city_id;
    @NotNull
    private Long category_id;
    private Set<Feature> feature;
    private Set<Booking> booking;

}
