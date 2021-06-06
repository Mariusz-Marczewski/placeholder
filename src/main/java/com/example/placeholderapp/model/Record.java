package com.example.placeholderapp.model;


import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Record
{
    @Transient
    private Integer userId;
    @Id
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
