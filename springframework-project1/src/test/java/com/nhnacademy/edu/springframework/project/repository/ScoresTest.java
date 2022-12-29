package com.nhnacademy.edu.springframework.project.repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScoresTest {
    @DisplayName("score.csv 파일에서 데이터를 제대로 읽어오는지 확인")
    @Test
    void loadTest() {

        int i = 80;

        ArrayList<Score> testlist = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(
            "C:\\Users\\rlatk\\IdeaProjects\\Nhn\\springframework-project1\\src\\main\\resources\\data\\score.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                testlist.add(new Score(Integer.parseInt(values[0]), Integer.parseInt(values[1])));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        System.out.println(testlist.get(1).getScore());
////        csvScores.load();

        assertEquals(i, testlist.get(1).getScore());

    }

    @Test
    void findAllTest() {
        CsvScores csvScores = new CsvScores();
        csvScores.load();
        int i = 80;
        Assertions.assertThat(csvScores.findAll().get(1).getScore()).isEqualTo(i);
    }
}