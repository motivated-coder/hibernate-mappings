package com.skd.unidirectional.repository;

import com.skd.unidirectional.model.Product;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("productRepositoryUni")
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
