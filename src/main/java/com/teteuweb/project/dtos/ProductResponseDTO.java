package com.teteuweb.project.dtos;

import java.util.Set;

public record ProductResponseDTO(Long id, String name, String description, Double price, String imgUrl, Set<CategoryResponseDTO> categories) {
}
