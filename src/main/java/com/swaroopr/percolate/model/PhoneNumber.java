package com.swaroopr.percolate.model;

/**
 * Class for phone number. This stores areaCode, midDigits and last4Digits.
 * The {@link #toString()} method
 * Created by sr on 7/5/16.
 */
public class PhoneNumber {

    private final String areaCode;
    private final String midDigits;
    private final String last4Digits;

    public PhoneNumber(String areaCode, String midDigits, String last4Digits) {
        this.areaCode = areaCode;
        this.midDigits = midDigits;
        this.last4Digits = last4Digits;
    }

    @Override
    public String toString() {
        return areaCode + "-" + midDigits + "-" + last4Digits;
    }
}
