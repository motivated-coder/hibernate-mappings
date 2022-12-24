package com.skd.bidirectional.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "courseBi")
@Table(name = "course_bi")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;

    @ManyToMany(mappedBy = "courses",
            fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST)
    List<Student> students;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Teacher_Course",
            joinColumns = @JoinColumn(name = "Course_Id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "Teacher_Id",referencedColumnName = "id")
    )
    List<Teacher> teachers;

}
