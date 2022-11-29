package com.aloyolaa.springbootform.service;

import com.aloyolaa.springbootform.model.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {

    List<Role> findAll();

    Optional<Role> findById(Integer id);

}
