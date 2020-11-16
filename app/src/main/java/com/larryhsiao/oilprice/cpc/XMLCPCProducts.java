package com.larryhsiao.oilprice.cpc;

import com.larryhsiao.clotho.Source;
import com.larryhsiao.oilprice.Product;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * Source to build list of {@link Product}.
 */
public class XMLCPCProducts implements Source<List<Product>> {
    private final Source<String> original;

    public XMLCPCProducts(Source<String> original) {
        this.original = original;
    }

    @Override
    public List<Product> value() {
        try {
            List<Product> products = new ArrayList<>();
            NodeList table = DocumentBuilderFactory
                .newInstance()
                .newDocumentBuilder()
                .parse(new ByteArrayInputStream(original.value().getBytes(UTF_8)))
                .getDocumentElement()
                .getElementsByTagName("Table");
            for (int i = 0; i < table.getLength(); i++) {
                products.add(new XMLCPCProduct(table.item(i)));
            }
            return products;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
