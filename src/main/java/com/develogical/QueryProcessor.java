package com.develogical;

public class QueryProcessor {

    public String process(String query) {
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

        return "";
    }
}
