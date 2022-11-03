package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class IngredientTest {

    @Test
    void setMagimin() {
        Ingredient ingredient = new Ingredient("test");
        ingredient.setMagimin(MAGIMIN_TYPE.A, 10);

        Assertions.assertEquals(10, ingredient.getMagiminAmount(MAGIMIN_TYPE.A));
    }

    @Test
    void getMagiminAmount() {
        Ingredient ingredient = new Ingredient("test");

        Assertions.assertEquals(0, ingredient.getMagiminAmount(MAGIMIN_TYPE.E));
    }

    @Test
    void getMagiminCount() {
        Ingredient ingredient = new Ingredient("test");
        int initialCount = ingredient.getMagiminsCount();

        ingredient.setMagimin(MAGIMIN_TYPE.A, 10);
        ingredient.setMagimin(MAGIMIN_TYPE.C, 4);
        ingredient.setMagimin(MAGIMIN_TYPE.D, 11);

        Assertions.assertEquals(0, initialCount);
        Assertions.assertEquals(25, ingredient.getMagiminsCount());
    }

    @Test
    void magiminLetterConversion() {
        Assertions.assertEquals(MAGIMIN_TYPE.A, MAGIMIN_TYPE.getType("A"));
    }

    @Test
    void magiminLetterConversionError() {
        try {
            Assertions.assertEquals(MAGIMIN_TYPE.B, MAGIMIN_TYPE.getType("f"));
            Assertions.fail("Maxim letter conversion did not throw error for incorrect letter");
        } catch (IllegalArgumentException e) {
            // pass
        }
    }

    @Test
    void setAttribute() {
        Ingredient ingredient = new Ingredient("test");
        ATTRIBUTE_EFFECT[] correctEffects = new ATTRIBUTE_EFFECT[]{null, ATTRIBUTE_EFFECT.POSITIVE, null, null, null};

        ingredient.setAttribute(1, ATTRIBUTE_EFFECT.POSITIVE);

        Assertions.assertArrayEquals(correctEffects, ingredient.getAttributes());
    }

    @Test
    void setAttributeRandom() {
        Ingredient ingredient = new Ingredient("test");

        try {
            ingredient.setAttribute(1, ATTRIBUTE_EFFECT.RANDOM);
            Assertions.fail("setAttribute should throw error if attribute effect is set to Random");
        } catch (IllegalArgumentException e) {
            // pass
        }
    }

    @Test
    void setAttributeBounds() {
        Ingredient ingredient = new Ingredient("test");

        try {
            ingredient.setAttribute(-1, ATTRIBUTE_EFFECT.POSITIVE);
        } catch (IndexOutOfBoundsException e) {
            // pass
        }
    }
}