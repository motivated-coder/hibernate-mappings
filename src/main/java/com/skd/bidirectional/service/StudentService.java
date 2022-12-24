package com.skd.bidirectional.service;

import com.skd.bidirectional.model.Student;
import com.skd.bidirectional.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student saveStudent(Student student) {
//        student.getProducts().stream().forEach(p -> p.setStudent(student));
        return studentRepository.save(student);
    }

    public Student getById(int id) {
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException());
    }
}
