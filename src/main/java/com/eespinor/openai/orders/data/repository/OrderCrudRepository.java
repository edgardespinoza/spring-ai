package com.eespinor.openai.orders.data.repository;

import com.eespinor.openai.orders.data.entities.OrderEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface OrderCrudRepository extends ListCrudRepository<OrderEntity, Integer> {
}
