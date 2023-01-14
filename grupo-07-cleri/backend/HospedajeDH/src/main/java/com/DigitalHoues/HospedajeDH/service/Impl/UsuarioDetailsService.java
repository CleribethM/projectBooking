package com.DigitalHoues.HospedajeDH.service.Impl;

import com.DigitalHoues.HospedajeDH.entities.UserClient;
import com.DigitalHoues.HospedajeDH.repository.UserClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.integration.IntegrationProperties;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UsuarioDetailsService implements UserDetailsService {


    @Autowired
    UserClientRepository userClientRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserClient us = userClientRepository.findByEmail(username);

        if (us.getRole_id() == 1) {
            var rol = "USER";
            User.UserBuilder userBuilder = User.withUsername(username);
            // "secreto" => [BCrypt] => $2a$10$56VCAiApLO8NQYeOPiu2De/EBC5RWrTZvLl7uoeC3r7iXinRR1iiq
            String encryptedPassword = us.getPassword();
            userBuilder.password(encryptedPassword).roles(rol);
            return userBuilder.build();
        }
        if (us.getRole_id() == 2) {
            var rol = "ADMIN";
            User.UserBuilder userBuilder = User.withUsername(username);
            // "secreto" => [BCrypt] => $2a$10$56VCAiApLO8NQYeOPiu2De/EBC5RWrTZvLl7uoeC3r7iXinRR1iiq
            String encryptedPassword = us.getPassword();
            userBuilder.password(encryptedPassword).roles(rol);
            return userBuilder.build();
        }else {
            throw new UsernameNotFoundException(username);
        }
    }

}
