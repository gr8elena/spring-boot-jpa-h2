package com.example.springbootapph2.service.impl;

import com.example.springbootapph2.entity.Author;
import com.example.springbootapph2.entity.Book;
import com.example.springbootapph2.entity.dto.BookDto;
import com.example.springbootapph2.entity.enumerations.Category;
import com.example.springbootapph2.exceptions.AuthorNotFoundException;
import com.example.springbootapph2.exceptions.BookNotFoundException;
import com.example.springbootapph2.repository.AuthorRepository;
import com.example.springbootapph2.repository.BookRepository;
import com.example.springbootapph2.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return this.bookRepository.findById(id);
    }

    @Override
    public Optional<Book> save(BookDto bookDto) {

        Category bookCategory = Category.valueOf(bookDto.getBookCategory());

        Author author = this.authorRepository.findById(bookDto.getBookAuthorId())
                .orElseThrow(AuthorNotFoundException::new);

        Book book = new Book(bookDto.getBookName(), bookCategory, author,bookDto.getAvailableCopies(), true);
        return Optional.of(this.bookRepository.save(book));
    }

    @Override
    public Optional<Book> edit(Long id, BookDto bookDto) {

        Book book = this.bookRepository.findById(id)
                .orElseThrow(BookNotFoundException::new);
        Author author = this.authorRepository.findById(bookDto.getBookAuthorId())
                .orElseThrow(AuthorNotFoundException::new);
        book.setBookAuthor(author);
        book.setBookCategory(Category.valueOf(bookDto.getBookCategory()));
        book.setBookName(bookDto.getBookName());
        book.setAvailableCopies(bookDto.getAvailableCopies());

        return Optional.of(this.bookRepository.save(book));
    }

    @Override
    public void deleteById(Long id) {
        this.bookRepository.deleteById(id);
    }

    @Override
    public Optional<Book> changeAvailability(Long id) {

        Book bookForChange = this.bookRepository.findById(id)
                .orElseThrow(BookNotFoundException::new);
        Integer availableCopies = bookForChange.getAvailableCopies();
        if(availableCopies > 0)
        {
            bookForChange.setAvailableCopies(--availableCopies);

            if(availableCopies == 0) {
                bookForChange.setAvailable(false);
            }
        }
        this.bookRepository.save(bookForChange);
        return Optional.of(bookForChange);
    }
}
