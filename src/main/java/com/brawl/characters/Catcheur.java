package com.brawl.characters;

public class Catcheur extends Enemy {

    public Catcheur(int healthPoints, int attackPoints, int defensePoints) {
        super("Catcheur", healthPoints, attackPoints, defensePoints, "Clé de bras");
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
        int damage = Math.max(0, this.attackPoints - opponent.getDefensePoints());
        opponent.takeDamage(damage);
        System.out.println("Le Catcheur attaque " + opponent.getClass().getSimpleName() + " et inflige " + damage + " points de dégâts.");
    }
}