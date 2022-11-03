package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CauldronTest {
    @Test
    void constructs() {
        Cauldron cauldron = new Cauldron(6, 140);

        assertEquals(6, cauldron.getIngredientCap());
        assertEquals(140, cauldron.getMagiminCap());
        assertArrayEquals(new ATTRIBUTE_EFFECT[5], cauldron.getAttributes());
    }

    @Test
    void getMagiminCount() {
        Cauldron cauldron = new Cauldron(6, 140);
        Ingredient ingredient = new Ingredient("test");
        Ingredient ingredient2 = new Ingredient("test 2");
        ingredient.setMagimin(MAGIMIN_TYPE.C, 18);
        ingredient2.setMagimin(MAGIMIN_TYPE.A, 10);
        ingredient2.setMagimin(MAGIMIN_TYPE.E, 2);

        cauldron.addIngredient(ingredient);
        cauldron.addIngredient(ingredient2);

        assertEquals(30, cauldron.getMagiminCount());
    }

    @Test
    void getMagiminCountZero() {
        Cauldron cauldron = new Cauldron(6, 140);

        assertEquals(0, cauldron.getMagiminCount());
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
        ingredient.setMagimin(MAGIMIN_TYPE.A, 10);

        cauldron.addIngredient(ingredient);

        assertFalse(cauldron.canAddIngredient(ingredient));
    }

    @Test
    void addIngredient() {
        Cauldron cauldron = new Cauldron(6, 140);
        Ingredient ingredient = new Ingredient("test");
        ingredient.setMagimin(MAGIMIN_TYPE.E, 10);
        ingredient.setMagimin(MAGIMIN_TYPE.D, 5);

        cauldron.addIngredient(ingredient);

        assertEquals(15, cauldron.getMagiminCount());
        assertTrue(cauldron.getIngredients().contains(ingredient));
    }

    @Test
    void addIngredientFail() {
        Cauldron cauldron = new Cauldron(1, 140);
        Ingredient ingredient = new Ingredient("test");
        cauldron.addIngredient(ingredient);
        Object[] startingIngredientsArr = cauldron.getIngredients().toArray();

        try {
            cauldron.addIngredient(ingredient);
            fail("addIngredient should throw error");
        } catch (IllegalArgumentException e) {
            assertArrayEquals(startingIngredientsArr, cauldron.getIngredients().toArray());
        }
    }

    @Test
    void addIngredientAttributes() {
        Cauldron cauldron = new Cauldron(6, 140);
        Ingredient ingredient = new Ingredient("test");
        ingredient.setAttribute(1, ATTRIBUTE_EFFECT.POSITIVE);
        ATTRIBUTE_EFFECT[] correctAttr = new ATTRIBUTE_EFFECT[]{null, ATTRIBUTE_EFFECT.POSITIVE, null, null, null};

        cauldron.addIngredient(ingredient);

        assertArrayEquals(correctAttr, cauldron.getAttributes());
    }

    @Test
    void addIngredientRandomAttribute() {
        Cauldron cauldron = new Cauldron(6, 140);
        Ingredient ingredient = new Ingredient("test");
        ingredient.setAttribute(1, ATTRIBUTE_EFFECT.POSITIVE);
        Ingredient ingredient2 = new Ingredient("test 2");
        ingredient2.setAttribute(1, ATTRIBUTE_EFFECT.NEGATIVE);
        ATTRIBUTE_EFFECT[] correctAttr = new ATTRIBUTE_EFFECT[]{null, ATTRIBUTE_EFFECT.RANDOM, null, null, null};

        cauldron.addIngredient(ingredient);
        cauldron.addIngredient(ingredient2);

        assertArrayEquals(correctAttr, cauldron.getAttributes());
    }

    @Test
    void getAttrModifier() {
        Cauldron cauldron = new Cauldron(6, 140);
        Ingredient ingredient = new Ingredient("test");
        ingredient.setAttribute(1, ATTRIBUTE_EFFECT.NEGATIVE);
        ingredient.setAttribute(2, ATTRIBUTE_EFFECT.NEGATIVE);
        cauldron.addIngredient(ingredient);

        assertEquals(0.90, cauldron.getAttrModifier());
    }

    @Test
    void getNumRandomEffect() {
        Cauldron cauldron = new Cauldron(6, 140);
        Ingredient ingredient = new Ingredient("test");
        ingredient.setAttribute(1, ATTRIBUTE_EFFECT.POSITIVE);
        Ingredient ingredient2 = new Ingredient("test 2");
        ingredient2.setAttribute(1, ATTRIBUTE_EFFECT.NEGATIVE);

        cauldron.addIngredient(ingredient);

        assertEquals(0, cauldron.getNumRandomEffect());

        cauldron.addIngredient(ingredient2);

        assertEquals(1, cauldron.getNumRandomEffect());
    }
}