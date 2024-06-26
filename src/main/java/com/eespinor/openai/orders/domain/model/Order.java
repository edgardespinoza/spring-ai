package com.eespinor.openai.orders.domain.model;

import java.util.Set;

public record Order(Integer id, Set<LineItem> lineItems) {
}
