package com.develogical;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QueryProcessor {

    public String process(String query) {
        if (query.toLowerCase().contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        }
        if (query.toLowerCase().contains("what is your name")) {
            return "j2";
        }

        if (query.toLowerCase().contains("plus")) {
            return String.valueOf(sumFromParsedQuery(query));
        }
        return "";
    }

    private int sumFromParsedQuery(String query) {
        Pattern pattern = Pattern.compile("what.+?(?=plus)");
        Matcher matcher = pattern.matcher(query);
        Integer firstNumber = 0;

        if (matcher.find())
        {
            String str = matcher.group(0);
            str = str.replaceAll("\\D+", "");
            firstNumber = Integer.parseInt(str);
        }

        pattern = Pattern.compile("plus(.*)");

        Integer secondNumber = 0;
        matcher = pattern.matcher(query);
        if (matcher.find())
        {
            String str = matcher.group(0);
            str = str.replaceAll("\\D+", "");
            secondNumber = Integer.parseInt(str);
        }

        return firstNumber + secondNumber;
    }
}
