package com.brawl.utils;

import com.brawl.characters.Enemy;
import com.brawl.characters.Hero;

import java.util.ArrayList;
import java.util.Random;

public class GameUtils {

    // Define column widths
    public static final int NAME_WIDTH = 10;
    public static final int HP_WIDTH = 6;
    public static final int ATK_WIDTH = 6;
    public static final int DEF_WIDTH = 6;
    public static final int SPE_WIDTH = 60;
    private static final Random RANDOM = new Random();

    public static int randomInt(int min, int max) {
        return RANDOM.nextInt((max - min) + 1) + min;
    }

    public static void printEnemiesStatistics(ArrayList<Enemy> enemies) {

        System.out.println("==================================== STATISTIQUES DES ENNEMIS SUR LE TERRAIN ====================================");
        // Define column widths
        // Print the table header
        System.out.printf("%-" + NAME_WIDTH + "s | %-" + HP_WIDTH + "s | %-" + ATK_WIDTH + "s | %-" + DEF_WIDTH + "s | " + "%-" + SPE_WIDTH + "s %n",
                "Nom", "PVs", "Attaque", "Defense", "Spécial");
        System.out.println("-".repeat(NAME_WIDTH + HP_WIDTH + ATK_WIDTH + DEF_WIDTH + SPE_WIDTH + 6));

        // Print  rows
        for (Enemy enemy : enemies) {
            System.out.printf("%-" + NAME_WIDTH + "s | %-" + HP_WIDTH + "s | %-" + ATK_WIDTH + "s | %-" + DEF_WIDTH + "s | " + "%-" + SPE_WIDTH + "s | %n",
                    enemy.getName(), enemy.getHealthPoints(), enemy.getAttackPoints(), enemy.getDefensePoints(), enemy.getSpecialAbilityDescription());
        }

        System.out.println();
    }

    public static void printHeroStatistics(Hero hero) {
        System.out.println("==================================== STATISTIQUES DU JOUEUR SUR LE TERRAIN ====================================");
        // Define column widths


        // Print the table header
        System.out.printf("%-" + NAME_WIDTH + "s | %-" + HP_WIDTH + "s | %-" + ATK_WIDTH + "s | %-" + DEF_WIDTH + "s | " + "%-" + SPE_WIDTH + "s %n",
                "Nom", "PVs", "Attaque", "Defense", "Spécial");
        System.out.println("-".repeat(NAME_WIDTH + HP_WIDTH + ATK_WIDTH + DEF_WIDTH + SPE_WIDTH + 6));

        // Print the user rows
            System.out.printf("%-" + NAME_WIDTH + "s | %-" + HP_WIDTH + "s | %-" + ATK_WIDTH + "s | %-" + DEF_WIDTH + "s | " + "%-" + SPE_WIDTH + "s | %n",
                    hero.getName(), hero.getHealthPoints(), hero.getAttackPoints(), hero.getDefensePoints(), hero.getSpecialAbilityDescription());

        System.out.println();
    }



    }