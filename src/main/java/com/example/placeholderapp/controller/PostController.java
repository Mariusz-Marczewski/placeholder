package com.example.placeholderapp.controller;

import com.example.placeholderapp.model.Post;
import com.example.placeholderapp.service.PostService;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Value
@RestController
public class PostController
{
    PostService recordService;

    @GetMapping(value = "/records", produces = "application/json")
    public List<Post> findAll()
    {
        return recordService.findAll();
    }

    @GetMapping(value = "/records/get/{title}", produces = "application/json")
    public Post getByTitle(@PathVariable String title)
    {
        return recordService.getRecordByTitle(title);
    }

    @DeleteMapping("/records/delete/{id}")
    public ResponseEntity<Void> removeRecord(@PathVariable Integer id)
    {
        recordService.deleteRecord(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "/records/add", consumes = "application/json")
    public ResponseEntity<Integer> add(@RequestBody Post record)
    {
        return new ResponseEntity<Integer>(recordService.addRecord(record), HttpStatus.CREATED);
    }

    @PutMapping(value = "records/update", consumes = "application/json")
    public ResponseEntity<Post> update(Post record)
    {
        return new ResponseEntity<>(recordService.updateRecord(record), HttpStatus.CREATED);
    }

    @PostMapping(value = "records/import", consumes = "application/json")
    public ResponseEntity<Integer> create()
    {
        return new ResponseEntity<>(recordService.addRecordFromPlaceHolder(), HttpStatus.CREATED);
    }
}
