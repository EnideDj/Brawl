package com.brawl;

import com.brawl.characters.Hero;
import com.brawl.characters.HeroRegistry;
import com.brawl.game.Game;
import com.brawl.game.Map;
import com.brawl.game.MapRegistry;

public class Main {
    public static void main(String[] args) {
        System.out.println("Le jeu commence !");
        Hero hero = HeroRegistry.getRandomHero();
        System.out.println("Héros choisi : " + hero.getName());

        Map map = MapRegistry.getRandomMap();
        System.out.println("Carte choisie : " + map.getName());

        Game game = new Game(hero, map);
        game.start();
    }
}