package com.teteuweb.project.dtos;


import java.util.Set;

public record ProductRequestDTO(String name, String description, Double price, String imgUrl, Set<Long>categoryId) {
}