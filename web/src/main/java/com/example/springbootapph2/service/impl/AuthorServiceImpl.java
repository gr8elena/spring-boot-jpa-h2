package com.example.springbootapph2.service.impl;

import com.example.springbootapph2.entity.Author;
import com.example.springbootapph2.entity.Country;
import com.example.springbootapph2.entity.dto.AuthorDto;
import com.example.springbootapph2.exceptions.CountryNotFoundException;
import com.example.springbootapph2.repository.AuthorRepository;
import com.example.springbootapph2.repository.CountryRepository;
import com.example.springbootapph2.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Author> findAll() {
        return this.authorRepository.findAll();
    }

    @Override
    public Optional<Author> findById(Long id) {
        return this.authorRepository.findById(id);
    }

    @Override
    public Optional<Author> save(AuthorDto authorDto) {
        Country country = this.countryRepository.findById(authorDto.getAuthorCountryId())
                .orElseThrow(() -> new CountryNotFoundException());
        Author author = new Author(authorDto.getAuthorName(), authorDto.getAuthorSurname(), country);
        return Optional.of(this.authorRepository.save(author));
    }
}
