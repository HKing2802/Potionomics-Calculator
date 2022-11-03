package com.company;

/**
 * Enum representing the possible effects of attributes that come with ingredients.
 * Positive - 5% price increase
 * Negative - 5% price decrease
 * Random - if both overlap from ingredients, one is selected at random. This is a flag, no randomization is implemented
 *
 * @author HKing
 */
public enum ATTRIBUTE_EFFECT {
    POSITIVE (0.05),
    NEGATIVE (-0.05),
    RANDOM (0.00);

    private final double modifier;

    ATTRIBUTE_EFFECT(double modifier) {
        this.modifier = modifier;
    }

    public double getModifier() {
        return this.modifier;
    }

    public static ATTRIBUTE_EFFECT getOpposite(ATTRIBUTE_EFFECT effect) {
        switch (effect) {
            case POSITIVE -> {
                return NEGATIVE;
            }
            case NEGATIVE -> {
                return POSITIVE;
            }
            default -> {
                return null;
            }
        }
    }
}
