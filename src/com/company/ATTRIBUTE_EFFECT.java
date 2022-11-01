package com.company;

public enum ATTRIBUTE_EFFECT {
    POSITIVE (1.05),
    NEGATIVE (0.95),
    RANDOM (1.00);

    private final double modifier;

    ATTRIBUTE_EFFECT(double modifier) {
        this.modifier = modifier;
    }

    public double getModifier() {
        return this.modifier;
    }
}
