package com.brawl.characters;

public abstract class Enemy implements Fighter, SpecialAbility {
    protected String name;
    protected int healthPoints;
    protected int attackPoints;
    protected int defensePoints;
    private boolean alive;
    private String specialAbilityDescription;

    public Enemy(String name, int healthPoints, int attackPoints, int defensePoints, String specialAbilityDescription) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.attackPoints = attackPoints;
        this.defensePoints = defensePoints;
        this.alive = true;
        this.specialAbilityDescription = specialAbilityDescription;
    }

    public String getName() {
        return name;
    }

    @Override
    public void takeDamage(int damage) {
        this.healthPoints -= Math.max(damage, 0);
        if (this.healthPoints <= 0) {
            this.alive = false;
        }
    }

    @Override
    public boolean isAlive() {
        return this.alive;
    }

    @Override
    public void useSpecialAbility() {
        System.out.println(this.name + " utilise sa capacité spéciale : " + specialAbilityDescription);
    }

    @Override
    public String getSpecialAbilityDescription() {
        return specialAbilityDescription;
    }

    @Override
    public void attack(Fighter target) {
        int damage = Math.max(1, this.attackPoints - target.getDefensePoints());
        target.takeDamage(damage);
        System.out.println(this.name + " attaque " + target.getClass().getSimpleName() + " pour " + damage + " points de dégâts.");
    }
}