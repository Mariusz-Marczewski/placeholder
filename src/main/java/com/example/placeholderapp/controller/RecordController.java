package com.example.placeholderapp.controller;

import com.example.placeholderapp.model.Record;
import com.example.placeholderapp.service.RecordService;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Value
@RestController
public class RecordController
{
    RecordService recordService;

    @GetMapping("/records")
    public List<Record> findAll()
    {
        return recordService.findAll();
    }

    @GetMapping(value = "/records/get/{title}", produces = "application/json")
    public List<Record> getByTitle(@PathVariable String title)
    {
        return recordService.getRecordByTitle(title);
    }

    @DeleteMapping("/records/delete/{id}")
    public ResponseEntity<Void> removeRecord(@PathVariable Integer id)
    {
        recordService.deleteRecord(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/records/add")
    public ResponseEntity<Integer> add(@RequestBody Record record)
    {
        return new ResponseEntity<Integer>(recordService.addRecord(record), HttpStatus.CREATED);
    }

    @PutMapping(value = "records/update", consumes = "application/json")
    public ResponseEntity<Record> update(Record record)
    {
        return new ResponseEntity<>(recordService.updateRecord(record), HttpStatus.CREATED);
    }
}
