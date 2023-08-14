package no.experis.dungeonmaster.characters;

import no.experis.dungeonmaster.utilities.HeroAttribute;

public class Barbarian extends Hero{
    private static final HeroAttribute startingAttributes = new HeroAttribute(5,2,1);

    public Barbarian(String name, HeroAttribute startingAttributes) {
        super(name, startingAttributes);
    }
}
