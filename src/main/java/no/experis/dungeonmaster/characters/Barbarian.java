package no.experis.dungeonmaster.characters;

import no.experis.dungeonmaster.enums.ArmorType;
import no.experis.dungeonmaster.enums.Slot;
import no.experis.dungeonmaster.enums.WeaponType;
import no.experis.dungeonmaster.exceptions.InvalidEquipmentException;
import no.experis.dungeonmaster.items.Armor;
import no.experis.dungeonmaster.items.Item;
import no.experis.dungeonmaster.items.Weapon;
import no.experis.dungeonmaster.utilities.HeroAttribute;

import java.util.HashMap;
import java.util.Map;

public class Barbarian extends Hero {
    public Barbarian(String name) {
        super(name);
        levelAttributes = new HeroAttribute(5, 2, 1);
    }

    @Override
    protected boolean isValidEquipment(Item item) {
        if (item.getRequiredLevel() > level) {
            return false;
        }
        if (item instanceof Weapon) {
            WeaponType weaponType = ((Weapon) item).getWeaponType();
            return weaponType == WeaponType.HATCHET || weaponType == WeaponType.MACE || weaponType == WeaponType.SWORD;
        } else if (item instanceof Armor) {
            ArmorType armorType = ((Armor) item).getArmorType();
            return armorType == ArmorType.MAIL || armorType == ArmorType.PLATE;
        }
        return false;
    }

    @Override
    public HeroAttribute getLevelUpAttributeGain() {

        return new HeroAttribute(3, 2, 1);
    }

    @Override
    public int getDamage() {
        int strength = levelAttributes.getStrength();
        return (int) (calculateDamage() * (1 + strength / 100.0));
    }
}
