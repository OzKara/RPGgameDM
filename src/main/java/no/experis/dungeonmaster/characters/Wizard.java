package no.experis.dungeonmaster.characters;

import no.experis.dungeonmaster.enums.ArmorType;
import no.experis.dungeonmaster.enums.WeaponType;
import no.experis.dungeonmaster.items.Armor;
import no.experis.dungeonmaster.items.Item;
import no.experis.dungeonmaster.items.Weapon;
import no.experis.dungeonmaster.utilities.HeroAttribute;

public class Wizard extends Hero {
    public Wizard(String name) {
        super(name);
        levelAttributes = new HeroAttribute(1, 1, 8);
    }

    @Override
    protected boolean isValidEquipment(Item item) {
        if (item.getRequiredLevel() > level) {
            return false;
        }

        if (item instanceof Weapon) {
            WeaponType weaponType = ((Weapon) item).getWeaponType();
            return weaponType == WeaponType.STAFF || weaponType == WeaponType.WAND;
        } else if (item instanceof Armor) {
            ArmorType armorType = ((Armor) item).getArmorType();
            return armorType == ArmorType.CLOTH;
        }

        return false;
    }

    @Override
    public HeroAttribute getLevelUpAttributeGain() {
        return new HeroAttribute(1, 1, 5);
    }

    @Override
    public double getDamage() {

        return (calculateDamage() * (1.00 + (levelAttributes.getIntelligence() / 100.00)));
    }
}