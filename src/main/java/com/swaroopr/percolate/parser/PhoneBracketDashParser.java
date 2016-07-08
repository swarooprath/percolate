package com.swaroopr.percolate.parser;

/**
 * Created by sr on 7/8/16.
 */
public class PhoneBracketDashParser extends AbstractPhoneParser {

    public PhoneBracketDashParser() {
        super("^(\\()\\s*?\\d{3}\\s*(\\))\\s*?-?\\s*\\d{3}\\s*-\\s*\\d{4}\\s*$");
    }
}
