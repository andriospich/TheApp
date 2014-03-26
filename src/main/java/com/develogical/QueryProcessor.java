package com.develogical;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QueryProcessor {

    public String process(String query) {
    	
    	System.out.println("Our query is: " + query);
    	
        if (query.contains("programming")) {
            return "Computer programming is the comprehensive process that leads from an original " 
                   + "formulation of a computing problem to executable programs.";
        }
        else
            if (query.contains("football")) {
                return "The best player in the world is ronaldo...after neymar.";
            }
            else
                if (query.contains("cheese")) {
                    return "Cheese is very good";
                }
                else
                    if (query.contains("plus")) {
                        return processPlus(query);
                    }
                    else
                        if (query.contains("largest")) {
                            return processLargest(query);
                        }

    	System.out.println("<<<ACHTUNG!!!>> THIS IS NOT MANAGED: " + query);

        return "";
    }
    
    public String processPlus(String query)
    {
    	Pattern pattern = Pattern.compile(".*? (\\d+) plus (\\d+)");
    	Matcher matcher = pattern.matcher(query);
    	int result = 0;
    	if (matcher.matches()) {
        	String group1 = matcher.group(1);
        	String group2 = matcher.group(2);
        	result += Integer.parseInt(group1) + Integer.parseInt(group2);
        	
    	}
    	return String.valueOf(result);
    }

    public String processLargest(String query)
    {
    	String numbers = query.substring(query.lastIndexOf(":")+1);
    	
    	String[] numberSplit = numbers.split(",");
    	
    	int highest = Integer.MIN_VALUE;
    	
    	for(String num: numberSplit)
    	{
    		int number = Integer.valueOf(num.replace(" ", ""));
    		if (number > highest)
    			highest = number;
    	}
    	return String.valueOf(highest);
    }
}
