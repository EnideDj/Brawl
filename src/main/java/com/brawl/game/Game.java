package com.brawl.game;

import com.brawl.characters.Hero;
import com.brawl.characters.Enemy;
import com.brawl.characters.Brigand;
import com.brawl.characters.Gangster;
import com.brawl.characters.Catcheur;
import com.brawl.utils.Logger;
import com.brawl.characters.Fighter;
import com.brawl.characters.SpecialAbility;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    private Hero hero;
    private Map map;
    private Logger logger;
    private Random random;

    public Game(Hero hero, Map carte) {
        this.hero = hero;
        this.map = carte;
        this.logger = new Logger("src/main/resources/logs/game.log");
        this.random = new Random();
    }

    private void displayFighterStats(Fighter fighter) {
        System.out.println("Points de vie : " + fighter.getHealthPoints() + " - Points d'attaque : " + fighter.getAttackPoints() + " - Points de défense : " + fighter.getDefensePoints());

        if (fighter instanceof Hero) {
            System.out.println("Capacité spéciale : " + ((Hero) fighter).getSpecialAbilityDescription());
        } else if (fighter instanceof SpecialAbility) {
            System.out.println("Capacité spéciale : " + ((SpecialAbility) fighter).getSpecialAbilityDescription());
        }

        System.out.println();
    }

    public void start() {
        int position = map.getStart();

        while (position < map.getEnd() && hero.isAlive()) {
            int moveDistance = random.nextInt(map.getLength()) + 1;
            position += moveDistance;

            if (position > map.getEnd()) {
                position = map.getEnd();
            }

            logger.log("Le héros avance de " + moveDistance + " pas. Position actuelle : " + position);
            System.out.println("Le héros avance de " + moveDistance + " pas. Position actuelle : " + position);

            Enemy enemy = generateEnemy();
            logger.log("Le héros rencontre un " + enemy.getClass().getSimpleName());
            System.out.println("Le héros rencontre un " + enemy.getClass().getSimpleName());

            System.out.println("Statistiques du héros :");
            displayFighterStats(hero);
            System.out.println("Statistiques de l'ennemi :");
            displayFighterStats(enemy);

            if (random.nextBoolean()) {
                hero.useSpecialAbility();
            }

            if (random.nextBoolean()) {
                enemy.useSpecialAbility();
            }

            while (enemy.isAlive() && hero.isAlive()) {
                hero.attack(enemy);
                if (!enemy.isAlive()) {
                    System.out.println("L'ennemi " + enemy.getClass().getSimpleName() + " a été vaincu.");
                    break;
                } else {
                    System.out.println("PV de l'ennemi après l'attaque du héros : " + enemy.getHealthPoints());
                }

                enemy.attack(hero);
                if (!hero.isAlive()) {
                    System.out.println("Le héros a été vaincu par " + enemy.getClass().getSimpleName() + ".");
                    return;
                } else {
                    System.out.println("PV du héros après l'attaque de l'ennemi : " + hero.getHealthPoints());
                }
            }

            if (!hero.isAlive()) {
                logger.log("Le héros est mort. Défaite.");
                System.out.println("Vous avez perdu !");
                return;
            }

            if (position >= map.getEnd() && hero.isAlive()) {
                logger.log("Le héros atteint la fin de la carte. Victoire !");
                System.out.println("Vous avez gagné !");
                return;
            }
        }
    }
    private Enemy generateEnemy() {
        int enemyType = random.nextInt(3);
        Enemy enemy;
        switch (enemyType) {
            case 0:
                enemy = new Brigand(30, 10, 5);
                break;
            case 1:
                int rangeDamage = random.nextInt(10) + 1;
                enemy = new Gangster(40, 12, 4, rangeDamage);
                break;
            case 2:
                enemy = new Catcheur(50, 15, 7);
                break;
            default:
                throw new IllegalStateException("Type d'ennemi inconnu");
        }
        return enemy;
    }
}