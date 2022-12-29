package com.nhnacademy.edu.springframework.project.repository;

import com.nhnacademy.edu.springframework.project.service.Student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.stereotype.Component;

@Component
public class CsvStudents implements Students {


    private final static CsvStudents csvStudents = new CsvStudents();

    private ArrayList<Student> studentlist;


    public CsvStudents() {
        studentlist = new ArrayList<>();
    }


    /**
     * TODO 3 :
     * Java Singleton 패턴으로 getInstance() 를 구현하세요.
     **/

    public static Students getInstance() {
        return csvStudents;
    }

    // TODO 7 : student.csv 파일에서 데이터를 읽어 클래스 멤버 변수에 추가하는 로직을 구현하세요.
    // 데이터를 적재하고 읽기 위해서, 적절한 자료구조를 사용하세요.
    @Override
    public void load() {
        studentlist = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(
            "C:\\Users\\rlatk\\IdeaProjects\\Nhn\\springframework-project1\\src\\main\\resources\\data\\student.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                studentlist.add(new Student(Integer.parseInt(values[0]), values[1]));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        System.out.println(studentlist);
    }

    @Override
    public Collection<Student> findAll() {
        return studentlist;
    }

    /**
     * TODO 8 : students 데이터에 score 정보를 추가하세요.
     *
     * @param scores
     */
    @Override
    public void merge(Collection<Score> scores) {
        int i = 0;
        for(Score score :scores){
            studentlist.get(i).setScore(score);
            score.getScore();
            i++;
        }
    }
}
