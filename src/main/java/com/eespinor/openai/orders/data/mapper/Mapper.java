package com.eespinor.openai.orders.data.mapper;


import com.eespinor.openai.orders.data.entities.LineItemEntity;
import com.eespinor.openai.orders.data.entities.OrderEntity;
import com.eespinor.openai.orders.domain.model.LineItem;
import com.eespinor.openai.orders.domain.model.Order;

import java.util.stream.Collectors;

public class Mapper {
    public static Order toOrder(OrderEntity dto) {
        return new Order(
                dto.id(),
                dto.lineItems() != null ? dto.lineItems().stream().map(Mapper::toLineItem).collect(Collectors.toSet()) : null
        );
    }

    public static OrderEntity toOrderEntity(Order dto) {
        return new OrderEntity(
                dto.id(),
                dto.lineItems() != null ? dto.lineItems().stream().map(Mapper::toLineItemEntity).collect(Collectors.toSet()) : null
        );
    }

    public static LineItem toLineItem(LineItemEntity dto) {
        return new LineItem(
                dto.id(),
                dto.product(),
                dto.quantity()
        );
    }

    public static LineItemEntity toLineItemEntity(LineItem dto) {
        return new LineItemEntity(
                dto.id(),
                dto.product(),
                dto.quantity()
        );
    }
}