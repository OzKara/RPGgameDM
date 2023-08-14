package no.experis.dungeonmaster.characters;

import no.experis.dungeonmaster.utilities.HeroAttribute;

public class Wizard extends Hero{
    private static final HeroAttribute startingAttributes = new HeroAttribute(1,1,8);

    public Wizard(String name, HeroAttribute startingAttributes) {
        super(name, startingAttributes);
    }
}