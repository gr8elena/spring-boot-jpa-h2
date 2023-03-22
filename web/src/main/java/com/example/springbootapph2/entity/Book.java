package com.example.springbootapph2.entity;

import com.example.springbootapph2.entity.enumerations.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="book_id")
    private Long bookId;

    @Column(name="book_name")
    private String bookName;

    @Column(name = "book_category")
    @Enumerated(value = EnumType.STRING)
    private Category bookCategory;

    @ManyToOne
    private Author bookAuthor;

    @Column(name="available_copies")
    private Integer availableCopies;

    @Column(name="book_availability")
    private boolean isAvailable;

    public Book(String bookName, Category bookCategory, Author bookAuthor, Integer availableCopies, boolean isAvailable) {
        this.bookName = bookName;
        this.bookCategory = bookCategory;
        this.bookAuthor = bookAuthor;
        this.availableCopies = availableCopies;
        this.isAvailable = isAvailable;
    }
}
