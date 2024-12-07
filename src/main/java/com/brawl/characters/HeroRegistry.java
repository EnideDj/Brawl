package com.brawl.characters;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HeroRegistry {
    private static final List<Hero> heroes = new ArrayList<>();
    private static final Random random = new Random();

    static {
        heroes.add(new Hero("Iron Man", 150, 30, 20, "Inflige des dégâts puissants en un seul coup."));
        heroes.add(new Hero("Captain America", 180, 25, 30, "Absorbe 50% des dégâts reçus pendant 3 tours."));
        heroes.add(new Hero("Spider-Man", 120, 20, 15, "Immobilise l'ennemi pendant un tour."));
        heroes.add(new Hero("Thor", 200, 35, 25, "Double les dégâts pour un tour."));
        heroes.add(new Hero("Black Widow", 130, 25, 20, "Évite toutes les attaques pendant 2 tours."));
    }

    public static Hero getRandomHero() {
        int randomIndex = random.nextInt(heroes.size());
        return heroes.get(randomIndex);
    }

    public static List<Hero> getAllHeroes() {
        return new ArrayList<>(heroes);
    }
}