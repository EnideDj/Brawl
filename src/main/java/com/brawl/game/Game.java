package com.brawl.game;

import com.brawl.characters.*;
import com.brawl.utils.GameUtils;
import com.brawl.utils.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    private final Hero hero;
    private final Map map;
    private final Logger logger;
    private final Random random;

    public Game(Hero hero, Map carte) {
        this.hero = hero;
        this.map = carte;
        this.logger = new Logger("src/main/resources/logs/game.log");
        this.random = new Random();
    }

    public boolean start() {
        int position = map.start();

        while (position < map.end() && hero.isAlive()) {
            int moveDistance = random.nextInt(map.length()) + 1;
            position += moveDistance;

            if (position > map.end()) {
                position = map.end();
            }

            logger.log("Le héros avance de " + moveDistance + " pas. Position actuelle : " + position);

            ArrayList<Enemy> enemies = this.map.spawnEnemies(random);

            while (hero.isAlive() && !enemies.isEmpty()) {

                GameUtils.printHeroStatistics(hero);
                GameUtils.printEnemiesStatistics(enemies);


                logger.log("==================================== COMBAT ====================================");

                if (hero.isSpecialAbilityUsed() && random.nextBoolean()) {
                    hero.useSpecialAbility();
                }

                for (Enemy enemy : enemies) {
                    if (random.nextBoolean()) {
                        enemy.useSpecialAbility();
                    }
                }

                // Gangsters attack hero
                List<Enemy> gangsters = enemies.stream().filter(enemy -> enemy instanceof Gangster).toList();
                if (!gangsters.isEmpty()) {
                    attackHero(gangsters,true);
                    if(!hero.isAlive()) {
                        // If dead, go back to main loop
                        continue;
                    }
                }

                // Performs randomly between 1 and 5 attacks on the enemies
                attackEnemies(enemies);

                // Other enemies attack hero
                attackHero(enemies.stream().filter(enemy -> !(enemy instanceof Gangster)).toList(), false);



            }
            if (hero.isAlive() && enemies.isEmpty()) {
                logger.log(String.format("Bien joué ! %s a éliminé tous les ennemis ! Avancons à la case suivante.", hero.getName()));
            } else {
                logger.log("GAME OVER");
            }

        } // hero is dead || game is finished

        System.out.println();
        System.out.println("///////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
        System.out.println("///////////////////////////////////////////////FIN DU JEU//////////////////////////////////////////////////////////");
        System.out.println("///////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
        if(hero.isAlive()) {
            logger.log("Bravo ! Vous avez abattu le glaive de la justice sur vos ennemis ! Vous avez gagné le jeu !");
            return true;
        }
        logger.log("OOPS ! Vous êtes morts !");
        return false;

    }


    private void attackEnemies(ArrayList<Enemy> enemies) {
        // Hero attacks randomly from one to five times
        int nbAttacks = random.nextInt(5) + 1;

        logger.log(String.format("%s se lance et attaque %d fois ses ennemis.", hero.getName(), nbAttacks));

        int i = 0;
        // Attack enemies and stops if there's no one left
        while (i < nbAttacks && !enemies.isEmpty()) {
            // Attacks randomly one enemy
            Enemy target = enemies.get(random.nextInt(enemies.size()));
            hero.attack(target);
            // Removing if dead
            if (!target.isAlive()) {
                enemies.remove(target);
            }
            ++i;
        }

    }

    private void attackHero(List<Enemy> enemies, boolean isFromGangsters) {
        if(isFromGangsters) {
            logger.log(String.format("Attention ! Les gangsters tirent sur %s", hero.getName()));
        }
        enemies.forEach(enemy -> enemy.attack(hero));
    }

}