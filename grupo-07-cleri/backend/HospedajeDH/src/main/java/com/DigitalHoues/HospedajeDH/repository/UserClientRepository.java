package com.DigitalHoues.HospedajeDH.repository;



import com.DigitalHoues.HospedajeDH.entities.UserClient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserClientRepository extends JpaRepository<UserClient, Long> {

    UserClient findByEmail(String email);

}

