package com.brawl.characters;

/**
 * This interface defines behaviour of fighters of this game
 * Player and enemies are to implement Fighter
 */
public interface Fighter {

    /**
     * The instance takes damages. Acts as a custom setter that caps HPs between 0 and Max hp
     * @param damage Damage to be taken by this
     */
    void takeDamage(int damage);

    /**
     * Returns whether this is alive
     * @return true if alive, false otherwise
     */
    boolean isAlive();

    int getHealthPoints();
    int getAttackPoints();
    int getDefensePoints();

    /**
     * Performs an attack on another instance.
     * @param target the target to be attacked
     */
    void attack(Fighter target);
    void useSpecialAbility();
    String getName();
}