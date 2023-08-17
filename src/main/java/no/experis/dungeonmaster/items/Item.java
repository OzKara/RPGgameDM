package no.experis.dungeonmaster.items;

import no.experis.dungeonmaster.characters.Hero;
import no.experis.dungeonmaster.enums.Slot;

public abstract class Item {
    protected int requiredLevel;

    public Item(int requiredLevel) {
        this.requiredLevel = requiredLevel;
    }

    public int getRequiredLevel() {
        return requiredLevel;
    }

    public abstract Slot getSlot();
}
