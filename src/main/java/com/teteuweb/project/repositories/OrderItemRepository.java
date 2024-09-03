package com.teteuweb.project.repositories;

import com.teteuweb.project.entities.OrderItem;
import com.teteuweb.project.entities.User;
import com.teteuweb.project.entities.pk.OrderItemPk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPk> {
}
