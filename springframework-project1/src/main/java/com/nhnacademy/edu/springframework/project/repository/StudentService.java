package com.nhnacademy.edu.springframework.project.repository;

import com.nhnacademy.edu.springframework.project.service.Student;

import java.util.Collection;
import org.springframework.stereotype.Component;

@Component
public interface StudentService {
    Collection<Student> getPassedStudents();

    Collection<Student> getStudentsOrderByScore();
}
