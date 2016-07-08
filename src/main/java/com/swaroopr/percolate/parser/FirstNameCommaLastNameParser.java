package com.swaroopr.percolate.parser;

import com.swaroopr.percolate.model.Name;

import java.io.IOException;
import java.io.StringReader;

/**
 * Reads Name from an input sentence.
 * Created by sr on 7/8/16.
 */
public class FirstNameCommaLastNameParser implements IParser<Name>{

    @Override
    public Name parse(StringReader s) throws IOException {
        String firstName = IParser.read2Delimter(s, ',');
        String lastName = IParser.read2Delimter(s, ',');
        return new Name(firstName, lastName);
    }
}
