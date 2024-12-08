package com.brawl.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MapRegistry {
    private static final List<Map> maps = new ArrayList<>();

    static {
        maps.add(new Map("New York", "Ville emblématique, cœur des aventures Marvel", 0, 10, 3));
        maps.add(new Map("Avengers Tower", "QG des Avengers, plein de technologie et de pièges", 0, 15, 6));
        maps.add(new Map("Wakanda", "Terre de Black Panther, un royaume technologiquement avancé", 0, 12, 5));
        maps.add(new Map("Asgard", "Royaume des dieux nordiques, théâtre de grandes batailles", 0, 20, 7));
    }

    public static Map getRandomMap() {
        int randomIndex = new Random().nextInt(maps.size());
        return maps.get(randomIndex);
    }


}