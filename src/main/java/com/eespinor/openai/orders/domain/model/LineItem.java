package com.eespinor.openai.orders.domain.model;

import java.util.Set;

public record LineItem(Integer id, int product, int quantity) {
}
