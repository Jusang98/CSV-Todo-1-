package com.nhnacademy.edu.springframework.project.config;

import com.nhnacademy.edu.springframework.project.service.CsvDataLoadService;
import com.nhnacademy.edu.springframework.project.service.DefaultGradeQueryService;
import com.nhnacademy.edu.springframework.project.service.DefaultStudentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@EnableAspectJAutoProxy(exposeProxy = true)

public class ServiceConfig {
    private MainConfig mainconfig;

    @Bean
    public CsvDataLoadService csvDataLoadService(){
    return new CsvDataLoadService(mainconfig.csvScores(),mainconfig.csvStudents());
    }
    @Bean
    public DefaultGradeQueryService defaultGradeQueryService(){
        return new DefaultGradeQueryService(mainconfig.csvScores(), mainconfig.csvStudents());
    }
    @Bean
    public DefaultStudentService defaultStudentService(){
        return new DefaultStudentService(mainconfig.csvScores(), mainconfig.csvStudents());
    }
}
