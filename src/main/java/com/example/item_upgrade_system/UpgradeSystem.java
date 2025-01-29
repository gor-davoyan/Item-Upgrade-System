package com.example.item_upgrade_system;


import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class UpgradeSystem {
    private static final Logger logger = Logger.getLogger(UpgradeSystem.class.getName());

    private final Inventory inventory;

    public UpgradeSystem(Inventory inventory) {
        this.inventory = inventory;
    }

    /**
     * upgrades with item name by given position(index)
     * @param itemName name of the item
     * @param index index of item in the current group of items. like
     *  Iron: [Iron {COMMON}, Iron {COMMON}, Iron {COMMON}, Iron {RARE}, Iron {RARE}, Iron {RARE}]
     *              1                2            3              4            5             6
     */
    public void upgradeItem(String itemName, int index) {
        List<Item> items = inventory.getItems(itemName);

        if (items == null || items.isEmpty()) {
            logger.severe("Item not found: " + itemName);
            return;
        }

        int i = index - 1;
        Rarity currentRarity = items.get(i).getRarity();
        if (currentRarity == Rarity.EPIC) {
            handleEpicUpgrade(items, i);
        } else {
            handleGeneralUpgrade(items, i);
        }
    }

    private void handleEpicUpgrade(List<Item> items, int index) {
        Item firstItem = items.get(index);
        int currentCount = firstItem.getUpgradeCount();

        for (int i = index + 1; i < items.size(); i++) {
            Item tmp = items.get(i);
            if (tmp.getRarity() == Rarity.EPIC) {
                if (currentCount > tmp.getUpgradeCount()) {
                    firstItem.incrementUpgradeCount();
                    items.remove(tmp);
                    logger.info(firstItem.getName() + " upgraded to Epic " + firstItem.getUpgradeCount());
                } else {
                    tmp.incrementUpgradeCount();
                    items.remove(firstItem);
                    logger.info(tmp.getName() + " upgraded to Epic " + tmp.getUpgradeCount());
                }
            }
        }
    }

    private void handleGeneralUpgrade(List<Item> items, int index) {
        Item itemToUpgrade = items.get(index);
        Rarity currentRarity = itemToUpgrade.getRarity();
        if (items.size() < 3) {
            logger.severe("Not enough items to upgrade " + itemToUpgrade.getName());
            return;
        }

        List<Item> itemsToRemoveAfterUpgrade = new ArrayList<>();
        for (int i = index + 1; i < items.size(); i++) {
            Item item = items.get(i);
            if (item.getRarity() == currentRarity) {
                itemToUpgrade.incrementUpgradeCount();
                itemsToRemoveAfterUpgrade.add(item);
            }
        }

        if (itemToUpgrade.getUpgradeCount() == 2) {
            itemToUpgrade.setRarity(nextRarity(currentRarity));
            items.removeAll(itemsToRemoveAfterUpgrade);
            logger.severe("item " + itemToUpgrade.getName() + " upgraded to " + itemToUpgrade.getRarity());
        } else {
            logger.severe("Not enough items to upgrade " + itemToUpgrade.getName());
        }

        itemToUpgrade.resetUpgradeCount();
        itemsToRemoveAfterUpgrade.clear();
    }

    private Rarity nextRarity(Rarity current) {
        switch (current) {
            case COMMON:
                return Rarity.GREAT;
            case GREAT:
                return Rarity.RARE;
            case RARE:
                return Rarity.EPIC;
            case EPIC:
                return Rarity.LEGENDARY;
            default:
                throw new IllegalArgumentException();
        }
    }
}
