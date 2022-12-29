package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.repository.CsvScores;
import com.nhnacademy.edu.springframework.project.repository.CsvStudents;
import com.nhnacademy.edu.springframework.project.repository.Scores;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DataLoadServiceTest {

    @Test
    void loadAndMerge() {

        CsvStudents csvStudents = new CsvStudents();
        Scores scores = CsvScores.getInstance();
        csvStudents.merge(scores.findAll());


    }
}