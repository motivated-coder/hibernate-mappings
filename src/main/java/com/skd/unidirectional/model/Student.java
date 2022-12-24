package com.skd.unidirectional.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    String address;
    String phone;
    @OneToMany(targetEntity = Product.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "sp_fk", referencedColumnName = "id")
    List<Product> products;
}
