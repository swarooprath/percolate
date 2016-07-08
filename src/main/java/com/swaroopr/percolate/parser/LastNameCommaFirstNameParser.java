package com.swaroopr.percolate.parser;

import com.swaroopr.percolate.model.Name;

import java.io.IOException;
import java.io.StringReader;

/**
 * Created by sr on 7/8/16.
 */
public class LastNameCommaFirstNameParser implements IParser<Name> {
    @Override
    public Name parse(StringReader s) throws IOException {
        String lastName = IParser.read2Delimter(s, ',');
        String firstName = IParser.read2Delimter(s, ',');
        return new Name(firstName, lastName);
    }
}
