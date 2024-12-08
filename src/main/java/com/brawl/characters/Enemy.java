package com.brawl.characters;

import lombok.Getter;

/**
 *
 */
public abstract class Enemy implements Fighter, SpecialAbility {
    @Getter
    protected String name;
    protected int healthPoints;
    protected int attackPoints;
    protected int defensePoints;
    protected boolean isSpecialUsed = false;
    private final String specialAbilityDescription;

    public Enemy(String name, int healthPoints, int attackPoints, int defensePoints, String specialAbilityDescription) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.attackPoints = attackPoints;
        this.defensePoints = defensePoints;
        this.specialAbilityDescription = specialAbilityDescription;
    }

    @Override
    public void takeDamage(int damage) {
        this.healthPoints -= Math.max(damage, 0);
    }

    @Override
    public boolean isAlive() {
        return this.healthPoints > 0;
    }

    @Override
    public void useSpecialAbility() {
        this.isSpecialUsed = true;
        System.out.println(this.name + " utilise sa capacité spéciale : " + specialAbilityDescription);
    }

    @Override
    public String getSpecialAbilityDescription() {
        return specialAbilityDescription;
    }

    @Override
    public void attack(Fighter target) {
        // Between 1 and damage
        int damage = Math.max(1, this.attackPoints - target.getDefensePoints());
        target.takeDamage(damage);
        System.out.println(this.name + " attaque " + target.getClass().getSimpleName() + " pour " + damage + " points de dégâts.");
    }
}