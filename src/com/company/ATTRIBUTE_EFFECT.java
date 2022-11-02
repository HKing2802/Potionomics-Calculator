package com.company;

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
