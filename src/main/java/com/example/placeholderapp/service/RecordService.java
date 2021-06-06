package com.example.placeholderapp.service;

import com.example.placeholderapp.model.Record;
import com.example.placeholderapp.repository.RecordRepository;
import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.Value;
import net.minidev.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Value
@Service
public class RecordService
{
    RecordRepository recordRepository;

    public List<Record> findAll()
    {
        return recordRepository.findAll();
    }

    public List<Record> getRecordByTitle(String title)
    {
        if(title != null)
        {
            return recordRepository.getRecordByTitle(title);
        }
        return new ArrayList<>(recordRepository.findAll());
    }

    public void deleteRecord(Integer id)
    {
        recordRepository.deleteById(id);
    }

    public Integer addRecord(Record record)
    {
        return recordRepository.save(record).getId();
    }

    public Record updateRecord(Record record)
    {
        return recordRepository.save(record);
    }

    public void deleteAll()
    {
        recordRepository.deleteAll();
    }
}