package com.swaroopr.percolate.parser;

import com.google.common.base.Strings;
import com.swaroopr.percolate.model.ZipCode;

import java.io.IOException;
import java.io.StringReader;

/**
 * parses zipcode
 * Created by sr on 7/6/16.
 */
public class ZipCodeParser extends Parser<ZipCode> {

    public ZipCodeParser() {
        super(',');
    }

    @Override
    public ZipCode parse(StringReader s) throws IOException {
        String str = read2Delimter(s);
        if (Strings.isNullOrEmpty(str)) {
            return null;
        }
        str = str.trim();
        return (str.matches("\\d+") && str.length() == 5) ? new ZipCode(str) : null;
    }
}
