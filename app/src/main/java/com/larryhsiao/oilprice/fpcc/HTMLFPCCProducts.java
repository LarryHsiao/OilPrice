package com.larryhsiao.oilprice.fpcc;

import com.larryhsiao.clotho.Source;
import com.larryhsiao.clotho.date.DateCalendar;
import com.larryhsiao.oilprice.Product;
import com.larryhsiao.oilprice.cpc.XMLCPCProduct;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * Source to build list of {@link Product} from html.
 */
public class HTMLFPCCProducts implements Source<List<Product>> {
    private final Source<String> htmlSource;

    public HTMLFPCCProducts(Source<String> htmlSource) {
        this.htmlSource = htmlSource;
    }

    @Override
    public List<Product> value() {
        try {
            List<Product> products = new ArrayList<>();
            Elements priceBlocks = Jsoup.parse(htmlSource.value())
                .body()
                .select(".price-block");
            for (Element priceBlock : priceBlocks) {
                Calendar appliedDate = new FPCCDate(priceBlock.getElementsByTag("p")
                    .first()
                    .text()
                ).value();
                if ("加盟加油站".equals(priceBlock.getElementsByTag("h3").first().text())) {
                    for (Element product : priceBlock.getElementsByClass("gps")) {
                        products.add(new HTMLFPCCProduct(product,appliedDate));
                    }
                }
            }
            return products;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
