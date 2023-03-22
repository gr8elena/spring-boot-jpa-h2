package com.example.springbootapph2.web.rest;

import com.example.springbootapph2.entity.Book;
import com.example.springbootapph2.entity.Country;
import com.example.springbootapph2.entity.dto.BookDto;
import com.example.springbootapph2.entity.dto.CountryDto;
import com.example.springbootapph2.service.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
public class CountryRestController {

    private final CountryService countryService;

    public CountryRestController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public List<Country> findAll()
    {
        return this.countryService.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<Country> save(@RequestBody CountryDto countryDto) {
        return this.countryService.save(countryDto)
                .map(country -> ResponseEntity.ok().body(country))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
}
