package com.larryhsiao.oilprice.cpc;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link CPCProducts}.
 */
@Ignore("Skip actual request.")
class CPCCPCProductsTest {
    /**
     * Just check if the endpoint is available.
     */
    @Test
    void fetch() {
        assertNotEquals(
            "",
            new CPCProducts().value()
        );
    }
}