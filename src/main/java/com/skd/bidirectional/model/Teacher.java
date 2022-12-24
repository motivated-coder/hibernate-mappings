package com.skd.bidirectional.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity(name = "teacherBi")
@Table(name="teacher_bi")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "teachers")
    List<Course> courses;

    public void setCourses(List<Course> courses) {
        this.courses = courses;
        List<Teacher> teachers= new ArrayList<>();
        teachers.add(this);
        courses.stream().forEach(c -> c.setTeachers(teachers));
    }
}
