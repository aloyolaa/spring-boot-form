package com.aloyolaa.springbootform.service;

import com.aloyolaa.springbootform.model.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {

    List<Country> findAll();

    Optional<Country> findById(Integer id);

}
