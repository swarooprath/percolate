package com.swaroopr.percolate.parser;

/**
 * Parses inpput sentence for phone number.
 * Created by sr on 7/8/16.
 */
public class PhoneSpaceParser extends AbstractPhoneParser {

    public PhoneSpaceParser() {
        super("^\\d{3}\\s+?\\d{3}\\s+\\d{4}$");
    }
}
