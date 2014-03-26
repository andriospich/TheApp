package com.develogical;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlusMultiplyProcessor implements IQueryProcessor {

	@Override
	public boolean matchRequest(String query) {
		// TODO Auto-generated method stub
		return query.contains("plus" ) || query.contains("multiplied" ) ;
	}

	@Override
	public String result(String query) {
		// TODO Auto-generated method stub

    	Pattern pattern = Pattern.compile(".*? (\\d+) (plus|multiplied by) (\\d+) (plus|multiplied by) (\\d+)");
    	Matcher matcher = pattern.matcher(query);
    	if (matcher.matches()) {

			return String.valueOf(processAll(query));
		}
		
		if (query.contains("plus"))
			return processPlus(query);

		if (query.contains("multiplied"))
			return processMultiply(query);
		
		return "";
	}

    private int processAll(String query) {
    	Pattern pattern = Pattern.compile(".*? (\\d+) (plus|multiplied by) (\\d+) (plus|multiplied by) (\\d+)");
    	Matcher matcher = pattern.matcher(query);
    	if (matcher.matches()) {
        	int num1 = Integer.parseInt(matcher.group(1));
        	String op1 = matcher.group(2);
        	int num2 = Integer.parseInt(matcher.group(3));
        	String op2 = matcher.group(4);
        	int num3 = Integer.parseInt(matcher.group(5));

			if (op1.equals("plus") && op2.equals("multiplied by"))
				return  num2 * num3 + num1;

			int partialRes = 0;
			
			if (op1.equals("plus")) 
				partialRes =   num1 + num2;
			else
				partialRes =   num1 * num2;

			if (op2.equals("plus")) 
				partialRes +=  num3;
			else
				partialRes *=  num3;
			
			return partialRes;
    	}
    	return 0;
	}

	
    private String processMultiply(String query) {
    	Pattern pattern = Pattern.compile(".*? (\\d+) multiplied by (\\d+)");
    	Matcher matcher = pattern.matcher(query);
    	int result = 0;
    	if (matcher.matches()) {
        	String group1 = matcher.group(1);
        	String group2 = matcher.group(2);
        	result = Integer.parseInt(group1) * Integer.parseInt(group2);
        	
        	return String.valueOf(result);
    	}
    	return "";
	}

	private String processPlus(String query)
    {
    	Pattern pattern = Pattern.compile(".*? (\\d+) plus (\\d+)");
    	Matcher matcher = pattern.matcher(query);
    	int result = 0;
    	if (matcher.matches()) {
        	String group1 = matcher.group(1);
        	String group2 = matcher.group(2);
        	result += Integer.parseInt(group1) + Integer.parseInt(group2);
        	
        	return String.valueOf(result);
    	}
    	return "";
    }
    
}
