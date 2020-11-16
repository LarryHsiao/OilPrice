package com.larryhsiao.oilprice.cpc;

import com.larryhsiao.clotho.date.DateCalendar;
import com.larryhsiao.oilprice.Product;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Objects;

public class XMLCPCProduct implements Product {
    private final Node node;

    public XMLCPCProduct(Node node) {
        this.node = node;
    }

    @Override
    public String name() {
        try {
            String result = childNode(node, "產品名稱").getTextContent();
            if (result == null) {
                return "";
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override
    public float price() {
        try {
            return Float.parseFloat(childNode(node, "參考牌價").getTextContent());
        } catch (Exception e) {
            e.printStackTrace();
            return 0f;
        }
    }

    @Override
    public Calendar priceApplyDate() {
        try {
            return new DateCalendar(
                Objects.requireNonNull(
                    new SimpleDateFormat(
                        "yyyyMMdd",
                        Locale.getDefault()
                    ).parse(childNode(node, "牌價生效時間").getTextContent())
                ).getTime(),
                Calendar.getInstance()
            ).value();
        } catch (Exception e) {
            e.printStackTrace();
            return Calendar.getInstance();
        }
    }

    private Node childNode(Node node, String name) {
        NodeList children = node.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            Node child = children.item(i);
            if (name.equals(child.getNodeName())) {
                return child;
            }
        }
        throw new RuntimeException("Node not available");
    }
}
