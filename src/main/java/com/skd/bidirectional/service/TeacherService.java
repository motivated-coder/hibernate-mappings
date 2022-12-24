package com.skd.bidirectional.service;

import com.skd.bidirectional.model.Product;
import com.skd.bidirectional.model.Teacher;
import com.skd.bidirectional.repository.ProductRepository;
import com.skd.bidirectional.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    TeacherRepository teacherRepository;

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public Teacher getById(int id) {
        return teacherRepository.findById(id).orElseThrow(() -> new RuntimeException("Teacher Not Found"));
    }
}
