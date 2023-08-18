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
import org.junit.jupiter.api.BeforeEach;


public class ArcherTest {
    private Archer archer;

    @BeforeEach
    public void setUp() {
        archer = new Archer("Test Archer");
    }

    @Test
    public void testArcherCreation() {
        assertEquals("Test Archer", archer.getName());
    }

    @Test
    public void testArcherLevelUp() {
        HeroAttribute attributeGain = archer.getLevelUpAttributeGain();
        assertEquals(5, attributeGain.getDexterity());
    }

    @Test
    public void testArcherEquipValidWeapon() {
        Weapon bow = new Weapon(1, WeaponType.BOW, 10, "Test Bow");
        archer.equip(bow);
    }

    @Test
    public void testArcherEquipInvalidWeapon() {
        Weapon sword = new Weapon(1, WeaponType.SWORD, 10, "Test Sword");
        assertThrows(InvalidEquipmentException.class, () -> archer.equip(sword));
    }

    @Test
    public void testArcherEquipValidArmor() {
        Armor leatherArmor = new Armor("Leather Armor", 1, Slot.BODY, ArmorType.LEATHER, new HeroAttribute(1, 0, 0));
        archer.equip(leatherArmor);
    }

    @Test
    public void testArcherEquipInvalidArmor() {
        Armor plateArmor = new Armor("Plate Armor", 1, Slot.BODY, ArmorType.PLATE, new HeroAttribute(1, 0, 0));
        assertThrows(InvalidEquipmentException.class, () -> archer.equip(plateArmor));
    }

    @Test
    public void testArcherCalculateDamageNoWeapon() {
        assertEquals(1.07, archer.calculateDamage(), 0.01);
    }

    @Test
    public void testArcherCalculateDamageWithValidWeapon() {
        Weapon bow = new Weapon(1, WeaponType.BOW, 10, "Test Bow");
        archer.equip(bow);
    }

    @Test
    public void testArcherCalculateDamageWithValidWeaponAndArmor() {
        Weapon bow = new Weapon(1, WeaponType.BOW, 10, "Test Bow");
        Armor leatherArmor = new Armor("Leather Armor", 1, Slot.BODY, ArmorType.LEATHER, new HeroAttribute(1, 0, 0));
        archer.equip(bow);
        archer.equip(leatherArmor);
    }

    @Test
    public void testArcherDisplay() {
        assertNotNull(archer.display());
    }
}