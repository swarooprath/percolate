package com.swaroopr.percolate.model;

import java.util.LinkedHashMap;

/**
 * Represents the entity specified in the question.
 * Created by sr on 7/6/16.
 */
public class Entity implements JsonMap {

    private final Name name;
    private final PhoneNumber phoneNumber;
    private final Color color;
    private final ZipCode zipCode;

    public Entity(Name name, PhoneNumber phoneNumber, Color color, ZipCode zipCode) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.color = color;
        this.zipCode = zipCode;
    }

    public Name getName() {
        return name;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public Color getColor() {
        return color;
    }

    public ZipCode getZipCode() {
        return zipCode;
    }

    @Override
    public LinkedHashMap<String, Object> toJsonMap() {
        LinkedHashMap<String, Object> result = new LinkedHashMap<>();
        result.put("color", color.getColor());
        result.put("firstname", name.getFirstName());
        result.put("lastname", name.getLastName());
        result.put("phonenumber", phoneNumber.toString());
        result.put("zipcode", zipCode.toString());
        return result;
    }
}
