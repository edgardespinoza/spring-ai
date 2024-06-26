package com.eespinor.openai.orders.data.entities;


import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("orders_line_items")
public record LineItemEntity(@Id Integer id, int product, int quantity) {
}
