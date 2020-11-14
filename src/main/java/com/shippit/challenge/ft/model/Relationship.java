package com.shippit.challenge.ft.model;

/**
 * Relationship enumeration.
 */
public enum Relationship {

    BrotherInLaw,
    Daughter,
    PaternalAunt,
    PaternalUncle,
    MaternalAunt,
    MaternalUncle,
    Siblings,
    SisterInLaw,
    Son;

    /**
     * Builds relationship enumeration from a string (remove "-").
     * @param relationshipStr relationship enumeration as a string (can contain "-")
     * @return relationship enumeration
     */
    public static Relationship from(String relationshipStr) {
        return valueOf(relationshipStr.replaceAll("-", ""));
    }

}
