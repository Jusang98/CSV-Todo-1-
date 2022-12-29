package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.repository.CsvStudents;
import com.nhnacademy.edu.springframework.project.repository.Scores;
import com.nhnacademy.edu.springframework.project.repository.Students;
import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    @Test
    void getPassedStudents() {
        Scores scores = null;
        Students name = null;
        Students studentRepository = CsvStudents.getInstance();
        DefaultStudentService studentService = new DefaultStudentService(scores,name);
        Collection<Student> passedStudents = studentService.getPassedStudents();
        assertEquals(studentRepository.findAll().stream()
            .filter(s->s.getScore().isFail())
            .collect(Collectors.toList()),passedStudents);
    }

    @Test
    void getStudentsOrderByScore() {
        Scores scores = null;
        Students name = null;
        DefaultStudentService studentService = new DefaultStudentService(scores,name);
        Students studentRepository = CsvStudents.getInstance();
        studentRepository.findAll();
        Collection<Student> orderedStudents = studentService.getStudentsOrderByScore();
        assertEquals(studentRepository.findAll().stream()
            .sorted(Comparator.comparing(Student::getScore))
            .collect(Collectors.toList()),orderedStudents);
    }
}