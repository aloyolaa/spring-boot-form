package com.aloyolaa.springbootform.service;

import com.aloyolaa.springbootform.model.Country;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    private final List<Country> countries;

    public CountryServiceImpl() {
        this.countries = Arrays.asList(
                new Country(1, "ES", "España"),
                new Country(2, "MX", "México"),
                new Country(3, "CL", "Chile"),
                new Country(4, "AR", "Argentina"),
                new Country(5, "PE", "Perú"),
                new Country(6, "CO", "Colombia"),
                new Country(7, "VE", "Venezuela")
        );
    }

    @Override
    public List<Country> findAll() {
        return countries;
    }

    @Override
    public Optional<Country> findById(Integer id) {
        return countries.stream().filter(c -> c.getId().equals(id)).findFirst();
    }
}
