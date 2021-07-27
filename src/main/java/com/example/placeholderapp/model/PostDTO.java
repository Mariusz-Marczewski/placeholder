package com.example.placeholderapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.WRITE_ONLY;

public class PostDTO
{
    private Long id;
    @JsonProperty(access = WRITE_ONLY)
    private Long userId;
    private String title;
    private String body;
}
