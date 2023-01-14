package com.DigitalHoues.HospedajeDH.dto;

import com.DigitalHoues.HospedajeDH.entities.Product;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Builder
public class BookingDTO implements Serializable {
    private Long id;
    private Time startTime;
    private LocalDate startDate;
    private LocalDate endDate;
    @NotNull
    private Long product_id;
    @NotNull
    private Long client_id;

}
