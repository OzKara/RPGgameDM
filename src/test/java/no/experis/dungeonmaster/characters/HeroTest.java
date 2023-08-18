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
    public void testHeroName() {
        Hero hero = new Wizard("Nicholas");
        assertEquals("Nicholas", hero.getName());
    }
    @Test
    public void testHeroInitialLevel_IsOne() {
        Hero hero = new Wizard("Nicholas");
        assertEquals(1, hero.getLevel());
    }

    @Test
    public void testHeroInitialStrength() {
        Hero hero = new Wizard("Nicholas");
        assertEquals(1, hero.getLevelAttributes().getStrength());
    }

    @Test
    public void testHeroInitialDexterity() {
        Hero hero = new Wizard("Nicholas");
        assertEquals(1, hero.getLevelAttributes().getDexterity());
    }

    @Test
    public void testHeroInitialIntelligence() {
        Hero hero = new Wizard("Nicholas");
        assertEquals(8, hero.getLevelAttributes().getIntelligence());
    }
    @Test
    public void testLevelUpIncreasesLevel() {
        Hero hero = new Wizard("Nicholas");
        hero.levelUp();
        assertEquals(2, hero.getLevel());
    }

    @Test
    public void testEquipWeaponSwashbuckler() {
        Hero hero = new Swashbuckler("Michal");
        Weapon sword = new Weapon(1, WeaponType.SWORD, 10, "Excalibur");
        assertDoesNotThrow(() -> hero.equip(sword));
    }

    @Test
    public void testEquipWeaponWizard() {
        Hero hero = new Wizard("Nicholas");
        Weapon staff = new Weapon(1, WeaponType.STAFF, 5, "Wizard Staff");
        hero.equip(staff);
        assertEquals(staff, hero.getEquipment().get(Slot.WEAPON));
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
    public void testDisplayWizard() {
        Hero hero = new Wizard("Nicholas");
        String expectedDisplay = "Name: Nicholas\n" +
                "Class: Wizard\n" +
                "Level: 1\n" +
                "Total Strength: 1\n" +
                "Total Dexterity: 1\n" +
                "Total Intelligence: 8\n" +
                "Damage: " + hero.getDamage() + "\n";
        assertEquals(expectedDisplay, hero.display());
    }

}