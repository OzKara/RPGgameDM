package no.experis.dungeonmaster.items;

import no.experis.dungeonmaster.characters.Hero;

public abstract class Item {
    protected String name;
    protected int requiredLevel;
    protected Slot slot;

    public Item(String name, int requiredLevel, Slot slot) {
        this.name = name;
        this.requiredLevel = requiredLevel;
        this.slot = slot;
    }

    public String getName() {
        return name;
    }

    public int getRequiredLevel() {
        return requiredLevel;
    }

    public Hero.Slot getSlot() {
        return slot;
    }

    public enum Slot {
        WEAPON, BODY, LEGS, HEAD
    }
}
