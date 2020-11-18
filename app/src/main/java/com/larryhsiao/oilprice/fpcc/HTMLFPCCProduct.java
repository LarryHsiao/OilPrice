package com.larryhsiao.oilprice.fpcc;

import com.larryhsiao.oilprice.Product;
import org.jsoup.nodes.Element;

import java.util.Calendar;

/**
 * FPCC product from HTML.
 */
public class HTMLFPCCProduct implements Product {
    private final Element root;
    private final Calendar calendar;

    public HTMLFPCCProduct(Element root, Calendar calendar) {
        this.root = root;
        this.calendar = calendar;
    }

    @Override
    public String name() {
        return root.getElementsByTag("p").first().text();
    }

    @Override
    public float price() {
        return Float.parseFloat(
            root.getElementsByTag("h2")
                .first()
                .text()
                .replace("$", "")
        );
    }

    @Override
    public Calendar priceApplyDate() {
        return calendar;
    }
}
