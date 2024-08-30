package com.teteuweb.project.repositories;

import com.teteuweb.project.entities.Category;
import com.teteuweb.project.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
