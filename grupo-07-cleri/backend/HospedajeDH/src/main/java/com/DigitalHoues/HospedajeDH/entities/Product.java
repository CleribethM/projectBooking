package com.DigitalHoues.HospedajeDH.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="product")
public class  Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String title;
    @Column(name="title_description", nullable = false, length = 200)
    private String titleDescription;
    @Column(nullable = false, length = 400) //modificar en la BD a NOT NULL
    private String description;
    @Column(name="house_rules", nullable = false, length = 200)
    private String houseRules;
    @Column(name="health_and_safety", nullable = true, length = 200)
    private String healthAndSafety;
    @Column(name="cancellation_policies", nullable = false, length = 200)
    private String cancellationPolicies;
    @Column(nullable = false)
    private Integer punctuation;
    @Column(nullable = false)
    private Long city_id;
    @Column(nullable = false)
    private Long category_id;


    @ManyToMany
    @JoinTable(name= "product_has_features",
            joinColumns = @JoinColumn (name = "idproduct"),
            inverseJoinColumns = @JoinColumn (name = "idfeature"))
    private Set<Feature> feature;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Set<Image> image;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Set<Booking> booking;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Set<Fechas> fechas;



     /*



    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;


    // Relacion Muchos a muchos
    // Se crea una tabla intermedia para alojar las relaciones
    // Y se mapea una lista de la segunda entidad


  */
}
