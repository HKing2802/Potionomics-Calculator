package com.company;

import java.util.Dictionary;
import java.util.Hashtable;

/**
 * Class representing a potion recipe with a set ratio of magimins
 * @author HKing
 */
public class Recipe {
    private final String name;
    private final Dictionary<MAGIMIN_TYPE, Integer> ratio;
    private final int basePrice;

    public Recipe(String name, int basePrice) {
        this.name = name;
        this.basePrice = basePrice;
        this.ratio = new Hashtable<>();

        for (MAGIMIN_TYPE type : MAGIMIN_TYPE.values()) {
            this.ratio.put(type, 0);
        }
    }

    public String getName() {
        return name;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public void setRatio(MAGIMIN_TYPE type, int ratio) {
        this.ratio.put(type, ratio);
    }

    public int getRatio(MAGIMIN_TYPE type) {
        return this.ratio.get(type);
    }
}
