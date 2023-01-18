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
@Table(name = "Fav")
public class Fav {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long id_client;

    @Column(nullable = false)
    private String product;

    @Column()
    private String city;

    @Column()
    private String category;

    @Column()
    private String image;

    @Column(nullable = false)
    private Integer puntuation;

    @Column(nullable = false)
    private Long product_id;

    public Fav(Long id_client,  String product, String city, String category,
               String image, Integer puntation, Long product_id) {
        this.id_client = id_client;
        this.product = product;
        this.city = city;
        this.category = category;
        this.image = image;
        this.puntuation = puntation;
        this.product_id = product_id;
     }
}
