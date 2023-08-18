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
public class WizardTest {
    private Wizard wizard;

    @BeforeEach
    public void setUp() {
        wizard = new Wizard(
                "Test Wizard");
    }

    @Test
    public void testWizardCreation() {
        assertEquals("Test Wizard", wizard.getName());
    }

    @Test
    public void testWizardLevelUp() {
        HeroAttribute attributeGain = wizard.getLevelUpAttributeGain();
        assertEquals(5, attributeGain.getIntelligence());
    }

    @Test
    public void testWizardEquipValidWeapon() {
        Weapon staff = new Weapon(1, WeaponType.STAFF, 10, "Test Staff");
        wizard.equip(staff);
    }

    @Test
    public void testWizardEquipInvalidWeapon() {
        Weapon sword = new Weapon(1, WeaponType.SWORD, 10, "Test Sword");
        assertThrows(InvalidEquipmentException.class, () -> wizard.equip(sword));
    }

    @Test
    public void testWizardEquipValidArmor() {
        Armor clothArmor = new Armor("Cloth Armor", 1, Slot.BODY, ArmorType.CLOTH, new HeroAttribute(0, 0, 1));
        wizard.equip(clothArmor);
    }

    @Test
    public void testWizardEquipInvalidArmor() {
        Armor plateArmor = new Armor("Plate Armor", 1, Slot.BODY, ArmorType.PLATE, new HeroAttribute(1, 0, 0));
        assertThrows(InvalidEquipmentException.class, () -> wizard.equip(plateArmor));
    }

    @Test
    public void testWizardCalculateDamageNoWeapon() {

        assertEquals(1.08, wizard.calculateDamage(), 0.01);
    }

    @Test
    public void testWizardCalculateDamageWithValidWeapon() {
        Weapon staff = new Weapon(1, WeaponType.STAFF, 10, "Test Staff");
        wizard.equip(staff);
    }

    @Test
    public void testWizardCalculateDamageWithValidWeaponAndArmor() {
        Weapon staff = new Weapon(1, WeaponType.STAFF, 10, "Test Staff");
        Armor clothArmor = new Armor("Cloth Armor", 1, Slot.BODY, ArmorType.CLOTH, new HeroAttribute(0, 0, 1));
        wizard.equip(staff);
        wizard.equip(clothArmor);
    }

    @Test
    public void testWizardDisplay() {
        assertNotNull(wizard.display());
    }
}