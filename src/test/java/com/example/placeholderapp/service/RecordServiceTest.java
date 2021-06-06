package com.example.placeholderapp.service;

import com.example.placeholderapp.model.Record;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class RecordServiceTest
{
    @Autowired
    private RecordService sut;

    @BeforeEach
    public void setUp()
    {
        sut.deleteAll();
    }

    @Test
    @Transactional
    public void shouldReturnAllRecords()
    {
        // given
        Record record1 = new Record(1, "title1", "body1");
        Record record2 = new Record(2, "title2", "body2");
        sut.addRecord(record1);
        sut.addRecord(record2);

        // when
        int actual = sut.findAll().size();

        // then
        assertThat(actual).isEqualTo(2);
    }

    @Test
    @Transactional
    public void shouldAddRecord(){
        // given
        Record record = new Record(1, "title", "body");

        //when
        int size = sut.findAll().size();
        sut.addRecord(record);
        int actual = sut.findAll().size();

        //then
        assertThat(actual).isGreaterThan(size);
        assertThat(actual).isEqualTo(1);
    }

    @Test
    @Transactional
    public void shouldDeleteRecord(){
        // given
        Record recordToDelete = new Record(1, "title", "body");

        //when
        Integer isToDelete = sut.addRecord(recordToDelete);

        sut.deleteRecord(isToDelete);
        int actual = sut.findAll().size();

        //then
        assertThat(actual).isEqualTo(0);
    }

    @Test
    @Transactional
    public void shouldUpdateRecord(){
        //given
        Record recordToUpdate = new Record(1, "title", "body");
        Integer id = sut.addRecord(recordToUpdate);
        Record record = new Record(1, "title1", "body1");

        //when
        Record actual = sut.updateRecord(record);

        //then
        assertThat(actual).isEqualTo(record);
    }

    @Test
    @Transactional
    public void shouldReturnRecordByTitle()
    {
        // given

        Record record1 = new Record(1, "title1", "body1");
        Record record2 = new Record(2, "title2", "body2");
        sut.addRecord(record1);
        sut.addRecord(record2);
        String title = record1.getTitle();

        // when

        List<Record> recordByTitle = sut.getRecordByTitle(title);

        // then

        assertThat(recordByTitle.size()).isEqualTo(1);
        assertThat(recordByTitle.get(0)).isEqualTo(record1);
    }
}