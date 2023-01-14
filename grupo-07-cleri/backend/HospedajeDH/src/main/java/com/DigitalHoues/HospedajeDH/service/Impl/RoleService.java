package com.DigitalHoues.HospedajeDH.service.Impl;

import com.DigitalHoues.HospedajeDH.entities.Role;
import com.DigitalHoues.HospedajeDH.repository.RoleRepository;
import com.DigitalHoues.HospedajeDH.service.IRoleService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class RoleService implements IRoleService {


    @Autowired
    RoleRepository roleRepository;

    @Autowired
    ObjectMapper mappper;


    public Role saveRole(Role role) {
       return roleRepository.save(role);
    }

    public Optional<Role> findById(Long id) {
        return roleRepository.findById(id);
    }

    public Set<Role> findAllRole() {
        List<Role> role = roleRepository.findAll();
        Set<Role> role1 = new HashSet<>();
        return role1;
    }

    public void delete(Long id){
        roleRepository.deleteById(id);
    }
}


