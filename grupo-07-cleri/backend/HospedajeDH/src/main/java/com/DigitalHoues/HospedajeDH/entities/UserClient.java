package com.DigitalHoues.HospedajeDH.entities;

import com.DigitalHoues.HospedajeDH.dto.BookingResponse;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "client")
public class UserClient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 45)
    private String name;
    @Column(nullable = false, length = 45)
    private String lastName;
    @Column(nullable = false, length = 100)
    private String email;
    @Column(nullable = false, length = 500)
    private String password;
    @Column(nullable = false, length = 1)
    private Integer role_id;
    @Column
    private Long phone;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    private Set<Booking> booking;







}
