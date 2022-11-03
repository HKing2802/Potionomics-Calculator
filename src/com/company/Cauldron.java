package com.company;

import java.util.LinkedList;
import java.util.List;

/**
 * Class representing a place to brew a potion, implementing ingredient and magimin caps.
 *
 * @author HKing
 */
public class Cauldron {
    private final int ingredientCap;
    private final int magiminCap;
    private final ATTRIBUTE_EFFECT[] attributes;

    private final List<Ingredient> ingredients;

    /**
     * Constructor
     * @param ingredientCap Capacity for ingredients
     * @param magiminCap Capacity for total number of magimins across all ingredients in the cauldron
     */
    public Cauldron(int ingredientCap, int magiminCap) {
        this.ingredientCap = ingredientCap;
        this.magiminCap = magiminCap;
        this.ingredients = new LinkedList<>();
        this.attributes = new ATTRIBUTE_EFFECT[Ingredient.ATTRIBUTE_SLOTS];
    }

    public int getIngredientCap() {
        return this.ingredientCap;
    }

    public int getMagiminCap() {
        return this.magiminCap;
    }

    public List<Ingredient> getIngredients() {
        return this.ingredients;
    }

    public ATTRIBUTE_EFFECT[] getAttributes() {
        return this.attributes;
    }

    /**
     * Gets the total number of magimins in the ingredients in the cauldron
     * @return number of magimins
     */
    public int getMagiminCount() {
        int count = 0;

        for (Ingredient ingredient : this.ingredients) {
            count += ingredient.getMagiminsCount();
        }

        return count;
    }

    /**
     * Checks if an ingredient can be added to the cauldron
     * @param ingredient The ingredient to check
     * @return boolean if the ingredient can be added
     */
    public boolean canAddIngredient(Ingredient ingredient) {
        return ((ingredient.getMagiminsCount() + this.getMagiminCount()) <= this.magiminCap) && this.ingredients.size() < this.ingredientCap;
    }

    /**
     * Adds an ingredient to the cauldron
     * @param ingredient The ingredient to check
     * @throws IllegalArgumentException if ingredient can't fit
     */
    public void addIngredient(Ingredient ingredient) {
        if (!this.canAddIngredient(ingredient)) {
            throw new IllegalArgumentException("Ingredient cannot fit in Cauldron.");
        }
        this.ingredients.add(ingredient);

        ATTRIBUTE_EFFECT[] newAttributes = ingredient.getAttributes();
        for (int i = 0; i < this.attributes.length; i++) {
            if (newAttributes[i] != null && this.attributes[i] != ATTRIBUTE_EFFECT.RANDOM) {
                if (this.attributes[i] == null) {
                    this.attributes[i] = newAttributes[i];
                } else if (ATTRIBUTE_EFFECT.getOpposite(this.attributes[i]) == newAttributes[i]) {
                    this.attributes[i] = ATTRIBUTE_EFFECT.RANDOM;
                }
            }
        }
    }

    /**
     * Gets a decimal modifier for the price based on the attributes provided by ingredients
     * Random attributes do not apply to this modifier, and must be accounted for separately.
     * @return decimal modifier for price
     */
    public double getAttrModifier() {
        double mod = 1;

        for (ATTRIBUTE_EFFECT effect : this.attributes) {
            if (effect != null) {
                mod += effect.getModifier();
            }
        }

        return Math.round(mod * 100.0) / 100.0;
    }

    /**
     * Gets the number of attributes that are random
     * @return number of random effect attributes
     */
    public int getNumRandomEffect() {
        int count = 0;

        for (ATTRIBUTE_EFFECT effect : this.attributes) {
            if (effect == ATTRIBUTE_EFFECT.RANDOM) {
                count++;
            }
        }

        return count;
    }
}
