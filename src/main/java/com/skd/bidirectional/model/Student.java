package com.skd.bidirectional.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "studentBi")
@Table(name = "student_bi")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    String address;
    String phone;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "student",
    cascade = CascadeType.ALL)
    List<Product> products;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "Student_Course",
            joinColumns = {
                    @JoinColumn(name = "Student_id",referencedColumnName = "id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "Course_id",referencedColumnName = "id")
            })
    List<Course> courses;


    public void setProducts(List<Product> products) {
        this.products = products;
        products.stream().forEach(p -> p.setStudent(this));
    }

//    public void setCourses(List<Course> courses) {
//        this.courses = courses;
//        courses.stream().forEach(c -> c.students.add(this));
//    }
}
