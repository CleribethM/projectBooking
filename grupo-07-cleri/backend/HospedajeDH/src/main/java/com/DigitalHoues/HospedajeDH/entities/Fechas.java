package com.DigitalHoues.HospedajeDH.entities;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="fechas")
public class Fechas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name= "Fecha",nullable = false, length = 15)
    private LocalDate fechaNoDisponible;
    @Column(nullable = false, length = 15)
    private Long product_id;

    public Fechas(LocalDate fechaNoDisponible, Long product_id) {
        this.fechaNoDisponible = fechaNoDisponible;
        this.product_id = product_id;
    }
}
