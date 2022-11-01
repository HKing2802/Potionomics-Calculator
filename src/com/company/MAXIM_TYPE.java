package com.company;

import java.util.Locale;

public enum MAXIM_TYPE {
    A ("a"),
    B ("b"),
    C ("c"),
    D ("d"),
    E ("e");

    private final String letter;

    MAXIM_TYPE(String letter) {
        this.letter = letter;
    }

    public String getLetter() {
        return letter;
    }

    public static MAXIM_TYPE getType(String letter) {
        String let = letter.toLowerCase(Locale.ROOT);
        for (MAXIM_TYPE type : MAXIM_TYPE.values()) {
            if (type.letter.equals(let)) {
                return type;
            }
        }

        throw new IllegalArgumentException("Letter does not have associated Maxim type (" + letter + ")");
    }
}
