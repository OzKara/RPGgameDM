package no.experis.dungeonmaster.utilities;

import java.util.jar.Attributes;

public class HeroAttribute {
    private int strength;
    private int intelligence;
    private int dexterity;

    public HeroAttribute(int strength,int dexterity, int intelligence) {
        this.strength = strength;
        this.intelligence = intelligence;
        this.dexterity = dexterity;
    }

    public enum AttributeType {
        STRENGTH, INTELLIGENCE, DEXTERITY
    }

    public void addAttributes(HeroAttribute other) {
        this.strength += strength;
        this.dexterity += dexterity;
        this.intelligence += intelligence;
    }

    public void increaseAttribute(AttributeType attributeType, int amount) {
        switch (attributeType) {
            case STRENGTH -> {
                strength += amount;
                break;
            }
            case DEXTERITY -> {
                dexterity += amount;
                break;
            }
            case INTELLIGENCE -> {
                intelligence += amount;
                break;
            }
        }
    }

    public int getStrength() {
        return strength;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getDexterity() {
        return dexterity;
    }

    @Override
    public String toString() {
        return "| strength=" + strength + " | intelligence=" + intelligence + " | dexterity=" + dexterity + " |";
    }
}
