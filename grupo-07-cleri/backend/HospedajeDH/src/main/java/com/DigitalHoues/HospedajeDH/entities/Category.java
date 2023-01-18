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
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 50)
    private String title;
    @Column(nullable = false,length = 50)
    private String description;
    @Column(nullable = false, length = 500)
    private String url;

    @OneToMany
    @JoinColumn(name = "category_id")
    private Set<Product> product;

/*
    @OneToMany(mappedBy = "category")
    private Set<Product> product;
*/
}
