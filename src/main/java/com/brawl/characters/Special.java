package com.brawl.characters;

import lombok.Getter;

/**
 * This registers special attacks for our heroes
 */
@Getter
public enum Special {

    IRON_MAN_SPECIAL("Elimine tous les ennemis présents."),
    CAPTAIN_AMERICA_SPECIAL("Elimine tous les ennemis présents."),
    SPIDER_MAN_SPECIAL("Immobilise les ennemis pendant un tour."),
    THOR_SPECIAL("Double tous les dégâts infligés pendant un tour."),
    BLACK_WIDOW_SPECIAL("Évite toutes les attaques pendant un tour.");

    private final String description;

    Special(String description) {
        this.description = description;
    }

}
