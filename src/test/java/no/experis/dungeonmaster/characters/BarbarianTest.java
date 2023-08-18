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
public class BarbarianTest {
    private Barbarian barbarian;

    @BeforeEach
    public void setUp() {
        barbarian = new Barbarian("Test Barbarian");
    }

    @Test
    public void testBarbarianCreation() {
        assertEquals("Test Barbarian", barbarian.getName());
    }

    @Test
    public void testBarbarianLevelUp() {
        HeroAttribute attributeGain = barbarian.getLevelUpAttributeGain();
        assertEquals(1, attributeGain.getStrength());
    }

    @Test
    public void testBarbarianEquipValidWeapon() {
        Weapon sword = new Weapon(1, WeaponType.SWORD, 10, "Test Sword");
        barbarian.equip(sword);
    }

    @Test
    public void testBarbarianEquipInvalidWeapon() {
        Weapon staff = new Weapon(1, WeaponType.STAFF, 10, "Test Staff");
        assertThrows(InvalidEquipmentException.class, () -> barbarian.equip(staff));
    }

    @Test
    public void testBarbarianEquipValidArmor() {
        Armor plateArmor = new Armor("Plate Armor", 1, Slot.BODY, ArmorType.PLATE, new HeroAttribute(1, 0, 0));
        barbarian.equip(plateArmor);
    }

    @Test
    public void testBarbarianEquipInvalidArmor() {
        Armor clothArmor = new Armor("Cloth Armor", 1, Slot.BODY, ArmorType.CLOTH, new HeroAttribute(1, 0, 0));
        assertThrows(InvalidEquipmentException.class, () -> barbarian.equip(clothArmor));
    }

    @Test
    public void testBarbarianCalculateDamageNoWeapon() {
        assertEquals(1.06, barbarian.calculateDamage(), 0.01);
    }

    @Test
    public void testBarbarianCalculateDamageWithValidWeapon() {
        Weapon sword = new Weapon(1, WeaponType.SWORD, 10, "Test Sword");
        barbarian.equip(sword);
    }

    @Test
    public void testBarbarianCalculateDamageWithValidWeaponAndArmor() {
        Weapon sword = new Weapon(1, WeaponType.SWORD, 10, "Test Sword");
        Armor plateArmor = new Armor("Plate Armor", 1, Slot.BODY, ArmorType.PLATE, new HeroAttribute(1, 0, 0));
        barbarian.equip(sword);
        barbarian.equip(plateArmor);
    }

    @Test
    public void testBarbarianDisplay() {
        assertNotNull(barbarian.display());
    }
}