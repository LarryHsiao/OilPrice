package com.larryhsiao.oilprice.fpcc;

import com.larryhsiao.oilprice.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link HTMLFPCCProducts}
 */
class HTMLFPCCProductsTest {

    /**
     * Check if raw FPCC data parsable.
     */
    @Test
    void isParsable() {
        assertNotEquals(
            0,
            new HTMLFPCCProducts(
                new FPCCProducts()
            ).value().size()
        );
    }

    /**
     * Check product values available
     */
    @Test
    void hasValue() {
        Product product = new HTMLFPCCProducts(new FPCCProducts()).value().get(0);
        assertNotEquals("", product.name());
        assertNotEquals(0, product.price());
        assertNotEquals(0, product.priceApplyDate().getTime().getTime());
    }
}