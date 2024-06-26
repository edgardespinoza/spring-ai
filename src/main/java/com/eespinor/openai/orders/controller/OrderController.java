package com.eespinor.openai.orders.controller;

import ch.qos.logback.classic.model.LoggerModel;
import com.eespinor.openai.orders.domain.OrderService;
import com.eespinor.openai.orders.domain.model.Order;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
@ResponseBody
@RequestMapping("/orders")
class OrderController {

    private final OrderService orderService;

    OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @PostMapping
    void save (@RequestBody Order order){
       var save = orderService.save(order);
        System.out.println("saved ["+save+"]");
    }

    @GetMapping
    Collection<Order> orders(){
        return orderService.orders();
    }
}
