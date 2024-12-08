package com.brawl.characters;

public class Gangster extends Enemy {

    private final int rangeDamage;

    public Gangster(String name, int healthPoints, int attackPoints, int defensePoints, int rangeDamage) {
        super(name, healthPoints, attackPoints, defensePoints, "Tir de précision");
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
        int damage = Math.max(0, (attackPoints + rangeDamage) - opponent.getDefensePoints());
        opponent.takeDamage(damage);
        System.out.println(getName() + " attaque " + opponent.getName() + " et inflige " + damage + " points de dégâts.");
    }

}