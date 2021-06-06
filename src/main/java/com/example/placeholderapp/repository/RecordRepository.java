package com.example.placeholderapp.repository;

import com.example.placeholderapp.model.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RecordRepository extends JpaRepository<Record, Integer>
{
    @Query(value = "SELECT r.* FROM record r WHERE r.title = :title", nativeQuery = true)
    List<Record> getRecordByTitle(String title);

}
