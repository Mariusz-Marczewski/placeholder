package com.example.placeholderapp.model;


import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Data
@NoArgsConstructor
@Entity
public class Record
{
    @Transient
    private Integer userId;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;
    private String body;

    public Record(String title, String body)
    {
        this.title = title;
        this.body = body;
        this.userId = userId;
    }
}
