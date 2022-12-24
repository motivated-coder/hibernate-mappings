package com.skd.bidirectional.controller;

import com.skd.bidirectional.model.Student;
import com.skd.bidirectional.model.Teacher;
import com.skd.bidirectional.repository.TeacherRepository;
import com.skd.bidirectional.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/teacher")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @GetMapping("/fetchAll")
    public ResponseEntity getAllTeachers(){
        List<Teacher> teachers = teacherService.getAllTeachers();
        return new ResponseEntity(teachers, HttpStatus.OK);
    }


    @PostMapping("/save")
    public ResponseEntity saveTeacher(@RequestBody Teacher teacher){
        Teacher t = teacherService.saveTeacher(teacher);
        HttpHeaders headers = new HttpHeaders();
        headers.add("id", String.valueOf(t.getId()));
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @GetMapping("/fetch/{id}")
    public ResponseEntity getAllTeachers(@PathVariable int id){
        Teacher teacher = teacherService.getById(id);
        return new ResponseEntity(teacher, HttpStatus.OK);
    }
}
