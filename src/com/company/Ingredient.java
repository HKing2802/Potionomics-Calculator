package com.company;

import java.util.Dictionary;
import java.util.Hashtable;

/**
 * Class representing an ingredient to be used in a potion recipe
 * Ingredients contain a number of magimins, and optionally can have positive or negative attributes
 * @author HKing
 */
public class Ingredient {
    public static final int ATTRIBUTE_SLOTS = 5;

    private final String name;
    private final Dictionary<MAGIMIN_TYPE, Integer> magimins;
    private final ATTRIBUTE_EFFECT[] attributes;

    /**
     * Constructor
     * @param name Name of the Ingredient
     */
    public Ingredient(String name) {
        this.name = name;
        this.magimins = new Hashtable<>(MAGIMIN_TYPE.values().length);
        this.attributes = new ATTRIBUTE_EFFECT[ATTRIBUTE_SLOTS];

        for (MAGIMIN_TYPE type : MAGIMIN_TYPE.values()) {
            this.magimins.put(type, 0);
        }
    }

    public String getName() {
        return this.name;
    }

    public void setMagimin(MAGIMIN_TYPE type, int value) {
        this.magimins.put(type, value);
    }

    public int getMagiminAmount(MAGIMIN_TYPE type) {
        return this.magimins.get(type);
    }

    public ATTRIBUTE_EFFECT[] getAttributes() {
        return this.attributes;
    }

    /**
     * Gets the total number of magimins
     * @return int count of magimins
     */
    public int getMagiminsCount() {
        int count = 0;

        for (MAGIMIN_TYPE type : MAGIMIN_TYPE.values()) {
            count += this.magimins.get(type);
        }

        return count;
    }

    /**
     * Sets an Attribute slot to a given effect, either Positive or Negative.
     * @param pos position of the attribute (0-4)
     * @param effect The effect of the attribute, either Positive or Negative
     * @throws IllegalArgumentException if attribute is Random
     */
    public void setAttribute(int pos, ATTRIBUTE_EFFECT effect) {
        if (pos < 0 || pos >= this.attributes.length) {
            throw new IndexOutOfBoundsException("Position out of bounds (" + pos + ")");
        }

        if (effect == ATTRIBUTE_EFFECT.RANDOM) {
            throw new IllegalArgumentException("Attribute cannot be random in Ingredient");
        }

        this.attributes[pos] = effect;
    }
}
