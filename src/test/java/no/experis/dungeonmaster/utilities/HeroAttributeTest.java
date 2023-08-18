package no.experis.dungeonmaster.utilities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroAttributeTest {
    @Test
    public void testStrengthInitialization() {
        HeroAttribute attr = new HeroAttribute(5, 3, 2);
        assertEquals(5, attr.getStrength());
    }

    @Test
    public void testDexterityInitialization() {
        HeroAttribute attr = new HeroAttribute(5, 3, 2);
        assertEquals(3, attr.getDexterity());
    }

    @Test
    public void testIntelligenceInitialization() {
        HeroAttribute attr = new HeroAttribute(5, 3, 2);
        assertEquals(2, attr.getIntelligence());
    }

    @Test
    public void testIncreaseStrength() {
        HeroAttribute attr = new HeroAttribute(5, 3, 2);
        attr.increaseStrength(3);
        assertEquals(8, attr.getStrength());
    }

    @Test
    public void testIncreaseDexterity() {
        HeroAttribute attr = new HeroAttribute(5, 3, 2);
        attr.increaseDexterity(2);
        assertEquals(5, attr.getDexterity());
    }

    @Test
    public void testIncreaseIntelligence() {
        HeroAttribute attr = new HeroAttribute(5, 3, 2);
        attr.increaseIntelligence(4);
        assertEquals(6, attr.getIntelligence());
    }
}