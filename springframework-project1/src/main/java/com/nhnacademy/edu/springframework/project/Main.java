package com.nhnacademy.edu.springframework.project;

import com.nhnacademy.edu.springframework.project.repository.CsvScores;
import com.nhnacademy.edu.springframework.project.repository.CsvStudents;
import com.nhnacademy.edu.springframework.project.repository.Score;
import com.nhnacademy.edu.springframework.project.repository.StudentService;
import com.nhnacademy.edu.springframework.project.service.CsvDataLoadService;
import com.nhnacademy.edu.springframework.project.service.DataLoadService;
import com.nhnacademy.edu.springframework.project.service.DefaultGradeQueryService;
import com.nhnacademy.edu.springframework.project.service.DefaultStudentService;
import com.nhnacademy.edu.springframework.project.service.GradeQueryService;
import com.nhnacademy.edu.springframework.project.service.Student;

import java.util.Collection;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

//@EnableAspectJAutoProxy

public class Main {

    // TODO 9 - 성공적으로 실행되어야 합니다.
    public static void main(String[] args) {
//    CsvStudents csvStudents = new CsvStudents();
//    CsvScores csvScores = new CsvScores();
//    csvStudents.load();
//    csvScores.load();
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.nhnacademy.edu.springframework.project");
        System.out.println("-------------------------------------------------------------------");
        context.getBean("csvDataLoadService",DataLoadService.class).loadAndMerge();
        System.out.println( context.getBean("defaultStudentService", StudentService.class).getPassedStudents());
        System.out.println(context.getBean("defaultStudentService", StudentService.class).getStudentsOrderByScore());
        System.out.println(context.getBean("defaultGradeQueryService", GradeQueryService.class).getScoreByStudentName("D"));
        System.out.println(context.getBean("defaultGradeQueryService", GradeQueryService.class).getScoreByStudentSeq(15));
//
//        DefaultStudentService studentService = new DefaultStudentService();
//        Collection<Student> passedStudents = studentService.getPassedStudents();
//        System.out.println(passedStudents);
//
//        Collection<Student> orderedStudents = studentService.getStudentsOrderByScore();
//        System.out.println(orderedStudents);
//
//        DefaultGradeQueryService studentService2 = new DefaultGradeQueryService();
//        Collection<Score> ScoreByStudentName = studentService2.getScoreByStudentName("D");
//        System.out.println(ScoreByStudentName);
//
//        Score ScoreByStudentSeq = studentService2.getScoreByStudentSeq(15);
//        System.out.println(ScoreByStudentSeq);
    }
}
