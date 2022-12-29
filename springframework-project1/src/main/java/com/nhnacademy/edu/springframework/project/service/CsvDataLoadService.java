package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.AOP.TimeLogging;
import com.nhnacademy.edu.springframework.project.repository.CsvScores;
import com.nhnacademy.edu.springframework.project.repository.CsvStudents;
import com.nhnacademy.edu.springframework.project.repository.Score;
import com.nhnacademy.edu.springframework.project.repository.Scores;
import com.nhnacademy.edu.springframework.project.repository.Students;
import org.springframework.stereotype.Component;

@Component
public class CsvDataLoadService implements DataLoadService {
    private Scores scores;
    private Students students;
    public CsvDataLoadService(Scores scores,Students students){
        this.scores = scores;
        this.students = students;
    }
    @TimeLogging
    @Override
    public void loadAndMerge() {
        Scores scores = CsvScores.getInstance();
        scores.load();

        Students students = CsvStudents.getInstance();
        students.load();
        students.merge(scores.findAll());
    }
}
