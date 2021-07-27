package com.example.placeholderapp.model;

import lombok.Data;
import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
public class Post
{
    @Id
    private Long id;
    @Column(name = "USER_ID")
    private Long userId;
    private String title;
    @Column(length = 1024)
    private String body;
    private boolean edited;
    private boolean deleted;

    @Override
    public boolean equals(Object other)
    {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        var post = (Post) other;
        return Objects.equals(id, post.id);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, userId, title, body, edited, deleted);
    }
}
