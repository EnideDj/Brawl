package com.brawl.characters;

public class Brigand extends Enemy {

    // If it is enabled, will enable hp stealing
    private boolean isSpecialEnabled;

    public Brigand(String name,int healthPoints, int attackPoints, int defensePoints) {
        super(name, healthPoints, attackPoints, defensePoints, "Vole une partie des points de vie de l'ennemi.");
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

    /**
     * If special attack is enabled, will steal defender's HPs
     * @param fighter the target to be attacked
     */
    @Override
    public void attack(Fighter fighter) {
            int damage = Math.max(0, getAttackPoints() - fighter.getDefensePoints());
            fighter.takeDamage(damage);

            int stolenHealth = Math.min(damage / 2, fighter.getHealthPoints());

            System.out.println(getName() + " attaque " + fighter.getName() + " et inflige " + damage + " points de dégâts.");

            if(isSpecialEnabled) {
                System.out.println(getName() + " vole " + stolenHealth + " points de vie à " + fighter.getName() + ".");
                this.healthPoints += stolenHealth;
            }
    }

    /**
     * When used, this enemy will be healed by half of HPs it inflicted to its target
     */
    @Override
    public void useSpecialAbility() {
        this.isSpecialEnabled = true;
        System.out.println(getName() + " active sa capacité spéciale de vol. Jusqu'à sa mort, la moitié des dégâts infligés lui seront rétribués");

    }

}