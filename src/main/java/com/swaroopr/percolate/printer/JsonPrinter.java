package com.swaroopr.percolate.printer;

import com.swaroopr.percolate.model.JsonMap;

import java.io.PrintStream;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * This class prints lists and maps of objects to Json.
 * This is by no means a general purpose Json printer and is very specific to the given problem.
 * Example: This cannot handle cases where the value Object in the {@link JsonMap} is an instance of {@link Collection}
 * or {@link JsonMap}.
 * Created by sr on 7/7/16.
 */
public class JsonPrinter  {

    private void printObject(PrintStream printStream, String prefix, LinkedHashMap<String, Object> map) {
        printStream.println(prefix + "{");
        String newPrefix = prefix + "  ";
        int index = -1;
        for (String k : map.keySet()) {
            index++;
            Object value = map.get(k);
            printStream.print(new StringBuilder(newPrefix).append("\"").append(k).append("\": "));
            if (value instanceof Collection) {
                printArray(printStream, newPrefix, (List) value);
            } else {
                printStream.print(new StringBuilder("\"").append(value.toString()).append("\""));
            }
            if (index != map.keySet().size()-1) {
                printStream.println(",");
            } else {
                printStream.println();
            }
        }
        printStream.print(prefix + "}");
    }

    public void printObject(PrintStream printStream, String prefix, JsonMap jsonMap) {
        printObject(printStream, prefix, jsonMap.toJsonMap());
    }

    private void printArray(PrintStream printStream, String prefix, Collection<?> list) {
        // start in the same line
        printStream.println("[");
        int index = -1;
        String newPrefix = prefix + "  ";
        for (Object o : list) {
            index++;
            if (o instanceof JsonMap) {
                JsonMap jMap = (JsonMap) o;
                printObject(printStream, newPrefix, jMap);
            } else {
                printStream.print(newPrefix + o.toString());
            }
            if (index != list.size()-1) {
                printStream.println(",");
            } else {
                printStream.println();
            }
        }
        printStream.print(prefix + "]");
    }
}
