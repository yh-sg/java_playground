package com.example.mapperdemo.dto;

import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class BookDto {
    @JsonProperty("id")
    private int id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("releaseDate")
    private Date releaseDate;

    @JsonProperty("authors")
    private Set<AuthorDto> authors;
}
