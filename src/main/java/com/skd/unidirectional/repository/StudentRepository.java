package com.skd.unidirectional.repository;

import com.skd.unidirectional.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("studentRepositoryUni")
public interface StudentRepository extends JpaRepository<Student,Integer> {
}
