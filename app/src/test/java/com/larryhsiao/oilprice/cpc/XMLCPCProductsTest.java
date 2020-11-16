package com.larryhsiao.oilprice.cpc;

import com.larryhsiao.oilprice.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link XMLCPCProductsTest}.
 */
class XMLCPCProductsTest {
    /**
     * The parsed data size should not empty.
     */
    @Test
    void size() {
        assertNotEquals(
            0,
            new XMLCPCProducts(new CPCProducts())
                .value()
                .size()
        );
    }

    /**
     * Check the product names available.
     */
    @Test
    void nameShouldExist() {
        for (Product product : new XMLCPCProducts(new CPCProducts()).value()) {
            assertNotEquals(
                null,
                product.name()
            );
        }
    }

    /**
     * Check the product prices available.
     */
    @Test
    void priceShouldAvailable() {
        assertNotEquals(
            0f,
            new XMLCPCProducts(new CPCProducts())
                .value()
                .get(0)
                .price()
        );
    }

    /**
     * Check the applied date is valid.
     */
    @Test
    void appliedDate() {
        assertNotEquals(
            0f,
            new XMLCPCProducts(new CPCProducts())
                .value()
                .get(0)
                .priceApplyDate().getTimeInMillis()
        );
    }
}