package com.eespinor.openai.orders.domain;

import com.eespinor.openai.orders.domain.model.Order;

import java.util.Collection;

public interface OrderService {
    Order save(Order order);
    Collection<Order> orders();
}
