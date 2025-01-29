package com.example.item_upgrade_system;

public class App {
    public static void main( String[] args ) {
        Inventory inventory = new Inventory();
        UpgradeSystem upgradeSystem = new UpgradeSystem(inventory);

        inventory.addItem(new Item("Iron", Rarity.COMMON));
        inventory.addItem(new Item("Iron", Rarity.COMMON));
        inventory.addItem(new Item("Iron", Rarity.COMMON));

        inventory.addItem(new Item("Iron", Rarity.RARE));
        inventory.addItem(new Item("Iron", Rarity.RARE));
        inventory.addItem(new Item("Iron", Rarity.RARE));

        inventory.addItem(new Item("Gold", Rarity.COMMON));
        inventory.addItem(new Item("Gold", Rarity.COMMON));

        inventory.showInventory();
        upgradeSystem.upgradeItem("Iron", 1);

        inventory.showInventory();

        upgradeSystem.upgradeItem("Iron", 2);
        inventory.showInventory();

        inventory.addItem(new Item("Iron", Rarity.EPIC));
        inventory.showInventory();

        upgradeSystem.upgradeItem("Iron", 2);
        inventory.showInventory();
    }
}
