package com.brawl;

import com.brawl.characters.*;
import com.brawl.game.Game;
import com.brawl.game.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TestGame {

    @Test
    @DisplayName("When attacking, damage taken must be attacker's attack - defender's defense")
    void testAttack() {

        // GIVEN
        Hero hero = new Hero("Moi", 150, 50, 30, Special.IRON_MAN_SPECIAL);
        Enemy enemy = new Catcheur("Catcheur",50, 180, 30);

        // WHEN
        hero.attack(enemy);
        enemy.attack(hero);

        // THEN
        Assertions.assertEquals(0, hero.getHealthPoints());
        Assertions.assertFalse(hero.isAlive());
        Assertions.assertEquals(30, enemy.getHealthPoints());
    }

    @Test
    @DisplayName("A hero with no life cannot win")
    void testGameOver() {

        // GIVEN
        Hero hero = new Hero("Moi", 0, 50, 30, Special.IRON_MAN_SPECIAL);
        Map map = new Map("Test", "test", 0,10,1);
        Game game = new Game(hero, map);

        // THEN
        Assertions.assertFalse(game.start());
    }

    @Test
    @DisplayName("The special attack vol vie from Brigand must heal the enemy")
    void testBrigandVolVie() {

        // GIVEN
        Brigand brigand = new Brigand("Test", 50,40,20);
        Hero hero = new Hero("Moi", 150, 50, 30, Special.IRON_MAN_SPECIAL);

        // WHEN
        brigand.useSpecialAbility();
        brigand.takeDamage(30);
        brigand.attack(hero);

        // THEN
        // The enemy has 20HPs
        // It attacks the hero by 10HPs
        // It gets heals 10HPs
        Assertions.assertEquals(25, brigand.getHealthPoints());
    }

    @Test
    @DisplayName("When Hero Spider Man uses special ability, it should not take any damage")
    void testSpiderManAbility() {

        // GIVEN
        Enemy enemy = new Brigand("Test", 50,40,20);
        Enemy enemy2 = new Brigand("Test", 50,40,20);
        Enemy enemy3 = new Brigand("Test", 50,40,20);
        ArrayList<Enemy> enemies = new ArrayList<>();
        enemies.add(enemy);
        enemies.add(enemy2);
        enemies.add(enemy3);

        Hero hero = new Hero("Spider Man", 150, 50, 30, Special.SPIDER_MAN_SPECIAL);
        hero.useSpecialAbility();

        Map map = new Map("Test", "test", 0,10,1);
        Game game = new Game(hero, map);

        // WHEN
        game.attackHero(enemies, false, true);

        // THEN
        Assertions.assertEquals(150, hero.getHealthPoints());

    }

    @Test
    @DisplayName("When using Iron Man or Captain America special ability, should kill all enemies")
    void testIronManSpecial() {
        // GIVEN
        Enemy enemy = new Brigand("Test", 50,40,20);
        Enemy enemy2 = new Brigand("Test", 50,40,20);
        Enemy enemy3 = new Brigand("Test", 50,40,20);
        ArrayList<Enemy> enemies = new ArrayList<>();
        enemies.add(enemy);
        enemies.add(enemy2);
        enemies.add(enemy3);

        Hero hero = new Hero("Iron Man", 150, 50, 30, Special.IRON_MAN_SPECIAL);
        hero.useSpecialAbility();

        Map map = new Map("Test", "test", 0,10,1);
        // WHEN
        hero.useSpecialAbility(enemies);

        // THEN
        Assertions.assertEquals(0, enemies.stream().filter(Enemy::isAlive).count());
    }


}