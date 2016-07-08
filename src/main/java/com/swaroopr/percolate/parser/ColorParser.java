package com.swaroopr.percolate.parser;

import com.google.common.base.Strings;
import com.swaroopr.percolate.model.Color;

import java.io.IOException;
import java.io.StringReader;

/**
 * Parses and creates color objects
 * Created by sr on 7/6/16.
 */
public class ColorParser extends Parser<Color> {

    public ColorParser() {
        super((int)',');
    }

    @Override
    public Color parse(StringReader s) throws IOException {
        String string = read2Delimter(s);
        if (Strings.isNullOrEmpty(string)) {
            return null;
        }
        string = string.trim();
        return string.matches("\\w+") ? new Color(string) : null;
    }
}
