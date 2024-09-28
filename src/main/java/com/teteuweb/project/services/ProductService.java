package com.teteuweb.project.services;

import com.teteuweb.project.dtos.ProductResponseDTO;
import com.teteuweb.project.entities.Product;
import com.teteuweb.project.repositories.ProductRepository;

import com.teteuweb.project.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service //registra um serviço
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<ProductResponseDTO> findAll() {
        return repository.findAll().stream().map(Product::productResponseDTO).collect(Collectors.toList());
    }

    public ProductResponseDTO findById(Long id) {
        Optional<Product> obj = repository.findById(id);
        return obj.orElseThrow(() ->  new ResourceNotFoundException(id)).productResponseDTO();
    }
}
