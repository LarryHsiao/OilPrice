package com.larryhsiao.oilprice;

import java.util.Calendar;

/**
 * The product of oil.
 */
public interface Product {
    /**
     * The product name.
     */
    String name();

    /**
     * The product price.
     */
    float price();

    /**
     * The date that price applied.
     */
    Calendar priceApplyDate();
}
