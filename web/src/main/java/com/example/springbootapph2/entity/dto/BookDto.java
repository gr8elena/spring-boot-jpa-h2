package com.example.springbootapph2.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookDto {

    private String bookName;

    private String bookCategory;

    private Long bookAuthorId;

    private Integer availableCopies;

}
