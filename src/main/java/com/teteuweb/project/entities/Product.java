package com.teteuweb.project.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.teteuweb.project.dtos.CategoryResponseDTO;
import com.teteuweb.project.dtos.ProductRequestDTO;
import com.teteuweb.project.dtos.ProductResponseDTO;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
    @Table(name = "tb_product")
    public class Product implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String name;
        private String description;
        private Double price;
        private String imgUrl;

        @ManyToMany
        @JoinTable(name = "tb_product_category",
                joinColumns = @JoinColumn(name = "product_id"),
                inverseJoinColumns = @JoinColumn(name = "category_id"))

        private Set<Category> categories = new HashSet<>();// set garante que o produto nao se repita a instancia garante que ela comece vazia e não nula

        @OneToMany(mappedBy = "id.product")
        private Set<OrderItem> items = new HashSet<>();

        public Product() {
        }

        public Product(ProductRequestDTO dto){
            this.name = dto.name();
            this.description = dto.description();
            this.price = dto.price();
            this.imgUrl = dto.imgUrl();
        }

        public ProductResponseDTO productResponseDTO() {
            Set<CategoryResponseDTO> categoriesResponseDTO = categories.stream().map(Category::categoryResponseDTO).collect(Collectors.toSet());

            return new ProductResponseDTO(id, name, description, price, imgUrl, categoriesResponseDTO);
        }

        public void setId(Long id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setPrice(Double price) {
            this.price = price;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public Long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }

        public Double getPrice() {
            return price;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        @JsonIgnore
        public Set<Order> getOrders() {
            Set<Order> set = new HashSet<>();
            for (OrderItem item : items) {
                set.add(item.getOrder());
            }
            return set;
        }

        public Set<Category> getCategories() {
            return categories;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            com.teteuweb.project.entities.Product product = (com.teteuweb.project.entities.Product) o;
            return Objects.equals(id, product.id);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(id);
        }
    }
