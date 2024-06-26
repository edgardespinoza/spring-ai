package com.eespinor.openai.orders.domain.repository;

import com.eespinor.openai.orders.domain.model.Order;

import java.util.Collection;

public interface OrderRepository {
    Order save(Order order);
    Collection<Order> orders();
}
