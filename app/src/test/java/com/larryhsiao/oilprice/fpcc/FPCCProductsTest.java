package com.larryhsiao.oilprice.fpcc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link FPCCProducts}.
 */
class FPCCProductsTest {

    /**
     * Check if source available.
     */
    @Test
    void exist() {
        assertEquals(
            "",
            new FPCCProducts().value()
        );
    }
}