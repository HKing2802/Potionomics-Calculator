package com.company;

import java.util.Dictionary;
import java.util.Hashtable;

public class Ingredient {
    private final String name;
    private final Dictionary<MAXIM_TYPE, Integer> maxims;

    public Ingredient(String name) {
        this.name = name;
        this.maxims = new Hashtable<>(MAXIM_TYPE.values().length);

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

    public int getMaximCount() {
        int count = 0;

        for (MAXIM_TYPE type : MAXIM_TYPE.values()) {
            count += this.maxims.get(type);
        }

        return count;
    }
}
