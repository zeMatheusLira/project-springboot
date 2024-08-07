package com.teteuweb.project.repositories;

import com.teteuweb.project.entities.Order;
import com.teteuweb.project.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
