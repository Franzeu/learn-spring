package com.franz.demo.rest;

import com.franz.demo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    // define and endpoint for "/students" - return a list of students

    @GetMapping("/students")
    public List<Student> getStudents(){
        List<Student> theStudents = new ArrayList<>();

        theStudents.add(new Student("Anro", "Oblv"));
        theStudents.add(new Student("April", "Oh"));
        theStudents.add(new Student("Francis", "Country"));

        return theStudents;
    }



}
