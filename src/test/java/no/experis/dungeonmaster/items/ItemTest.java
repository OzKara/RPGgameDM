package no.experis.dungeonmaster.items;

import no.experis.dungeonmaster.enums.WeaponType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {
    @Test
    public void testItemName() {
        Item item = new Weapon(1, WeaponType.SWORD, 10, "Iron Sword");
        assertEquals("Iron Sword", item.getName());
    }

    @Test
    public void testItemRequiredLevel() {
        Item item = new Weapon(1, WeaponType.SWORD, 10, "Iron Sword");
        assertEquals(1, item.getRequiredLevel());
    }
}