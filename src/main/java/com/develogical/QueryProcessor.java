package com.develogical;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QueryProcessor {

    static List<IQueryProcessor> IQueryProcessors = new ArrayList<IQueryProcessor>();

    static public void registerProcessor(IQueryProcessor proc) {
        IQueryProcessors.add(proc);
    }

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
                    if (query.contains("largest")) {
                        return processLargest(query);
                    }
                    else
                        if (query.contains("square and a cube")) {
                            return processSquareCube(query);
                        }
                  
        for (IQueryProcessor IQueryProcessor : IQueryProcessors) {
            if (IQueryProcessor.matchRequest(query)) {
                return IQueryProcessor.result(query);
            }
        }
        
    	System.out.println("<<<ACHTUNG!!!>> THIS IS NOT MANAGED: " + query);

        return "";
    }
    
    private String processMultiply(String query) {
    	Pattern pattern = Pattern.compile(".*? (\\d+) multiplied by (\\d+)");
    	Matcher matcher = pattern.matcher(query);
    	int result = 0;
    	if (matcher.matches()) {
        	String group1 = matcher.group(1);
        	String group2 = matcher.group(2);
        	result = Integer.parseInt(group1) * Integer.parseInt(group2);
        	
    	}
    	return String.valueOf(result);
	}

	private String processSquareCube(String query) {
    	Pattern pattern = Pattern.compile(".*? (\\d+), (\\d+)");
    	Matcher matcher = pattern.matcher(query);
    	int result = 0;
    	if (matcher.matches()) {
        	int first = Integer.parseInt( matcher.group(1));
        	int second = Integer.parseInt(matcher.group(2));
        	
        	double resFirstS = Math.pow(first,1./2.);
        	double resFirstC = Math.pow(first,1./3.);
        	
        	if ((resFirstS == Math.floor(resFirstS)) && (resFirstC == Math.floor(resFirstC)))
        		return String.valueOf(first);

        	double resSecS = Math.pow(second,1./2.);
        	double resSecC = Math.pow(second,1./3.);
        	
        	if ((resSecS == Math.floor(resSecS)) && (resSecC == Math.floor(resSecC)))
        		return String.valueOf(second);
        	
      		return "";

    	}
    	return String.valueOf(result);
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
