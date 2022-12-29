package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.AOP.TimeLogging;
import com.nhnacademy.edu.springframework.project.repository.CsvScores;
import com.nhnacademy.edu.springframework.project.repository.CsvStudents;
import com.nhnacademy.edu.springframework.project.repository.Score;

import com.nhnacademy.edu.springframework.project.repository.Scores;
import com.nhnacademy.edu.springframework.project.repository.Students;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
public class DefaultGradeQueryService implements GradeQueryService {
    private Scores scores;
    private Students students;
    public DefaultGradeQueryService(Scores scores,Students students){
        this.scores = scores;
        this.students = students;
    }
    @TimeLogging
    @Override
    public List<Score> getScoreByStudentName(String name) {
        Students studentRepository = CsvStudents.getInstance();
        List<Score> ScoreBy = new ArrayList<>();
            studentRepository.findAll().stream()
            .filter(h -> h.getName().equals(name)).forEach(student -> ScoreBy.add(student.getScore()));
        return ScoreBy;

    }
    // TODO 6 : 학번으로 점수를 반환합니다. seq 인자가 학번입니다.
    @TimeLogging
    @Override
    public Score getScoreByStudentSeq(int seq) {
        Scores scoreRepository = CsvScores.getInstance();

        Score score1 = scoreRepository.findAll().stream()
            .filter(h -> h.getStudentSeq() == seq)
            .findFirst()
            .get();
        return score1;
    }
}
// TODO 5: 학생 이름으로 점수를 반환합니다. 동명이인 고려합니다.
// resources/data/student.csv 를 보면 학번, 이름으로 구성되어있습니다. 학번은 숫자, 이름은 알파벳입니다.
// resources/data/score.csv 를 보면 학번, 점수로 구성되어있습니다. 학번은 숫자, 점수는 숫자입니다.
//
// 만약 getScoreByStudentName() 인자 name에 동명이인인 학생이름을 넣으면, 동명이인의 Score 들을 리턴합니다.
// 인자 - 학생이름
// 반환 - 점수리스트
//
// Hint. CsvStudents 클래스의 findAll() 이 있네요? 적절히 필터링하고 찾아오면 되겠죠?
//