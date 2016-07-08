package com.swaroopr.percolate.parser;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;

/**
 * Takes a list of parser and tries them 1 by 1 on the original input.
 * Returns null if all of them fail to parse the input.
 * Created by sr on 7/7/16.
 */
public class OrParsers<T> implements IParser<T>{

    private final List<IParser<T>> parserList;

    public OrParsers(List<IParser<T>> parserList) {
        this.parserList = parserList;
    }

    public T parse(StringReader s) throws IOException {
        String string = reader2String(s);
        for (IParser<T> p : parserList) {
            T result = p.parse(new StringReader(string));
            if (null != result) {
                return result;
            }
        }
        return null;
    }

    public String reader2String(StringReader stringReader) throws IOException {
        stringReader.reset();
        StringBuilder result = new StringBuilder();
        int val = stringReader.read();
        while (-1 != val) {
            result.append((char) val);
            val = stringReader.read();
        }
        return result.toString();
    }
}
