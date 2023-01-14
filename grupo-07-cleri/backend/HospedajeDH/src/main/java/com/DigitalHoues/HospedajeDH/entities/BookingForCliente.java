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
@Table(name = "BookingForCliente")
public class BookingForCliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long id_client;

    @Column(nullable = false)
    private Long id_booking;

    @Column(nullable = false)
    private String product;

    @Column()
    private String city;

    @Column()
    private String category;

    @Column()
    private String image;

    @Column(nullable = false)
    private LocalDate startDay;

    @Column(nullable = false)
    private LocalDate endDay;

    @Column(nullable = false)
    private Integer puntuation;

    @Column(nullable = false)
    private Long product_id;

    public BookingForCliente(Long id_client, Long id_booking, String product,
                             LocalDate startDay, LocalDate endDay, String city, String category,
                             String image, Integer puntation,Long product_id) {
        this.id_client = id_client;
        this.id_booking = id_booking;
        this.product = product;
        this.startDay = startDay;
        this.endDay = endDay;
        this.city = city;
        this.category = category;
        this.image = image;
        this.puntuation = puntation;
        this.product_id = product_id;
     }
}
