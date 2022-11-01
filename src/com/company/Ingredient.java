package com.company;

import java.util.Dictionary;
import java.util.Hashtable;

public class Ingredient {
    private static final int ATTRIBUTE_SLOTS = 5;

    private final String name;
    private final Dictionary<MAXIM_TYPE, Integer> maxims;
    private final ATTRIBUTE_EFFECT[] attributes;

    public Ingredient(String name) {
        this.name = name;
        this.maxims = new Hashtable<>(MAXIM_TYPE.values().length);
        this.attributes = new ATTRIBUTE_EFFECT[ATTRIBUTE_SLOTS];

        for (MAXIM_TYPE type : MAXIM_TYPE.values()) {
            this.maxims.put(type, 0);
        }
    }

    public String getName() {
        return this.name;
    }

    public void setMaxim(MAXIM_TYPE type, int value) {
        this.maxims.put(type, value);
    }

    public int getMaximAmount(MAXIM_TYPE type) {
        return this.maxims.get(type);
    }

    public ATTRIBUTE_EFFECT[] getAttributes() {
        return this.attributes;
    }

    public int getMaximCount() {
        int count = 0;

        for (MAXIM_TYPE type : MAXIM_TYPE.values()) {
            count += this.maxims.get(type);
        }

        return count;
    }

    public void addAttribute(int pos, ATTRIBUTE_EFFECT effect) {
        if (pos < 0 || pos >= this.attributes.length) {
            throw new IndexOutOfBoundsException("Position out of bounds (" + pos + ")");
        }

        if (this.attributes[pos] != null) {
            if (this.attributes[pos] != effect) {
                this.attributes[pos] = ATTRIBUTE_EFFECT.RANDOM;
            }
        } else {
            this.attributes[pos] = effect;
        }
    }

    public double getAttrModifier() {
        double mod = 0;
        for (ATTRIBUTE_EFFECT effect : this.attributes) {
            if (effect == null) {
                mod +=1;
            } else {
                mod += effect.getModifier();
            }
        }

        return mod/this.attributes.length;
    }
}
