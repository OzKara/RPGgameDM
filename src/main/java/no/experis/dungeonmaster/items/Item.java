package no.experis.dungeonmaster.items;

import no.experis.dungeonmaster.enums.Slot;

public abstract class Item {

    private final int requiredLevel; // Minimum level required to equip item
    private final String name; // Name of the item, like "Fire Wand"

    protected final Slot slot;
    // Equipment slot the item belongs to in Slot enum
    public Item(String name, int requiredLevel, Slot slot) {
        // Constructor to initialize item
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
