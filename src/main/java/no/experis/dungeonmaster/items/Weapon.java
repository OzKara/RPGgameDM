package no.experis.dungeonmaster.items;

public class Weapon extends Item {

    private WeaponType weaponType;
    private int weaponDamage;

    public Weapon(String name, int requiredLevel, WeaponType weaponType, int weaponDamage) {
        super(name, requiredLevel, Slot.WEAPON);
        this.weaponType = weaponType;
        this.weaponDamage = weaponDamage;
    }

}
