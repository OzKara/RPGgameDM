package no.experis.dungeonmaster.items;

import no.experis.dungeonmaster.enums.WeaponType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeaponTest {
    @Test
    public void testWeaponName() {
        Weapon weapon = new Weapon(1, WeaponType.SWORD, 10, "Iron Sword");
        assertEquals("Iron Sword", weapon.getName());
    }

    @Test
    public void testWeaponRequiredLevel() {
        Weapon weapon = new Weapon(1, WeaponType.SWORD, 10, "Iron Sword");
        assertEquals(1, weapon.getRequiredLevel());
    }
}