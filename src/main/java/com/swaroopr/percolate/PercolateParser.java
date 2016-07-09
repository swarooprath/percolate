package com.swaroopr.percolate;

import com.google.common.collect.ImmutableList;
import com.swaroopr.percolate.model.JsonMap;
import com.swaroopr.percolate.model.Entity;
import com.swaroopr.percolate.parser.*;
import com.swaroopr.percolate.printer.JsonPrinter;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.StringReader;
import java.util.*;

/**
 * Parses sentence from Standard in and prints Json
 * Created by sr on 6/26/16.
 */
public class PercolateParser {

    private final IParser<Entity> parser;

    public PercolateParser() {
        List<IParser<Entity>> parserList = ImmutableList.of(
                new SentenceParser(ImmutableList.of(
                        new LastNameCommaFirstNameParser(),
                        new PhoneBracketDashParser(),
                        new ColorParser(),
                        new ZipCodeParser()
                )),
                new SentenceParser(ImmutableList.of(
                        new FirstNameLastNameParser(),
                        new ColorParser(),
                        new ZipCodeParser(),
                        new PhoneSpaceParser()
                )),
                new SentenceParser(ImmutableList.of(
                        new FirstNameCommaLastNameParser(),
                        new ZipCodeParser(),
                        new PhoneSpaceParser(),
                        new ColorParser()
                ))
        );
        parser = new OrParsers<>(parserList);
    }


    public void run(InputStream is, PrintStream ps) throws IOException {
        Scanner sc = new Scanner(is);
        List<Integer> invalidLineNumbers = new ArrayList<>();
        List<Entity> entries = new ArrayList<>();
        int index = -1;
        while (sc.hasNext()) {
            index++;
            String line = sc.nextLine();
            Entity entry = parser.parse(new StringReader(line));
            if (null == entry) {
                invalidLineNumbers.add(index);
                continue;
            }
            entries.add(entry);
        }
        Collections.sort(entries, (e1, e2) -> e1.getName().compareTo(e2.getName()));
        new JsonPrinter().printObject(ps, "", new FinalResult(entries, invalidLineNumbers));
    }

  static class FinalResult implements JsonMap {
        private final List<Entity> entries;
        private final List<Integer> errors;

      FinalResult(List<Entity> entries, List<Integer> errors) {
          this.entries = entries;
          this.errors = errors;
      }

      @Override
        public LinkedHashMap<String, Object> toJsonMap() {
            LinkedHashMap<String, Object> map = new LinkedHashMap<>();
            map.put("entries", entries);
            map.put("errors", errors);
            return map;
        }
    }
}
