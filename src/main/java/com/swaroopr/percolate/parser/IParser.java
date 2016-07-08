package com.swaroopr.percolate.parser;

import java.io.IOException;
import java.io.StringReader;

/**
 * Interface for parser classes
 * Created by sr on 7/8/16.
 */
public interface IParser<T> {

    T parse(StringReader s) throws IOException;

    static String read2Delimter(StringReader s, int delimiter) throws IOException {
        int val = s.read();
        StringBuilder sb = new StringBuilder();
        while (val != -1 && val != delimiter) {
            char ch = (char) val;
            sb.append(ch);
            val = s.read();
        }
        return sb.toString();
    }
}
