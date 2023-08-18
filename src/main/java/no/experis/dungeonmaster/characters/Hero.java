package no.experis.dungeonmaster.characters;

import no.experis.dungeonmaster.enums.Slot;
import no.experis.dungeonmaster.exceptions.InvalidEquipmentException;
import no.experis.dungeonmaster.items.Armor;
import no.experis.dungeonmaster.items.Item;
import no.experis.dungeonmaster.items.Weapon;
import no.experis.dungeonmaster.utilities.HeroAttribute;

import java.util.HashMap;
import java.util.Map;

public abstract class Hero {
    protected String name;
    protected int level;
    protected Map<Slot, Item> equipment;
    protected HeroAttribute levelAttributes;

    public Hero(String name) {
        this.name = name;
        this.level = 1;
        this.levelAttributes = new HeroAttribute(0, 0,0);
        this.equipment = new HashMap<>();
        initializeEmptyEquipmentSlots();
    }

    private void initializeEmptyEquipmentSlots() {
        for (Slot slot : Slot.values()) {
            equipment.put(slot, null);
        }
    }

    public void levelUp() {
        HeroAttribute attributeGain = getLevelUpAttributeGain();
        levelAttributes.increaseStrength(attributeGain.getStrength());
        levelAttributes.increaseDexterity(attributeGain.getDexterity());
        levelAttributes.increaseIntelligence(attributeGain.getIntelligence());
        level++;
    }

    public void equip(Item item) throws InvalidEquipmentException {
        Slot slot = item.getSlot();
        if (!isValidEquipment(item)) {
            throw new InvalidEquipmentException("Invalid equipment for this hero.");
        }

        Item unequippedItem = equipment.put(slot, item);
        if (unequippedItem instanceof Weapon || unequippedItem instanceof Armor) {
            // Handle the previous item if needed later
        }
    }

    public HeroAttribute getTotalAttributes() {
        HeroAttribute totalAttributes = new HeroAttribute(
                levelAttributes.getStrength(),
                levelAttributes.getDexterity(),
                levelAttributes.getIntelligence()
        );

        // Add attributes from equipped armor
        for (Item item : equipment.values()) {
            if (item instanceof Armor) {
                HeroAttribute armorAttributes = ((Armor) item).getArmorAttribute();
                totalAttributes.increaseStrength(armorAttributes.getStrength());
                totalAttributes.increaseDexterity(armorAttributes.getDexterity());
                totalAttributes.increaseIntelligence(armorAttributes.getIntelligence());
            }
        }

        return totalAttributes;
    }

    public double calculateDamage() {
        double weaponDamage = 0;
        Item weapon = equipment.get(Slot.WEAPON);
        if (weapon instanceof Weapon) {
            weaponDamage = ((Weapon) weapon).getWeaponDamage();
        }

        int damagingAttribute;
        if (this instanceof Wizard) {
            damagingAttribute = getTotalAttributes().getIntelligence();
        } else if (this instanceof Archer || this instanceof Swashbuckler) {
            damagingAttribute = getTotalAttributes().getDexterity();
        } else if (this instanceof Barbarian) {
            damagingAttribute = getTotalAttributes().getStrength();
        } else {
            throw new IllegalStateException("Unsupported hero class");
        }

        return weaponDamage * (1 + damagingAttribute / 100.0);
    }

    protected abstract boolean isValidEquipment(Item item);

    public abstract HeroAttribute getLevelUpAttributeGain();

    public abstract int getDamage();

    public String display() {
        StringBuilder builder = new StringBuilder();
        builder.append("Name: ").append(name).append("\n");
        builder.append("Class: ").append(getClass().getSimpleName()).append("\n");
        builder.append("Level: ").append(level).append("\n");
        HeroAttribute totalAttributes = getTotalAttributes();
        builder.append("Total Strength: ").append(totalAttributes.getStrength()).append("\n");
        builder.append("Total Dexterity: ").append(totalAttributes.getDexterity()).append("\n");
        builder.append("Total Intelligence: ").append(totalAttributes.getIntelligence()).append("\n");
        builder.append("Damage: ").append(getDamage()).append("\n");
        return builder.toString();
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public Map<Slot, Item> getEquipment() {
        return equipment;
    }

    public HeroAttribute getLevelAttributes() {
        return levelAttributes;
    }

}
