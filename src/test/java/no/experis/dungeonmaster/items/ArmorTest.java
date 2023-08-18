package no.experis.dungeonmaster.items;

import no.experis.dungeonmaster.enums.ArmorType;
import no.experis.dungeonmaster.enums.Slot;
import no.experis.dungeonmaster.utilities.HeroAttribute;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArmorTest {
    @Test
    public void testArmorName() {
        Armor armor = new Armor("Steel Plate", 1, Slot.BODY, ArmorType.PLATE, new HeroAttribute(1,2,3));
        assertEquals("Steel Plate", armor.getName());
    }

    @Test
    public void testArmorRequiredLevel() {
        Armor armor = new Armor("Steel Plate", 1, Slot.BODY, ArmorType.PLATE, new HeroAttribute(1,2,3));
        assertEquals(1, armor.getRequiredLevel());
    }
}