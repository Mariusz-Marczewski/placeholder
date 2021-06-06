package com.example.placeholderapp.controller;

import com.example.placeholderapp.model.Record;
import com.example.placeholderapp.service.RecordService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(RecordController.class)
@ExtendWith(SpringExtension.class)
public class RecordControllerTest
{
    @MockBean
    private RecordService recordService;
    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp()
    {
        Record record = new Record(1, "title1", "body1");
    }

}
