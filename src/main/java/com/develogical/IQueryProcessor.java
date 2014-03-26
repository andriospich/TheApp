package com.develogical;

public interface IQueryProcessor {

    boolean matchRequest(String query);

    String result(String query);
}
