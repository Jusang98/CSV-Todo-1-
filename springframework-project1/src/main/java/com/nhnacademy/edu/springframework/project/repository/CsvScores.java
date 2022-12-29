package com.nhnacademy.edu.springframework.project.repository;

import com.nhnacademy.edu.springframework.project.service.Student;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class CsvScores implements Scores {

    private final static CsvScores csvScores = new CsvScores();
    private ArrayList<Score> scorelist;


    public CsvScores() {
        scorelist = new ArrayList<>();
    }


    /**
     * TODO 2 :
     * Java Singleton 패턴으로 getInstance() 를 구현하세요.
     **/
    public static Scores getInstance() {
        return csvScores;
    }

    // TODO 5 : score.csv 파일에서 데이터를 읽어 멤버 변수에 추가하는 로직을 구현하세요.
    @Override
    public void load() {
         scorelist = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\rlatk\\IdeaProjects\\Nhn\\springframework-project1\\src\\main\\resources\\data\\score.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                scorelist.add(new Score(Integer.parseInt(values[0]),Integer.parseInt(values[1])));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        System.out.println(scorelist);
    }

    @Override
    public List<Score> findAll() {
        return scorelist;
    }
}
