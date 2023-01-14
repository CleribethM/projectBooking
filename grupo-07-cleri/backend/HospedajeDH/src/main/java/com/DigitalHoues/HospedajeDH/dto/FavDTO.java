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

public class FavDTO implements Serializable {
    private Long id;
    @NotNull
    private Long id_client;
    @NotNull
    private Long product_id;

}
