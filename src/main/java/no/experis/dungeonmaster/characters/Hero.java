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

    // Fields to store state
    protected String name;
    protected int level;
    protected Map<Slot, Item> equipment;
    protected HeroAttribute levelAttributes;

    public Hero(String name) {
        // Constructor to initialize new hero instance
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
        // Increases level and attributes
        HeroAttribute attributeGain = getLevelUpAttributeGain();
        levelAttributes.increaseStrength(attributeGain.getStrength());
        levelAttributes.increaseDexterity(attributeGain.getDexterity());
        levelAttributes.increaseIntelligence(attributeGain.getIntelligence());
        level++;
    }

    public void equip(Item item) throws InvalidEquipmentException {
        // Equips an item if valid

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
        // Calculates total attributes from level + equipment
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
        // Calculates hero's current damage output

        int weaponDamage = 1;
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

        return (weaponDamage * (1.00 + (damagingAttribute / 100.00)));
    }

    protected abstract boolean isValidEquipment(Item item);
    // Abstract method to check if equipment is valid, defined in the hero subclasses

    public abstract HeroAttribute getLevelUpAttributeGain();
    // Abstract method to get attributes gained on level up, defined in the hero subclasses

    public abstract double getDamage();
    // Abstract method to calculate final damage amount, defined in the hero subclasses
    public String display() {
        // Returns string representation of hero details

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
