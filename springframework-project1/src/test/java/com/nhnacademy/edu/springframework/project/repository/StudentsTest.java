package com.nhnacademy.edu.springframework.project.repository;

import com.nhnacademy.edu.springframework.project.service.Student;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentsTest {

    @Test
    void load() {

        String i = "2";

        ArrayList<Student> testlist = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(
            "C:\\Users\\rlatk\\IdeaProjects\\Nhn\\springframework-project1\\src\\main\\resources\\data\\student.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                testlist.add(new Student(Integer.parseInt(values[0]), (values[0])));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        System.out.println(testlist.get(1).getScore());
////        csvScores.load();

        assertEquals(i, testlist.get(1).getName());

    }

    @Test
    void findAll() {
        CsvStudents csvStudents = new CsvStudents();
        csvStudents.load();
        String i = "A";
        Assertions.assertThat(csvStudents.findAll().stream()
            .sorted(Comparator.comparing(Student::getName))
            .collect(Collectors.toList()).get(0));
        assertEquals(i,csvStudents.findAll().stream()
            .sorted(Comparator.comparing(Student::getName))
            .collect(Collectors.toList()).get(0).getName());
    }

    @Test
    void merge() {
        CsvStudents csvStudents = new CsvStudents();
        Scores scores = CsvScores.getInstance();
        csvStudents.merge(scores.findAll());
    }
}