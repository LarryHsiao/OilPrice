package com.larryhsiao.oilprice.cpc;

import com.larryhsiao.clotho.Source;
import com.larryhsiao.clotho.stream.StreamString;

import java.net.URL;

/**
 * Source to get CPC product.
 */
public class CPCProducts implements Source<String> {
    private static final String CPC_PRICE_URL = "https://vipmember.tmtd.cpc.com.tw/opendata/ListPriceWebService.asmx/getCPCMainProdListPrice_XML";

    @Override
    public String value() {
        try {
            return new StreamString(
                new URL(CPC_PRICE_URL).openConnection().getInputStream()
            ).value();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
