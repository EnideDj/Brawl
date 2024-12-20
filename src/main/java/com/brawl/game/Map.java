package com.brawl.game;

import com.brawl.characters.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Random;

public record Map(String name, String location, int start, int end, int length) {
    public static final int MAX_ENNEMI_SPAWN = 4;

    /**
     * Spawn a certain number of foes
     *
     * @param random AN instance of Random
     * @return A random list of foes.
     */
    public ArrayList<Enemy> spawnEnemies(Random random) {
        int spawn = random.nextInt(MAX_ENNEMI_SPAWN) + 1;
        ArrayList<Enemy> ennemies = new ArrayList<>();
        for (int i = 0; i < spawn; i++) {
            ennemies.add(generateEnemy(random, i));
        }
        System.out.printf("[SPAWN] - Oh my God ! %d enemies spawned !%n", spawn);

        return ennemies;
    }

    /**
     * Generates a random enemy
     *
     * @param random Random instance
     * @param index  The index of the enemy on a list of enemies. Used to define name
     * @return A randomly created enemy
     * @throws IllegalStateException In case of error
     */
    private Enemy generateEnemy(Random random, int index) throws IllegalStateException {
        int enemyType = random.nextInt(3);
        return switch (enemyType) {
            case 0 -> new Brigand("Brigand" + index, 30, 40, 10);
            case 1 -> {
                int rangeDamage = random.nextInt(10) + 1;
                yield new Gangster("Gangster" + index, 40, 35, 4, rangeDamage);
            }
            case 2 -> new Catcheur("Catcheur" + index, 50, 45, 7);
            default -> throw new IllegalStateException("Type d'ennemi inconnu");
        };
    }


}