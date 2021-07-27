package com.example.placeholderapp.repository;

import com.example.placeholderapp.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PostRepository extends JpaRepository<Post, Integer>
{
    @Query(value = "SELECT r.* FROM record r WHERE r.title = :title", nativeQuery = true)
    Post getRecordByTitle(String title);

}
