package com.skd.bidirectional.controller;

import com.skd.bidirectional.model.Student;
import com.skd.bidirectional.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/fetchAll")
    public ResponseEntity getAllStudents(){
        List<Student> students = studentService.getAllStudents();
        return new ResponseEntity(students, HttpStatus.OK);
    }


    @PostMapping("/save")
    public ResponseEntity saveStudent(@RequestBody Student student){
        Student s = studentService.saveStudent(student);
        HttpHeaders headers = new HttpHeaders();
        headers.add("id", String.valueOf(s.getId()));
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @GetMapping("/fetch/{id}")
    public ResponseEntity getAllStudents(@PathVariable int id){
        Student student = studentService.getById(id);
        return new ResponseEntity(student, HttpStatus.OK);
    }
}









