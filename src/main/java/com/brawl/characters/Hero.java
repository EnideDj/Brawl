package com.brawl.characters;

import java.util.Random;

public class Hero implements Fighter, SpecialAbility {
    private String name;
    private int healthPoints;
    private int attackPoints;
    private int defensePoints;
    private boolean specialAbilityUsed;
    private String specialAbilityDescription;

    public Hero(String name, int healthPoints, int attackPoints, int defensePoints, String specialAbilityDescription) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.attackPoints = attackPoints;
        this.defensePoints = defensePoints;
        this.specialAbilityUsed = false;
        this.specialAbilityDescription = specialAbilityDescription;
    }

    public String getName() {
        return name;
    }

    @Override
    public void takeDamage(int damage) {
        this.healthPoints -= damage;
        if (this.healthPoints <= 0) {
            this.healthPoints = 0;
        }
    }

    @Override
    public boolean isAlive() {
        return this.healthPoints > 0;
    }

    @Override
    public int getHealthPoints() {
        return healthPoints;
    }

    @Override
    public int getAttackPoints() {
        return attackPoints;
    }

    @Override
    public int getDefensePoints() {
        return defensePoints;
    }

    @Override
    public void useSpecialAbility() {
        if (!specialAbilityUsed) {
            System.out.println(this.name + " utilise sa capacité spéciale : " + specialAbilityDescription);
            specialAbilityUsed = true;
        }
    }

    @Override
    public String getSpecialAbilityDescription() {
        return specialAbilityDescription;
    }

    public void attack(Fighter fighter) {
        if (fighter instanceof Enemy) {
            Enemy enemy = (Enemy) fighter;
            int damage = attackPoints;

            if ("Iron Man".equals(this.name) && !specialAbilityUsed) {
                System.out.println(this.name + " utilise sa capacité spéciale : " + specialAbilityDescription);
                damage *= 2;
                specialAbilityUsed = true;
            }

            damage = Math.max(0, damage - enemy.getDefensePoints());
            enemy.takeDamage(damage);
            System.out.println(name + " attaque " + enemy.getClass().getSimpleName() + " et inflige " + damage + " points de dégâts.");
        }
    }
}