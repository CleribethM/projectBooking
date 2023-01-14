package com.DigitalHoues.HospedajeDH.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Audit")
public class Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String Accion;

    @Column(nullable = false)
    private String User;

    @Column(nullable = false)
    private String Description;

    @Column(nullable = true)
    private LocalTime date;

    public Audit(String accion, String User,String description,LocalTime localTime){
        this.Accion =accion;
        this.User =User;
        this.Description = description;
        this.date = localTime;
    }
}
