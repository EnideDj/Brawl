package com.brawl.characters;

import lombok.Getter;

import java.util.ArrayList;

/**
 * Represents the main character of the game.
 * The hero has runtime stats and special ability instantiation {@link HeroRegistry}
 * The hero HPs are capped between 0 and the health stat passed in parameter 1
 * The hero's special ability is to be used only once
 */
public class Hero implements Fighter, SpecialAbility {

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////// ATTRIBUTES        ////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private final int maxHealth;
    private final int attackPoints;
    private final int defensePoints;
    private final Special specialAbility;
    private int healthPoints;

    @Getter
    private final String name;

    @Getter
    private boolean specialAbilityUsed;

    private int nbRoundsSpecialAbility;

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////// CONSTRUCTOR        ///////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public Hero(String name, int healthPoints, int attackPoints, int defensePoints, Special specialAbility) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.maxHealth = healthPoints;
        this.attackPoints = attackPoints;
        this.defensePoints = defensePoints;
        this.specialAbilityUsed = false;
        this.specialAbility = specialAbility;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////// FIGHTER METHODS //////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void takeDamage(int damage) {
        this.healthPoints = Math.max(Math.min(healthPoints - damage, maxHealth), 0);
    }

    @Override
    public boolean isAlive() {
        return this.healthPoints > 0;
    }

    public void attack(Fighter fighter) {
        int damage = attackPoints;

        if ("Iron Man".equals(this.name) && !specialAbilityUsed) {
            useSpecialAbility();
            damage *= 2;
            specialAbilityUsed = true;
        }

        damage = Math.max(0, damage - fighter.getDefensePoints());
        fighter.takeDamage(damage);
        System.out.println(name + " attaque " + fighter.getName() + " et inflige " + damage + " points de dégâts.");

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

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////// SPECIAL ABILITY METHODS ///////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void useSpecialAbility() {
        if (!specialAbilityUsed) {
            System.out.println(this.name + " utilise sa capacité spéciale : " + specialAbility.getDescription());
            specialAbilityUsed = true;
        }
    }

    private void specialAbilityKillAll(ArrayList<Enemy> enemies) {
        enemies.clear();
    }

    @Override
    public String getSpecialAbilityDescription() {
        return specialAbility.getDescription();
    }


}