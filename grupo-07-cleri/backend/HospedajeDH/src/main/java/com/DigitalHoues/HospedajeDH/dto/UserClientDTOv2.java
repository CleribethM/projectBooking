package com.DigitalHoues.HospedajeDH.dto;

import com.DigitalHoues.HospedajeDH.entities.Booking;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
public class UserClientDTOv2 implements Serializable {
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private Set<Booking> booking;

}
