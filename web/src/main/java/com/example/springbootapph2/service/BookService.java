package com.example.springbootapph2.service;

import com.example.springbootapph2.entity.Book;
import com.example.springbootapph2.entity.dto.BookDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> findAll();

    Optional<Book> findById(Long id);

    Optional<Book> save(BookDto bookDto);

    Optional<Book> edit(Long id, BookDto bookDto);

    void deleteById(Long id);

    Optional<Book> changeAvailability(Long id);
}
