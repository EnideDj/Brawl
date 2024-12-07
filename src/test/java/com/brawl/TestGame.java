package com.brawl;


import com.brawl.characters.Brigand;
import com.brawl.characters.Catcheur;
import com.brawl.characters.Enemy;
import com.brawl.characters.Hero;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestGame {

    @Test
    @DisplayName("When attacking")
    void testGame() {

        // GIVEN
        Hero hero = new Hero("Iron Man", 150, 50, 30, "Inflige des dégâts puissants en un seul coup.");
        Enemy enemy = new Catcheur(50, 40, 30);

        // WHEN
        hero.attack(enemy);
        enemy.attack(hero);

        // THEN
        Assertions.assertEquals(140, hero.getHealthPoints() );
        Assertions.assertTrue(hero.isAlive());
        Assertions.assertEquals(30, enemy.getHealthPoints());
    }


}