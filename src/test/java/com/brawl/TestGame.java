package com.brawl;


import com.brawl.characters.*;
import com.brawl.game.Game;
import com.brawl.game.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        Assertions.assertEquals(0, hero.getHealthPoints() );
        Assertions.assertFalse(hero.isAlive());
        Assertions.assertEquals(30, enemy.getHealthPoints());
    }

    @Test
    @DisplayName("A hero with no life cannot win")
    void testGameOver() {

        Hero hero = new Hero("Moi", 0, 50, 30, Special.IRON_MAN_SPECIAL);
        Map map = new Map("Test", "test", 0,10,1);
        Game game = new Game(hero, map);

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


}