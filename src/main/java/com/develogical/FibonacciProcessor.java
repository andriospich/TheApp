package com.develogical;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FibonacciProcessor implements IQueryProcessor {

    private final String[] fibonacci;

    public FibonacciProcessor() {
        fibonacci = "0	1	1	2	3	5	8	13	21	34	55	89	144	233	377	610	987".split("\t");
    }
    public boolean matchRequest(String query) {
        return query.toLowerCase().contains("fibonacci");
    }

    public String result(String query) {
        Pattern compile = Pattern.compile(".*? (\\d)+th");
        Matcher matcher = compile.matcher(query);
        if (matcher.find()) {
            int group = Integer.parseInt(matcher.group(1));
            return String.valueOf(fibonacci[group]);
        }
        return "";
    }
}
