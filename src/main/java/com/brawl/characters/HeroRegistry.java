package com.brawl.characters;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HeroRegistry {
    private static final List<Hero> heroes = new ArrayList<>();
    private static final Random random = new Random();

    static {
        heroes.add(new Hero("Iron Man", 150, 30, 20, Special.IRON_MAN_SPECIAL));
        heroes.add(new Hero("Captain America", 180, 25, 30, Special.CAPTAIN_AMERICA_SPECIAL));
        heroes.add(new Hero("Spider-Man", 160, 35, 20, Special.SPIDER_MAN_SPECIAL));
        heroes.add(new Hero("Thor", 200, 35, 25, Special.THOR_SPECIAL));
        heroes.add(new Hero("Black Widow", 150, 30, 20, Special.BLACK_WIDOW_SPECIAL));
    }

    public static Hero getRandomHero() {
        int randomIndex = random.nextInt(heroes.size());
        return heroes.get(randomIndex);
    }

    public static List<Hero> getAllHeroes() {
        return new ArrayList<>(heroes);
    }
}
