package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CauldronTest {
    @Test
    void constructs() {
        Cauldron cauldron = new Cauldron(6, 140);

        assertEquals(6, cauldron.getIngredientCap());
        assertEquals(140, cauldron.getMaximCap());
    }

    @Test
    void getMaximCount() {
        Cauldron cauldron = new Cauldron(6, 140);
        Ingredient ingredient = new Ingredient("test");
        Ingredient ingredient2 = new Ingredient("test 2");
        ingredient.setMaxim(MAXIM_TYPE.C, 18);
        ingredient2.setMaxim(MAXIM_TYPE.A, 10);
        ingredient2.setMaxim(MAXIM_TYPE.E, 2);

        cauldron.addIngredient(ingredient);
        cauldron.addIngredient(ingredient2);

        assertEquals(30, cauldron.getMaximCount());
    }

    @Test
    void getMaximCountZero() {
        Cauldron cauldron = new Cauldron(6, 140);

        assertEquals(0, cauldron.getMaximCount());
    }

    @Test
    void canAddIngredientTrue() {
        Cauldron cauldron = new Cauldron(6, 140);
        Ingredient ingredient = new Ingredient("test");

        assertTrue(cauldron.canAddIngredient(ingredient));
    }

    @Test
    void canAddIngredientFalseIng() {
        Cauldron cauldron = new Cauldron(1, 140);
        Ingredient ingredient = new Ingredient("test");

        cauldron.addIngredient(ingredient);

        assertFalse(cauldron.canAddIngredient(ingredient));
    }

    @Test
    void canAddIngredientFalseMaxim() {
        Cauldron cauldron = new Cauldron(7, 10);
        Ingredient ingredient = new Ingredient("test");
        ingredient.setMaxim(MAXIM_TYPE.A, 10);

        cauldron.addIngredient(ingredient);

        assertFalse(cauldron.canAddIngredient(ingredient));
    }

    @Test
    void addIngredient() {
        Cauldron cauldron = new Cauldron(6, 140);
        Ingredient ingredient = new Ingredient("test");
        ingredient.setMaxim(MAXIM_TYPE.E, 10);
        ingredient.setMaxim(MAXIM_TYPE.D, 5);

        cauldron.addIngredient(ingredient);

        assertEquals(15, cauldron.getMaximCount());
        assertTrue(cauldron.getIngredients().contains(ingredient));
    }
}