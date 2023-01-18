package com.DigitalHoues.HospedajeDH.dto;

import com.DigitalHoues.HospedajeDH.entities.Feature;
import com.DigitalHoues.HospedajeDH.entities.Image;

import java.util.Set;

public class ProductResponse {
    private Long id;
    private String title;
    private String titleDescription;
    private String description;
    private String houseRules;
    private String healthAndSafety;
    private String cancellationPolicies;
    private Integer punctuation;
    private Long city_id;
    private Long category_id;
    private Set<Feature> feature;
    private Set<Image> image;
}
