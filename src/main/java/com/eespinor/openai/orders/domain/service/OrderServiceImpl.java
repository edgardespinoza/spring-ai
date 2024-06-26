package com.eespinor.openai.orders.domain.service;

import com.eespinor.openai.inventory.InventoryUpdatedEvent;
import com.eespinor.openai.orders.domain.OrderService;
import com.eespinor.openai.orders.domain.model.Order;
import com.eespinor.openai.orders.domain.repository.OrderRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final  ApplicationEventPublisher applicationEventPublisher;

    OrderServiceImpl(OrderRepository orderRepository, ApplicationEventPublisher applicationEventPublisher) {
        this.orderRepository = orderRepository;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Transactional
    public Order save(Order order) {

        var saved = this.orderRepository.save(order);

        saved.lineItems().forEach(item->{
            applicationEventPublisher.publishEvent(
                    new InventoryUpdatedEvent(item.product(), item.quantity())
            );
        });

        return saved;
    }

    @Override
    public Collection<Order> orders() {
        return orderRepository.orders();
    }
}
