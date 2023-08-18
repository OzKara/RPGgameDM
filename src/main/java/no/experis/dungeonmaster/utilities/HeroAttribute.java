package no.experis.dungeonmaster.utilities;

import java.util.Objects;

public class HeroAttribute {
    private int strength;
    private int intelligence;
    private int dexterity;

    public HeroAttribute(int strength, int dexterity, int intelligence) {
        // Constructor initializes attributes
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    public int getStrength() {

        return strength;
    }

    public int getDexterity() {

        return dexterity;
    }

    public int getIntelligence() {

        return intelligence;
    }

    public void increaseStrength(int amount) {
        // Increases strength by amount
        strength += amount;
    }

    public void increaseDexterity(int amount) {
        // Increases dexterity by amount
        dexterity += amount;
    }

    public void increaseIntelligence(int amount) { // Increases intelligence by amount

        intelligence += amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HeroAttribute that = (HeroAttribute) o;
        return strength == that.strength && intelligence == that.intelligence && dexterity == that.dexterity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(strength, intelligence, dexterity);
    }
}
