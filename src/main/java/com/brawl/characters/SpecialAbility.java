package com.brawl.characters;

/**
 * This interface defines the behaviour of using a special ability
 */
public interface SpecialAbility {
    /**
     * Explains special ability
     * @return Description
     */
    String getSpecialAbilityDescription();

    /**
     * Performs the special ability of the instance
     * Generally it is encouraged to overload parameters to define one or several targets
     */
    void useSpecialAbility();
}