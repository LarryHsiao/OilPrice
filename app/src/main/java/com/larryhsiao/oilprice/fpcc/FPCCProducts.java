package com.larryhsiao.oilprice.fpcc;

import com.larryhsiao.clotho.Source;
import com.larryhsiao.clotho.stream.StreamString;

import java.net.URL;

/**
 * Source to get raw product data from FPCC.
 */
public class FPCCProducts implements Source<String> {
    private static final String URL_FPCC = "http://www.fpcc.com.tw/tw/price";

    @Override
    public String value() {
        try {
            return new StreamString(
                new URL(URL_FPCC).openConnection().getInputStream()
            ).value();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
