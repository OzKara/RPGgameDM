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

public class SwashbucklerTest {
    private Swashbuckler swashbuckler;

    @BeforeEach
    public void setUp() {
        swashbuckler = new Swashbuckler("Test Swashbuckler");
    }

    @Test
    public void testSwashbucklerEquipValidWeapon() {
        Weapon dagger = new Weapon(1, WeaponType.DAGGER, 10, "Test Dagger");
        swashbuckler.equip(dagger);
        assertEquals(dagger, swashbuckler.getEquipment().get(Slot.WEAPON));
    }

    @Test
    public void testSwashbucklerEquipValidWeaponTypeSword() {
        Weapon sword = new Weapon(1, WeaponType.SWORD, 10, "Test Sword");
        swashbuckler.equip(sword);
        assertEquals(sword, swashbuckler.getEquipment().get(Slot.WEAPON));
    }

    @Test
    public void testSwashbucklerEquipInvalidWeaponType() {
        Weapon invalidWeapon = new Weapon(1, WeaponType.MACE, 10, "Test Mace");
        assertThrows(InvalidEquipmentException.class, () -> swashbuckler.equip(invalidWeapon));
    }

    @Test
    public void testSwashbucklerEquipValidArmorType() {
        Armor leatherArmor = new Armor("Leather Armor", 1, Slot.BODY, ArmorType.LEATHER,
                new HeroAttribute(1, 0, 0));
        swashbuckler.equip(leatherArmor);
        assertEquals(leatherArmor, swashbuckler.getEquipment().get(Slot.BODY));
    }

    @Test
    public void testSwashbucklerEquipInvalidArmorType() {
        Armor plateArmor = new Armor("Plate Armor", 1, Slot.BODY, ArmorType.PLATE,
                new HeroAttribute(1, 0, 0));
        assertThrows(InvalidEquipmentException.class, () -> swashbuckler.equip(plateArmor));
    }

    @Test
    public void testSwashbucklerLevelUp() {
        swashbuckler.levelUp();
        assertEquals(2, swashbuckler.getLevel());
        HeroAttribute expectedAttributes = new HeroAttribute(0, 5, 0);
        assertEquals(expectedAttributes, swashbuckler.getTotalAttributes());
    }

    @Test
    public void testSwashbucklerCalculateDamageNoWeapon() {

        assertEquals(1, swashbuckler.calculateDamage());
    }

    @Test
    public void testSwashbucklerCalculateDamageWithWeapon() {
        Weapon sword = new Weapon(1, WeaponType.SWORD, 10, "Test Sword");
        swashbuckler.equip(sword);
        double expectedDamage = 10 * (1 + (5 / 100.0));
        assertEquals(expectedDamage, swashbuckler.calculateDamage());
    }

    @Test
    public void testSwashbucklerCalculateDamageWithArmor() {
        Armor leatherArmor = new Armor("Leather Armor", 1, Slot.BODY, ArmorType.LEATHER,
                new HeroAttribute(0, 1, 0));
        swashbuckler.equip(leatherArmor);
        double expectedDamage = 1 * (1 + (5 / 100.0));
        assertEquals(expectedDamage, swashbuckler.calculateDamage());
    }
}