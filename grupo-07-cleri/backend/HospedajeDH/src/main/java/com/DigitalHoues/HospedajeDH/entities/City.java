package com.DigitalHoues.HospedajeDH.entities;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


@Entity
@Table(name="city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 45)
    private String name;
    @Column(nullable = false, length = 45)
    private String location;
    @Column(nullable = false, length = 45)
    private String country;
    @Column(name="postal_code", nullable = false, length = 10)
    private int postalCode;

    @OneToMany
    @JoinColumn(name = "city_id")
    private Set<Product> product;


}
