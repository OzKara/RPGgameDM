package no.experis.dungeonmaster.characters;

import no.experis.dungeonmaster.utilities.HeroAttribute;

public class Archer extends Hero{
    private static final HeroAttribute startingAttributes = new HeroAttribute(1,7,1);

    public Archer(String name, HeroAttribute startingAttributes) {
        super(name, startingAttributes);
    }
}
