package com.brawl.characters;

public class Brigand extends Enemy {

    public Brigand(int healthPoints, int attackPoints, int defensePoints) {
        super("Brigand", healthPoints, attackPoints, defensePoints, "Vole une partie des points de vie de l'ennemi.");
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
    public void attack(Fighter fighter) {
        if (fighter instanceof Hero) {
            Hero hero = (Hero) fighter;
            int damage = Math.max(0, getAttackPoints() - hero.getDefensePoints());
            hero.takeDamage(damage);

            int stolenHealth = Math.min(damage / 2, hero.getHealthPoints());
            this.healthPoints += stolenHealth;
            hero.takeDamage(-stolenHealth);

            System.out.println("Le Brigand attaque " + hero.getClass().getSimpleName() + " et inflige " + damage + " points de dégâts.");
            System.out.println("Le Brigand vole " + stolenHealth + " points de vie à " + hero.getClass().getSimpleName() + ".");
        }
    }

    @Override
    public void useSpecialAbility() {
        System.out.println("Le Brigand utilise sa capacité spéciale de vol.");
    }
}