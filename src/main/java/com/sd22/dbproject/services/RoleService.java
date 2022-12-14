package com.sd22.dbproject.services;

import com.sd22.dbproject.entities.Role;
import com.sd22.dbproject.exceptions.NotFoundException;
import com.sd22.dbproject.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public Set<Role> getRoles() {
        Set<Role> roles = new HashSet<>();
        roleRepository.findAll().forEach(roles::add);
        return roles;
    }

    public Role addRole(Role role) {
        return roleRepository.save(role);
    }

    public Role findRoleById(int id) {
        return roleRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public Optional<Role> findRoleByName(String name) {
        return roleRepository.findByName(name);
    }

    public void deleteRoleById(int id) {
        roleRepository.deleteById(id);
    }

    public Role updateRole(Role role){
        return roleRepository.save(role);
    }
}
