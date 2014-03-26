package com.develogical;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.junit.matchers.StringContains.*;
import org.junit.Test;

public class QueryProcessorTest {

    QueryProcessor queryProcessor = new QueryProcessor();

    @Test
    public void returnsEmptyStringIfCannotProcessQuery() throws Exception {
        assertThat(queryProcessor.process("test"), is(""));
    }

    @Test
    public void knowsAboutProgramming() throws Exception {
        assertThat(queryProcessor.process("programming"), containsString("computing"));
    }

    @Test
    public void knowsAboutFootball() throws Exception {
        assertThat(queryProcessor.process("football"), containsString("neymar"));
    }    

    @Test
    public void knowsAboutCheese() throws Exception {
        assertThat(queryProcessor.process("cheese"), containsString("good"));
    }    

    @Test
    public void processPlus() throws Exception {
    	String test = "dh3h43s1: what is 16 plus 1";
    	
        assertThat(queryProcessor.process(test), containsString("17"));
    }    

    @Test
    public void processMultiply() throws Exception {
    	String test = "dh3h43s1: what is 16 multiplied by 2";
    	
        assertThat(queryProcessor.process(test), containsString("32"));
    }    

    @Test
    public void processLargest() throws Exception {
    	String test = "dh3h43s1: numbers largest: 100, 20, 70";
        assertThat(queryProcessor.process(test), containsString("100"));
    }    

    @Test
    public void processBanana() throws Exception {
    	String test = "dh3h43s1: what is the color of banana";
        assertThat(queryProcessor.process(test), containsString("yellow"));
    }

    @Test
    public void processSquareCube() throws Exception {
    	String test = "dh3h43s1: which is both a square and a cube: 454, 9";
    	
        assertThat(queryProcessor.process(test), containsString(""));
    }    
    
}
