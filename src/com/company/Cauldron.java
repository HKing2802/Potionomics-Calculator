package com.company;

import java.util.LinkedList;
import java.util.List;

public class Cauldron {
    private final int ingredientCap;
    private final int maximCap;

    private final List<Ingredient> ingredients;

    public Cauldron(int ingredientCap, int maximCap) {
        this.ingredientCap = ingredientCap;
        this.maximCap = maximCap;
        this.ingredients = new LinkedList<>();
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

    public int getMaximCount() {
        int count = 0;

        for (Ingredient ingredient : this.ingredients) {
            count += ingredient.getMaximCount();
        }

        return count;
    }

    public boolean canAddIngredient(Ingredient ingredient) {
        return ((ingredient.getMaximCount() + this.getMaximCount()) < this.maximCap) && this.ingredients.size() < this.ingredientCap;
    }

    public void addIngredient(Ingredient ingredient) {
        if (this.canAddIngredient(ingredient)) {
            this.ingredients.add(ingredient);
        }
    }
}
