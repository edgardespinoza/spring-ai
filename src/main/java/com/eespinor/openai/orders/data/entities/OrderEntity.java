package com.eespinor.openai.orders.data.entities;


import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Set;

@Table("orders")
public record OrderEntity(@Id Integer id, Set<LineItemEntity> lineItems) {
}
