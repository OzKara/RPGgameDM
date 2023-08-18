package no.experis.dungeonmaster.items;

import no.experis.dungeonmaster.enums.Slot;
import no.experis.dungeonmaster.enums.WeaponType;

public class Weapon extends Item {
    private final WeaponType weaponType; // Type of weapon in WeaponType enum
    private final int weaponDamage;

    public Weapon(int requiredLevel, WeaponType weaponType, int weaponDamage, String name) {
        super(name, requiredLevel, Slot.WEAPON);
        this.weaponType = weaponType;
        this.weaponDamage = weaponDamage;
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public int getWeaponDamage() {
        return weaponDamage;
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "weaponType=" + weaponType +
                ", weaponDamage=" + weaponDamage +
                '}';
    }

    @Override
    public Slot getSlot() {
        return slot;
    }
}
