package no.experis.dungeonmaster.items;

import no.experis.dungeonmaster.enums.Slot;
import no.experis.dungeonmaster.enums.WeaponType;

public class Weapon extends Item {
    private final WeaponType weaponType;
    private final int weaponDamage;

    public Weapon(int requiredLevel, WeaponType weaponType, int weaponDamage) {
        super(requiredLevel);
        this.weaponType = weaponType;
        this.weaponDamage = weaponDamage;
    }

    public Slot getSlot() {
        return Slot.WEAPON;
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public int getWeaponDamage() {
        return weaponDamage;
    }
}
