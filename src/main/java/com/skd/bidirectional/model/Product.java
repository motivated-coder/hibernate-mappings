package com.skd.bidirectional.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "productBi")
@Table(name = "product_bi")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "student_id")
    Student student;
}
