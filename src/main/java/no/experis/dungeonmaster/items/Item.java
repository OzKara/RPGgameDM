package no.experis.dungeonmaster.items;

import no.experis.dungeonmaster.enums.Slot;

public abstract class Item {

    private final int requiredLevel;
    private final String name;
    protected final Slot slot;
    public Item(String name, int requiredLevel, Slot slot) {
        this.requiredLevel = requiredLevel;
        this.name = name;
        this.slot = slot;
    }

    public String getName() {
        return name;
    }

    public int getRequiredLevel() {
        return requiredLevel;
    }

    public abstract Slot getSlot();

}
