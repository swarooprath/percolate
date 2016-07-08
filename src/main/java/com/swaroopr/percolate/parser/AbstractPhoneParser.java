package com.swaroopr.percolate.parser;

import com.google.common.base.Strings;
import com.swaroopr.percolate.model.PhoneNumber;

import java.io.IOException;
import java.io.StringReader;

/**
 * AbstractPhoneParser
 * Created by sr on 7/8/16.
 */
public class AbstractPhoneParser extends Parser<PhoneNumber> {

    private final String regex;

    public AbstractPhoneParser(String regex) {
        super(',');
        this.regex = regex;
    }

    @Override
    public PhoneNumber parse(StringReader s) throws IOException {
        String phoneString = read2Delimter(s);
        if (Strings.isNullOrEmpty(phoneString)) {
            return null;
        }
        phoneString = phoneString.trim();
        if (!phoneString.matches(regex)) {
            return null;
        }
        StringBuilder phoneDigitBuilder = new StringBuilder();
        for (char ch : phoneString.toCharArray()) {
            if (Character.isDigit(ch)) {
                phoneDigitBuilder.append(ch);
            }
        }
        String phoneDigitsString = phoneDigitBuilder.toString();
        return new PhoneNumber(
                phoneDigitsString.substring(0, 3),
                phoneDigitsString.substring(3, 6),
                phoneDigitsString.substring(7));
    }
}
