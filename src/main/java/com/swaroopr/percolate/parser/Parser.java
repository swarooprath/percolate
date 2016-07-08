package com.swaroopr.percolate.parser;

import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.io.StringReader;

/**
 * Abstract base class for Parsers.
 * Created by sr on 7/7/16.
 */
public abstract class Parser<T> implements IParser<T>{

    private final int delimiter;

    public Parser(int delimiter) {
        this.delimiter = delimiter;
    }

    public abstract T parse(StringReader s) throws IOException;


    String read2Delimter(StringReader s) throws IOException {
        return IParser.read2Delimter(s, delimiter);
    }
}
