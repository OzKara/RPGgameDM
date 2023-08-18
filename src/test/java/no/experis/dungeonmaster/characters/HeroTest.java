package no.experis.dungeonmaster.characters;

import no.experis.dungeonmaster.enums.ArmorType;
import no.experis.dungeonmaster.enums.Slot;
import no.experis.dungeonmaster.enums.WeaponType;
import no.experis.dungeonmaster.exceptions.InvalidEquipmentException;
import no.experis.dungeonmaster.items.Armor;
import no.experis.dungeonmaster.items.Weapon;
import no.experis.dungeonmaster.utilities.HeroAttribute;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HeroTest {

    @Test
    public void testHeroInitialization() {
        Hero hero = new Wizard("Nicholas");
        assertEquals("Nicholas", hero.getName());
        assertEquals(1, hero.getLevel());
    }

    @Test
    public void testLevelUp() {
        Hero hero = new Archer("Ozan");
        hero.levelUp();
        assertEquals(2, hero.getLevel());
    }

    @Test
    public void testEquipWeapon() {
        Hero hero = new Swashbuckler("Michal");
        Weapon sword = new Weapon(1, WeaponType.SWORD, 10, "Excalibur");
        assertDoesNotThrow(() -> hero.equip(sword));
    }

    @Test
    public void testEquipInvalidWeapon() {
        Hero hero = new Barbarian("Kara");
        Weapon staff = new Weapon(1, WeaponType.STAFF, 10, "Wizard's Staff");
        assertThrows(InvalidEquipmentException.class, () -> hero.equip(staff));
    }

    @Test
    public void testEquipArmor() {
        Hero hero = new Wizard("Merlin");
        Armor clothArmor = new Armor("Cloth Robe", 1, Slot.BODY, ArmorType.CLOTH, new HeroAttribute(0, 0, 2));
        assertDoesNotThrow(() -> hero.equip(clothArmor));
    }

    @Test
    public void testEquipInvalidArmor() {
        Hero hero = new Archer("Oz");
        Armor plateArmor = new Armor("Steel Plate", 1, Slot.BODY, ArmorType.PLATE, new HeroAttribute(2, 0, 0));
        assertThrows(InvalidEquipmentException.class, () -> hero.equip(plateArmor));
    }

    @Test
    public void testLevelUpAndAttributeGain() {
        Hero hero = new Barbarian("Ola");
        hero.levelUp();
        HeroAttribute expectedAttributes = new HeroAttribute(8, 4, 2); // Level 2 attribute gain for Barbarian which gains 4 str, 2 dex per level
        assertEquals(expectedAttributes, hero.getTotalAttributes());
    }
    @Test
    public void testCalculateDamageWithWeapon() {
        Hero hero = new Archer("Boo");
        Weapon bow = new Weapon(1, WeaponType.BOW, 15, "Longbow");
        hero.equip(bow);
        int expectedDamage = (int) (15 * (1 + hero.getTotalAttributes().getDexterity() / 100.0));
        assertEquals(expectedDamage, hero.getDamage());
    }

    @Test
    public void testCalculateDamageWithoutWeapon() {
        Hero hero = new Wizard("Linux");
        int expectedDamage = (int) (1 * (1 + hero.getTotalAttributes().getIntelligence() / 100.0));
        assertEquals(expectedDamage, hero.getDamage());
    }

}