package no.experis.dungeonmaster.items;

import no.experis.dungeonmaster.characters.Hero;
import no.experis.dungeonmaster.enums.ArmorType;
import no.experis.dungeonmaster.enums.Slot;
import no.experis.dungeonmaster.utilities.HeroAttribute;

public class Armor extends Item {

    private final HeroAttribute armorAttribute;
    private final ArmorType armorType;
    public Armor(int requiredLevel, ArmorType armorType, HeroAttribute armorAttribute) {
        super(requiredLevel);
        this.requiredLevel = requiredLevel;
        this.armorAttribute = armorAttribute;
        this.armorType = armorType;
    }

    public HeroAttribute getArmorAttribute() {
        return armorAttribute;
    }

    public ArmorType getArmorType() {
        return armorType;
    }

    @Override
    public Slot getSlot() {
        return Slot.BODY;
    }
}
