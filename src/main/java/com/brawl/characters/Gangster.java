package com.brawl.characters;

public class Gangster extends Enemy {

    private int rangeDamage;

    public Gangster(int healthPoints, int attackPoints, int defensePoints, int rangeDamage) {
        super("Gangster", healthPoints, attackPoints, defensePoints, "Tir de précision");
        this.rangeDamage = rangeDamage;
    }


    @Override
    public int getHealthPoints() {
        return this.healthPoints;
    }

    @Override
    public int getAttackPoints() {
        return this.attackPoints;
    }

    @Override
    public int getDefensePoints() {
        return this.defensePoints;
    }

    @Override
    public void attack(Fighter opponent) {
        int damage = Math.max(0, rangeDamage - opponent.getDefensePoints());
        opponent.takeDamage(damage);
        System.out.println("Le Gangster attaque " + opponent.getClass().getSimpleName() + " et inflige " + damage + " points de dégâts.");
    }
}