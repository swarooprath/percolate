package com.swaroopr.percolate.parser;

import com.swaroopr.percolate.model.*;

import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Parses a sentence / line. This can be configured with a list of parsers.
 * Created by sr on 7/6/16.
 */
public class SentenceParser extends Parser<Entity>{

    private final List<IParser> parserList;

    public SentenceParser(List<IParser> parserList) {
        super(-1);
        this.parserList = parserList;
    }

    public Entity parse(StringReader s) throws IOException {
        Map<Class, Object> objectMap = new HashMap<>();
        for (IParser p : parserList) {
            Object result = p.parse(s);
            if (null == result) {
                return null; // we do not support case where the entity is null
            }
            objectMap.put(result.getClass(), result);
        }
        return new Entity(
                (Name) objectMap.get(Name.class),
                (PhoneNumber) objectMap.get(PhoneNumber.class),
                (Color) objectMap.get(Color.class),
                (ZipCode) objectMap.get(ZipCode.class)
        );
    }
}
