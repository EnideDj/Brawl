package com.brawl.characters;

import lombok.Getter;

public enum Special {

    IRON_MAN_SPECIAL("Elimine tous les ennemis présents."),
    CAPTAIN_AMERICA_SPECIAL("Absorbe 50% des dégâts reçus pendant 3 tours."),
    SPIDER_MAN_SPECIAL("Immobilise les ennemis pendant un tour."),
    THOR_SPECIAL("Double tous les dégâts infligés pendant un tour."),
    BLACK_WIDOW_SPECIAL("Évite toutes les attaques pendant 2 tours.");

    @Getter
    private String description;

    Special(String description) {
        this.description = description;
    }




}
