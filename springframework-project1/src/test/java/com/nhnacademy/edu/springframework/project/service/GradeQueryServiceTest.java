package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.repository.CsvScores;
import com.nhnacademy.edu.springframework.project.repository.CsvStudents;
import com.nhnacademy.edu.springframework.project.repository.Score;
import com.nhnacademy.edu.springframework.project.repository.Scores;
import com.nhnacademy.edu.springframework.project.repository.Students;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GradeQueryServiceTest {

    @Test
    void getScoreByStudentName() {

        Students studentRepository = CsvStudents.getInstance();
        List<Score> ScoreBy = new ArrayList<>();
        Scores scores = null;
        Students name = null;
        studentRepository.findAll().stream()
            .filter(h -> h.getName().equals(name)).forEach(student -> ScoreBy.add(student.getScore()));

        DefaultGradeQueryService studentService2 = new DefaultGradeQueryService(scores,name);
        Collection<Score> ScoreByStudentName = studentService2.getScoreByStudentName("D");
        assertEquals(ScoreByStudentName,ScoreBy);
//        Assertions.assertThat(studentService2.getScoreByStudentName("A")).isEqualTo(i);
    }

    @Test
    void getScoreByStudentSeq() {
        Scores scores = null;
        Students name = null;
        DataLoadService dataLoadService = new CsvDataLoadService(scores,name);
        dataLoadService.loadAndMerge();
        Scores scoreRepository = CsvScores.getInstance();
        int seq = 15;
        String i = "[]";
        DefaultGradeQueryService studentService2 = new DefaultGradeQueryService(scores,name);
        Score ScoreByStudentSeq = studentService2.getScoreByStudentSeq(15);

        assertEquals(scoreRepository.findAll().stream().filter(h -> h.getStudentSeq() == seq)
            .findFirst()
            .get(), ScoreByStudentSeq);
    }
}