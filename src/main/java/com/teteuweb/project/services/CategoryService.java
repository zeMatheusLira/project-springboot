package com.teteuweb.project.services;

import com.teteuweb.project.dtos.CategoryResponseDTO;
import com.teteuweb.project.entities.Category;
import com.teteuweb.project.entities.Product;
import com.teteuweb.project.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service //registra um serviço
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<Category> findAll() {

        //return repository.findAll().stream().map(Category::categoryResponseDTO).collect(Collectors.toList());
       return repository.findAll();
    }

    public Category findById(Long id) {
        Optional<Category> obj = repository.findById(id);
        return obj.get();
    }
}
