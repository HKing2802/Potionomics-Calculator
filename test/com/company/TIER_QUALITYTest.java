package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TIER_QUALITYTest {

    @Test
    void getTierQuality() {
        TIER_QUALITY quality = TIER_QUALITY.getTierQuality(190);

        assertEquals(TIER_QUALITY.GREATER, quality);
    }

    @Test
    void getTierQualityBoarder() {
        TIER_QUALITY quality = TIER_QUALITY.getTierQuality(290);

        assertEquals(TIER_QUALITY.GRAND, quality);
    }

    @Test
    void getStarCount() {

    }
}