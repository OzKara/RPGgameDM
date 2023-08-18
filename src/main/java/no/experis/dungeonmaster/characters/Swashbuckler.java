package no.experis.dungeonmaster.characters;

import no.experis.dungeonmaster.enums.ArmorType;
import no.experis.dungeonmaster.enums.WeaponType;
import no.experis.dungeonmaster.items.Armor;
import no.experis.dungeonmaster.items.Item;
import no.experis.dungeonmaster.items.Weapon;
import no.experis.dungeonmaster.utilities.HeroAttribute;

public class Swashbuckler extends Hero {
    public Swashbuckler(String name) {
        super(name);
        levelAttributes = new HeroAttribute(2, 6, 1);
    }

    @Override
    protected boolean isValidEquipment(Item item) {
        if (item.getRequiredLevel() > level) {
            return false;
        }

        if (item instanceof Weapon) {
            WeaponType weaponType = ((Weapon) item).getWeaponType();
            return weaponType == WeaponType.DAGGER || weaponType == WeaponType.SWORD;
        } else if (item instanceof Armor) {
            ArmorType armorType = ((Armor) item).getArmorType();
            return armorType == ArmorType.LEATHER || armorType == ArmorType.MAIL;
        }

        return false;
    }

    @Override
    public HeroAttribute getLevelUpAttributeGain() {

        return new HeroAttribute(1, 4, 1);
    }

    @Override
    public double getDamage() {
        return (calculateDamage() * (1.00 + (double) (levelAttributes.getDexterity() / 100.00)));
    }
}