package com.larryhsiao.oilprice.fpcc;

import com.larryhsiao.clotho.Source;
import com.larryhsiao.clotho.date.DateCalendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Source to build {@link Calendar} from FPCC date string.
 */
public class FPCCDate implements Source<Calendar> {
    private final String text;

    public FPCCDate(String text) {this.text = text;}

    @Override
    public Calendar value() {
        try {
            SimpleDateFormat format = new SimpleDateFormat(
                "yyyy年MM月dd日 HH:mm:ss",
                Locale.TAIWAN
            );
            Matcher matcher = Pattern.compile("(?<=西元 ).*(?=起)").matcher(text);
            while (matcher.find()) {
                Date date =format.parse(matcher.group());
                if (date!=null){
                    return new DateCalendar(date.getTime(), Calendar.getInstance()).value();
                }
            }
            return Calendar.getInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return Calendar.getInstance();
        }
    }
}
