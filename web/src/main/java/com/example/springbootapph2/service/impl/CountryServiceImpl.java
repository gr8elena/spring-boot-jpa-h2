package com.example.springbootapph2.service.impl;

import com.example.springbootapph2.entity.Country;
import com.example.springbootapph2.entity.dto.CountryDto;
import com.example.springbootapph2.repository.CountryRepository;
import com.example.springbootapph2.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> findAll() {
        return this.countryRepository.findAll();
    }

    @Override
    public Optional<Country> save(CountryDto countryDto) {
        Country country = new Country(countryDto.getCountryName(), countryDto.getCountryContinent());
        return Optional.of(this.countryRepository.save(country));
    }
}
