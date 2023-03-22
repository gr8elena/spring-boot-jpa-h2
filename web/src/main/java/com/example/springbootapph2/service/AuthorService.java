package com.example.springbootapph2.service;

import com.example.springbootapph2.entity.Author;
import com.example.springbootapph2.entity.dto.AuthorDto;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    List<Author> findAll();

    Optional<Author> findById(Long id);

    Optional<Author> save(AuthorDto authorDto);
}
