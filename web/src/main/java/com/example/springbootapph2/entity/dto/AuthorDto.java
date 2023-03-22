package com.example.springbootapph2.entity.dto;

import com.example.springbootapph2.entity.Country;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthorDto {

    private String authorName;

    private String authorSurname;

    private Long authorCountryId;
}
