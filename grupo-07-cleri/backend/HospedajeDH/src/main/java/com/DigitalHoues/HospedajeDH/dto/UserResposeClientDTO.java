package com.DigitalHoues.HospedajeDH.dto;

import com.DigitalHoues.HospedajeDH.entities.Booking;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
public class UserResposeClientDTO implements Serializable {
    private Long id;
    private String name;
    private String lastName;
    private String email;

}
