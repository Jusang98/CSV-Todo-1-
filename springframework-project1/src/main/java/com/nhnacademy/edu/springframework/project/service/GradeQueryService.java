package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.repository.Score;

import java.util.List;
import org.springframework.stereotype.Component;

@Component
public interface GradeQueryService {
    List<Score> getScoreByStudentName(String name);
    Score getScoreByStudentSeq(int seq);
}
