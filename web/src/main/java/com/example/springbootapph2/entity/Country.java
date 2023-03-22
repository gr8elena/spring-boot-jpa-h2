package com.example.springbootapph2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private Long countryId;

    @Column(name="country_name")
    private String countryName;

    @Column(name="country_continent")
    private String countryContinent;

    public Country(String countryName, String countryContinent) {
        this.countryName = countryName;
        this.countryContinent = countryContinent;
    }
}
