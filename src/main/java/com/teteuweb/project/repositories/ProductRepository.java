package com.teteuweb.project.repositories;

import com.teteuweb.project.entities.Category;
import com.teteuweb.project.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
