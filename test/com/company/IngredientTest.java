package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class IngredientTest {

    @Test
    void setMaxim() {
        Ingredient ingredient = new Ingredient("test");
        ingredient.setMaxim(MAXIM_TYPE.A, 10);

        Assertions.assertEquals(10, ingredient.getMaximAmount(MAXIM_TYPE.A));
    }

    @Test
    void getMaximAmount() {
        Ingredient ingredient = new Ingredient("test");

        Assertions.assertEquals(0, ingredient.getMaximAmount(MAXIM_TYPE.E));
    }

    @Test
    void getMaximCount() {
        Ingredient ingredient = new Ingredient("test");
        int initialCount = ingredient.getMaximCount();

        ingredient.setMaxim(MAXIM_TYPE.A, 10);
        ingredient.setMaxim(MAXIM_TYPE.C, 4);
        ingredient.setMaxim(MAXIM_TYPE.D, 11);

        Assertions.assertEquals(0, initialCount);
        Assertions.assertEquals(25, ingredient.getMaximCount());
    }

    @Test
    void maximLetterConversion() {
        Assertions.assertEquals(MAXIM_TYPE.A, MAXIM_TYPE.getType("A"));
    }

    @Test
    void maximLetterConversionError() {
        try {
            Assertions.assertEquals(MAXIM_TYPE.B, MAXIM_TYPE.getType("f"));
            Assertions.fail("Maxim letter conversion did not throw error for incorrect letter");
        } catch (IllegalArgumentException e) {
            // pass
        }
    }

    @Test
    void addAttribute() {
        Ingredient ingredient = new Ingredient("test");
        ATTRIBUTE_EFFECT[] correctEffects = new ATTRIBUTE_EFFECT[]{null, ATTRIBUTE_EFFECT.POSITIVE, null, null, null};

        ingredient.addAttribute(2, ATTRIBUTE_EFFECT.POSITIVE);

        Assertions.assertArrayEquals(correctEffects, ingredient.getAttributes());

    }

    @Test
    void getAttrModifier() {
    }
}