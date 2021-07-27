package com.example.placeholderapp.repository;

import com.example.placeholderapp.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer>
{

}
