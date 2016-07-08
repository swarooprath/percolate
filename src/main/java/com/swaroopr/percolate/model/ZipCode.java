package com.swaroopr.percolate.model;

/**
 * Represents a zipcode
 * Created by sr on 7/5/16.
 */
public class ZipCode {

    private final String zipCode;

    public ZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return zipCode;
    }
}
