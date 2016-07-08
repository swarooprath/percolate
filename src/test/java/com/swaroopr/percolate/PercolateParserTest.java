package com.swaroopr.percolate;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * Created by sr on 7/8/16.
 */
public class PercolateParserTest {

    private static final String[] TEST_CASES = new String[] {
//            "Booker T., Washington, 87360, 373 781 7380, yellow",
            "Chandler, Kerri, (623)-668-9293, pink, 123123121"//,
//            "James Murphy, yellow, 83880, 018 154 6474",
//            "asdfawefawea"
    };

    @Test
    public void testOne() throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        new PercolateParser().run(
                stringArray2InputStream(TEST_CASES),
                new PrintStream(baos)
        );
        Assert.assertEquals("{\n" +
                "  \"entries\": [\n" +
                "    {\n" +
                "      \"color\": \"yellow\",\n" +
                "      \"firstname\": \"James\",\n" +
                "      \"lastname\": \"Murphy\",\n" +
                "      \"phonenumber\": \"018-154-474\",\n" +
                "      \"zipcode\": \"83880\"\n" +
                "    }\n" +
                "    {\n" +
                "      \"color\": \"Washington\",\n" +
                "      \"firstname\": \"Booker\",\n" +
                "      \"lastname\": \"T.\",\n" +
                "      \"phonenumber\": \"373-781-380\",\n" +
                "      \"zipcode\": \"87360\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"errors\": [\n" +
                "    1,\n" +
                "    3\n" +
                "  ]\n" +
                "}", byteArrayOutputStream2String(baos).trim());
    }

    @Test
    public void testTwo() throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        new PercolateParser().run(
                stringArray2InputStream(new String[]{}),
                new PrintStream(baos)
        );
        Assert.assertEquals(
                "{\n" +
                "  \"entries\": [\n" +
                "  ]\n" +
                "  \"errors\": [\n" +
                "  ]\n" +
                "}", byteArrayOutputStream2String(baos));
    }

    private static String byteArrayOutputStream2String(ByteArrayOutputStream baos) throws IOException {
        baos.flush();
        baos.close();
        return new String(baos.toByteArray(), StandardCharsets.UTF_8);
    }

    private static InputStream stringArray2InputStream(String[] stringArray) {
        String concatString = String.join("\n", stringArray);
        return new ByteArrayInputStream(concatString.getBytes());
    }
}
