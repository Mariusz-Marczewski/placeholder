package com.example.placeholderapp.service;

import com.example.placeholderapp.model.Record;
import com.example.placeholderapp.repository.RecordRepository;
import lombok.Value;
import org.apache.http.HttpHost;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.stereotype.Service;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

    public Integer addRecordFromPlaceHolder()
    {
        return recordRepository.save(createRecord()).getId();
    }

    public void deleteAll()
    {
        recordRepository.deleteAll();
    }

    private Record createRecord()
    {
        Record record = null;
        JsonReader reader = null;
        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpHost target = new HttpHost("jsonplaceholder.typicode.com", 80, "http");
        HttpGet request = new HttpGet("/posts/1");
        request.addHeader("accept", "application/json");
        CloseableHttpResponse response = null;
        try {
            response = client.execute(target, request);
            if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                throw new Exception("Failed : HTTP error code : "
                        + response.getStatusLine().getStatusCode());
            }

            reader = Json.createReader(new InputStreamReader((response.getEntity().getContent())));
            JsonObject object = reader.readObject();

            record = new Record(object.getJsonNumber("user_id").intValue(), object.getJsonNumber("id").intValue(),
                    object.getString("title"), object.getString("body"));

        } catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            if (reader != null) reader.close();
            if (client != null)
            {
                try
                {
                    client.close();
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            if (response != null)
            {
                try
                {
                    response.close();
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
        return record;
    }
}