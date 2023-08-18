package no.experis.dungeonmaster.items;

import no.experis.dungeonmaster.enums.ArmorType;
import no.experis.dungeonmaster.enums.Slot;
import no.experis.dungeonmaster.utilities.HeroAttribute;

public class Armor extends Item {

    private final HeroAttribute armorAttribute; // Armor bonuses
    private final ArmorType armorType; // Type of armor in ArmorType enum
    public Armor(String name, int requiredLevel, Slot slot, ArmorType armorType, HeroAttribute armorAttribute) {
        super(name, requiredLevel, slot);
        this.armorAttribute = armorAttribute;
        this.armorType = armorType;
    }

    public ArmorType getArmorType() {
        return armorType;
    }

    public HeroAttribute getArmorAttribute() {
        return armorAttribute;
    }

    @Override
    public Slot getSlot() {
        return slot;
    }
}
