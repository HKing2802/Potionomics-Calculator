package com.company;

import java.util.Locale;

/**
 * Enum representing the possible types of magimins, A-E, and their associated letter as a String
 *
 * @author HKing
 */
public enum MAGIMIN_TYPE {
    A ("a"),
    B ("b"),
    C ("c"),
    D ("d"),
    E ("e");

    private final String letter;

    MAGIMIN_TYPE(String letter) {
        this.letter = letter;
    }

    public String getLetter() {
        return letter;
    }

    public static MAGIMIN_TYPE getType(String letter) {
        String let = letter.toLowerCase(Locale.ROOT);
        for (MAGIMIN_TYPE type : MAGIMIN_TYPE.values()) {
            if (type.letter.equals(let)) {
                return type;
            }
        }

        throw new IllegalArgumentException("Letter does not have associated Magimin type (" + letter + ")");
    }
}
