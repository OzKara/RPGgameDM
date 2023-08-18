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

public class Archer extends Hero {
    public Archer(String name) {
        super(name);
        levelAttributes = new HeroAttribute(1, 7, 1);
    }

    @Override
    protected boolean isValidEquipment(Item item) {
        if (item.getRequiredLevel() > level) {
            return false;
        }

        if (item instanceof Weapon) {
            WeaponType weaponType = ((Weapon) item).getWeaponType();
            return weaponType == WeaponType.BOW;
        } else if (item instanceof Armor) {
            ArmorType armorType = ((Armor) item).getArmorType();
            return armorType == ArmorType.LEATHER || armorType == ArmorType.MAIL;
        }

        return false;
    }

    @Override
    public HeroAttribute getLevelUpAttributeGain() {
        return new HeroAttribute(0, 5, 0);
    }

    @Override
    public int getDamage() {
        Weapon equippedWeapon = (Weapon) equipment.get(Slot.WEAPON);
        int weaponDamage = (equippedWeapon != null) ? equippedWeapon.getWeaponDamage() : 1;
        int dexterity = levelAttributes.getDexterity();
        return (int) (weaponDamage * (1 + dexterity / 100.0));
    }
}
