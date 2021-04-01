package chapter13.bankapp.formatter;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class AmountFormatter implements Formatter<Long> {

    @Override
    public Long parse(String text, Locale locale) throws ParseException {
        String[] str = text.split(" ");
        return Long.parseLong(str[0]);
    }

    @Override
    public String print(Long object, Locale locale) {
        String returnStr = object.toString() + " USD";
        if(locale.getLanguage().equals(new Locale("cn").getLanguage())) {
            returnStr = object.toString() + " CNY";
        }
        return returnStr;
    }
}
