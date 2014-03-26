package com.develogical;

public class BananaIQueryProcessor implements IQueryProcessor {

    public boolean matchRequest(String query) {
        return query.contains("banana");
    }

    public String result(String query) {
        return "yellow";
    }

}
