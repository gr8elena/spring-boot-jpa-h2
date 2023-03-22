package com.example.springbootapph2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private Long authorId;

    @Column(name = "author_name")
    private String authorName;

    @Column(name = "author_surname")
    private String authorSurname;

    @ManyToOne
    private Country authorCountry;

    public Author(String authorName, String authorSurname, Country authorCountry) {
        this.authorName = authorName;
        this.authorSurname = authorSurname;
        this.authorCountry = authorCountry;
    }
}
