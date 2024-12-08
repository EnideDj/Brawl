package com.brawl.utils;

import com.brawl.characters.Enemy;
import com.brawl.characters.Hero;

import java.util.ArrayList;

/**
 *
 */
public class GameUtils {

    // Define column widths
    public static final int NAME_WIDTH = 10;
    public static final int HP_WIDTH = 6;
    public static final int ATK_WIDTH = 6;
    public static final int DEF_WIDTH = 6;
    public static final int SPE_WIDTH = 60;


    /**
     * Prints a table indicating the current state of given enemies
     * @param enemies enemies
     */
    public static void printEnemiesStatistics(ArrayList<Enemy> enemies) {

        System.out.println("==================================== STATISTIQUES DES ENNEMIS SUR LE TERRAIN ====================================");
        // Print the table header
        System.out.printf("%-" + NAME_WIDTH + "s | %-" + HP_WIDTH + "s | %-" + ATK_WIDTH + "s | %-" + DEF_WIDTH + "s | " + "%-" + SPE_WIDTH + "s %n",
                "Nom", "PVs", "Attaque", "Defense", "Spécial");
        System.out.println("-".repeat(NAME_WIDTH + HP_WIDTH + ATK_WIDTH + DEF_WIDTH + SPE_WIDTH + 6));

        // Print enemies rows
        for (Enemy enemy : enemies) {
            System.out.printf("%-" + NAME_WIDTH + "s | %-" + HP_WIDTH + "s | %-" + ATK_WIDTH + "s | %-" + DEF_WIDTH + "s | " + "%-" + SPE_WIDTH + "s | %n",
                    enemy.getName(), enemy.getHealthPoints(), enemy.getAttackPoints(), enemy.getDefensePoints(), enemy.getSpecialAbilityDescription());
        }

        System.out.println();
    }

    /**
     * Prints a table indicating the current state of our player
     * @param hero player
     */
    public static void printHeroStatistics(Hero hero) {
        System.out.println("==================================== STATISTIQUES DU JOUEUR SUR LE TERRAIN ====================================");

        // Print the table header
        System.out.printf("%-" + NAME_WIDTH + "s | %-" + HP_WIDTH + "s | %-" + ATK_WIDTH + "s | %-" + DEF_WIDTH + "s | " + "%-" + SPE_WIDTH + "s %n",
                "Nom", "PVs", "Attaque", "Defense", "Spécial");
        System.out.println("-".repeat(NAME_WIDTH + HP_WIDTH + ATK_WIDTH + DEF_WIDTH + SPE_WIDTH + 6));

        // Print the user row
            System.out.printf("%-" + NAME_WIDTH + "s | %-" + HP_WIDTH + "s | %-" + ATK_WIDTH + "s | %-" + DEF_WIDTH + "s | " + "%-" + SPE_WIDTH + "s | %n",
                    hero.getName(), hero.getHealthPoints(), hero.getAttackPoints(), hero.getDefensePoints(), hero.getSpecialAbilityDescription());

        System.out.println();
    }



    }