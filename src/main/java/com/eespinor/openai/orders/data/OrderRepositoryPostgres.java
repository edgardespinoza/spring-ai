package com.eespinor.openai.orders.data;

import com.eespinor.openai.orders.data.mapper.Mapper;
import com.eespinor.openai.orders.data.repository.OrderCrudRepository;
import com.eespinor.openai.orders.domain.model.Order;
import com.eespinor.openai.orders.domain.repository.OrderRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
class OrderRepositoryPostgres implements OrderRepository {
    private OrderCrudRepository orderRepository;

    public OrderRepositoryPostgres(OrderCrudRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order save(Order order){
        var itemSave = orderRepository.save(Mapper.toOrderEntity(order));

        return Mapper.toOrder(itemSave);
    }

    @Override
    public Collection<Order> orders() {
        return orderRepository.findAll().stream().map(Mapper::toOrder).collect(Collectors.toList());
    }
}
