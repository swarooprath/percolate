package com.swaroopr.percolate;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by sr on 7/8/16.
 */
public class PercolateParserMain {

    public static void main(String[] args) throws IOException {
        new PercolateParser().run(System.in, System.out);
    }
}
