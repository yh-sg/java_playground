package com.example.mapperdemo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class BookSlimDto {
    @JsonProperty("id")
    private int id;

    @JsonProperty("title")
    private String title;

}
