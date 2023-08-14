package no.experis.dungeonmaster.characters;

import no.experis.dungeonmaster.utilities.HeroAttribute;

public class Swashbuckler extends Hero {
    public static final HeroAttribute startingAttributes = new HeroAttribute(2,6, 1);

    public Swashbuckler(String name, HeroAttribute startingAttributes) {
        super(name, startingAttributes);
    }
}


