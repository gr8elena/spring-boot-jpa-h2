package com.example.springbootapph2.service;

import com.example.springbootapph2.entity.Country;
import com.example.springbootapph2.entity.dto.CountryDto;

import java.util.List;
import java.util.Optional;

public interface CountryService {

    List<Country> findAll();

    Optional<Country> save(CountryDto countryDto);
}
