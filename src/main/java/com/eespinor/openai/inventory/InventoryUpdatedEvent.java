package com.eespinor.openai.inventory;


public record InventoryUpdatedEvent(int product, int quantity) {
}
