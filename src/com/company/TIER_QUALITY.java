package com.company;

public enum TIER_QUALITY {
    MINOR(new int[]{0, 10, 20, 30, 40, 50}),
    COMMON(new int[]{60, 75, 90, 105, 115, 130}),
    GREATER(new int[]{150, 170, 195, 215, 235, 260}),
    GRAND(new int[]{290, 315, 345, 370, 400, 430}),
    SUPERIOR(new int[]{470, 505, 545, 580, 620, 660}),
    MASTERWORK(new int[]{720, 800, 875, 960, 1040, 1125});

    private final int[] starThresholds;

    TIER_QUALITY(int[] starThresholds) {
        this.starThresholds = starThresholds;
    }

    public int[] getThresholds() {
        return this.starThresholds;
    }

    public static TIER_QUALITY getTierQuality(int magiminCount) {
        TIER_QUALITY tier = TIER_QUALITY.COMMON;
        for (TIER_QUALITY quality : TIER_QUALITY.values()) {
            if (quality.getThresholds()[0] <= magiminCount) {
                tier = quality;
            } else {
                break;
            }
        }

        return tier;
    }

    public static int getStarCount(int magiminCount) {
        TIER_QUALITY tier = TIER_QUALITY.getTierQuality(magiminCount);
        for (int i = 0; i < tier.getThresholds().length; i++) {
            if (magiminCount > tier.getThresholds()[i]) {
                return i - 1;
            }
        }

        throw new IndexOutOfBoundsException("Found tier does not contain magimin count within thresholds.");
    }
}
