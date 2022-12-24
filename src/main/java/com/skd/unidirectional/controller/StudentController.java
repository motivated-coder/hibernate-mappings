package com.skd.unidirectional.controller;

import com.skd.unidirectional.model.Student;
import com.skd.unidirectional.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController("studentControllerUni")
@RequestMapping("/api/v1/student")
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









