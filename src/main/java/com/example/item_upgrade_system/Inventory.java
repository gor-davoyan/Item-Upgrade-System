package com.example.item_upgrade_system;

import java.util.*;
import java.util.logging.Logger;

public class Inventory {
    private static final Logger logger = Logger.getLogger(Inventory.class.getName());

    private final Map<String, List<Item>> items = new HashMap<>();

    public void addItem(Item item) {
        items.computeIfAbsent(item.getName(), i -> new ArrayList<>()).add(item);

        logger.info("added item - " + item);
    }

    public List<Item> getItems(String itemName) {
        return items.get(itemName);
    }

    public List<Item> removeItems(String itemName) {
        return items.remove(itemName);
    }

    public void showInventory() {
        System.out.println("#--- Inventory ---#");
        items.forEach((name, itemList) -> System.out.println(name + ": " + itemList));
    }
}
