package no.experis.dungeonmaster.characters;

import no.experis.dungeonmaster.items.Item;
import no.experis.dungeonmaster.utilities.HeroAttribute;

import java.util.HashMap;
import java.util.Map;

public abstract class Hero {
    private String name;
    private int level;
    private Map<Slot, Item> equipment;
    private HeroAttribute levelAttributes;


    public Hero(String name, HeroAttribute startingAttributes) {
        this.name = name;
        this.level = 1;
        this.equipment = new HashMap<>();
        this.levelAttributes = startingAttributes;
    }

    public void equip(Item item) {
        Slot slot = item.getSlot();
        if (equipment.containsKey(slot)) {
            //unequip and put item
        }
        equipment.put(slot, item);
    }

    public enum Slot {
        WEAPON, BODY, LEGS, HEAD
    }
}
