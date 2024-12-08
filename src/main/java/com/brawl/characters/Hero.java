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
    @Getter
    private final Special specialAbility;
    private int healthPoints;

    @Getter
    private final String name;

    @Getter
    private boolean specialAbilityUsed;

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
        if(!isSpecialAbilityUsed() && specialAbility == Special.BLACK_WIDOW_SPECIAL) {
            useSpecialAbility();
            // Does not take any damage for this turn
            return;
        }
        this.healthPoints = Math.max(Math.min(healthPoints - damage, maxHealth), 0);
    }

    @Override
    public boolean isAlive() {
        return this.healthPoints > 0;
    }

    public void attack(Fighter fighter) {
        int damage = attackPoints;

        // Enables doubling attack for one turn
        if ("Thor".equals(this.name) && !specialAbilityUsed) {
            damage *= 2;
            useSpecialAbility();
        }

        damage = Math.max(0, damage - fighter.getDefensePoints());
        fighter.takeDamage(damage);
        System.out.println(name + " attaque " + fighter.getName() + " et inflige " + damage + " points de dégâts.");

    }

    public void useSpecialAbility(ArrayList<Enemy> fighters) {
        if(this.specialAbility == Special.IRON_MAN_SPECIAL || this.specialAbility == Special.CAPTAIN_AMERICA_SPECIAL) {
            useSpecialAbility();
            fighters.clear();
        }
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

    @Override
    public String getSpecialAbilityDescription() {
        return specialAbility.getDescription();
    }


}