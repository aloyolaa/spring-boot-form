package com.aloyolaa.springbootform.service;

import com.aloyolaa.springbootform.model.Role;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    private final List<Role> roles;

    public RoleServiceImpl() {
        this.roles = Arrays.asList(
                new Role(1, "Administrator", "ROLE_ADMINISTRATOR"),
                new Role(2, "User", "ROLE_USER"),
                new Role(3, "Moderator", "ROLE_MODERATOR")
        );
    }

    @Override
    public List<Role> findAll() {
        return this.roles;
    }

    @Override
    public Optional<Role> findById(Integer id) {
        return this.roles.stream().filter(r -> r.getId().equals(id)).findFirst();
    }

}
