package com.swaroopr.percolate.parser;

import com.swaroopr.percolate.model.Name;

import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;

/**
 * Reads name from an input String.
 * Created by sr on 7/8/16.
 */
public class FirstNameLastNameParser extends Parser<Name>{

    public FirstNameLastNameParser() {
        super(',');
    }

    @Override
    public Name parse(StringReader s) throws IOException {
        String name = read2Delimter(s);
        String[] array = name.split("\\s+");
        String lastName = array[array.length-1];
        String[] firstNameArray = Arrays.copyOfRange(array, 0, array.length-1);
        String firstName = String.join(" ",  Arrays.asList(firstNameArray));
        return new Name(firstName, lastName);
    }
}
