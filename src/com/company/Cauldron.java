package com.company;

import java.util.LinkedList;
import java.util.List;

public class Cauldron {
    private final int ingredientCap;
    private final int maximCap;
    private final ATTRIBUTE_EFFECT[] attributes;

    private final List<Ingredient> ingredients;

    public Cauldron(int ingredientCap, int maximCap) {
        this.ingredientCap = ingredientCap;
        this.maximCap = maximCap;
        this.ingredients = new LinkedList<>();
        this.attributes = new ATTRIBUTE_EFFECT[Ingredient.ATTRIBUTE_SLOTS];
    }

    public int getIngredientCap() {
        return this.ingredientCap;
    }

    public int getMaximCap() {
        return this.maximCap;
    }

    public List<Ingredient> getIngredients() {
        return this.ingredients;
    }

    public ATTRIBUTE_EFFECT[] getAttributes() {
        return this.attributes;
    }

    public int getMaximCount() {
        int count = 0;

        for (Ingredient ingredient : this.ingredients) {
            count += ingredient.getMagiminsCount();
        }

        return count;
    }

    public boolean canAddIngredient(Ingredient ingredient) {
        return ((ingredient.getMagiminsCount() + this.getMaximCount()) < this.maximCap) && this.ingredients.size() < this.ingredientCap;
    }

    public void addIngredient(Ingredient ingredient) {
        if (this.canAddIngredient(ingredient)) {
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
    }

    public double getAttrModifier() {
        double mod = 1;

        for (ATTRIBUTE_EFFECT effect : this.attributes) {
            if (effect != null) {
                mod += effect.getModifier();
            }
        }

        return Math.round(mod * 100.0) / 100.0;
    }

    public boolean hasRandomEffect() {
        for (ATTRIBUTE_EFFECT effect : this.attributes) {
            if (effect == ATTRIBUTE_EFFECT.RANDOM) {
                return true;
            }
        }

        return false;
    }
}
