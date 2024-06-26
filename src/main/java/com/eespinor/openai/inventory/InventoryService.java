package com.eespinor.openai.inventory;

import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Service;

@Service
class InventoryService {

    @ApplicationModuleListener
    void onInventoryUpdatedEvent(InventoryUpdatedEvent inventoryUpdatedEvent) throws InterruptedException {
        Thread.sleep(10_000);
        System.out.println("The inventory has been updated[" + inventoryUpdatedEvent + "]");
    }
}
