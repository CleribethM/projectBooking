package com.DigitalHoues.HospedajeDH.service;

import com.DigitalHoues.HospedajeDH.entities.Role;

import java.util.Optional;
import java.util.Set;

public interface IRoleService {

    public Role saveRole(Role role);
    public Optional<Role> findById(Long id);
    public Set<Role> findAllRole();
    public void delete(Long id);
}
