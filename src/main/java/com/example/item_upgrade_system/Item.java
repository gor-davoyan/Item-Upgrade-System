package com.example.item_upgrade_system;

public class Item {
    private final String name;
    private Rarity rarity;
    private int upgradeCount;

    public Item(String name, Rarity rarity) {
        this.name = name;
        this.rarity = rarity;
        this.upgradeCount = 0;
    }

    public String getName() {
        return name;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public int getUpgradeCount() {
        return upgradeCount;
    }

    public void setRarity(Rarity rarity) {
        this.rarity = rarity;
    }

    public void incrementUpgradeCount() {
        this.upgradeCount++;
    }

    public void resetUpgradeCount() {
        this.upgradeCount = 0;
    }

    @Override
    public String toString() {
        return name + " {" + rarity + (rarity == Rarity.EPIC && upgradeCount > 0 ? "_" + upgradeCount : "") + "}";
    }
}
