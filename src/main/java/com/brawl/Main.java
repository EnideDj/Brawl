package com.brawl;

import com.brawl.characters.Hero;
import com.brawl.characters.HeroRegistry;
import com.brawl.game.Game;
import com.brawl.game.Map;
import com.brawl.game.MapRegistry;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Enide Djender - Arnaud Endignous - Brawl");
        System.out.println("///////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
        System.out.println("//////////////////////////////////////////////DEBUT DU JEU/////////////////////////////////////////////////////////");
        System.out.println("///////////////////////////////////////////////////////////////////////////////////////////////////////////////////");

        Scanner sc = new Scanner(System.in);

        System.out.println("Choisis ton héros :");
        System.out.println("(0) - Iron man");
        System.out.println("(1) - Captain America");
        System.out.println("(2) - Spider Man");
        System.out.println("(3) - Thor");
        System.out.println("(4) - Black Widow");

        int line;
        do {
            line = sc.nextInt();
            if(line < 0 || line > 4) {
                System.out.println("Erreur : choisis un nombre entre 0 et 4");
            }
        } while (line < 0 || line > 4);

        Hero hero = HeroRegistry.getAllHeroes().get(line);

        System.out.println("Héros choisi : " + hero.getName());

        Map map = MapRegistry.getRandomMap();
        System.out.println("Carte choisie : " + map.name());

        Game game = new Game(hero, map);
        game.start();
    }
}