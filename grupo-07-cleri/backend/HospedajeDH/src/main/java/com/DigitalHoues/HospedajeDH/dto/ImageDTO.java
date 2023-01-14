package com.DigitalHoues.HospedajeDH.dto;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Getter
@Setter

public class ImageDTO implements Serializable{
    private Long id;
    @NotBlank
    private String title;
    @NotBlank
    private String url;


}
