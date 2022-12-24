package com.skd.unidirectional.service;

import com.skd.unidirectional.model.Student;
import com.skd.unidirectional.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("studentServiceUni")
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student saveStudent(Student student) {
       return studentRepository.save(student);
    }

    public Student getById(int id) {
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException());
    }
}
