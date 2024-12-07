package com.brawl.characters;

public interface Fighter {
    void takeDamage(int damage);
    boolean isAlive();
    int getHealthPoints();
    int getAttackPoints();
    int getDefensePoints();
    void attack(Fighter target);
    void useSpecialAbility();
}