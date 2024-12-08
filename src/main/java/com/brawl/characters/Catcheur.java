package com.brawl.characters;

public class Catcheur extends Enemy {

    public Catcheur(String name, int healthPoints, int attackPoints, int defensePoints) {
        super(name, healthPoints, attackPoints, defensePoints, "Clé de bras");
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

}