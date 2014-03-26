package com.develogical;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.junit.matchers.StringContains.containsString;
import junit.framework.Assert;

import org.junit.Test;

public class PlusMultiplyProcessorTest {

    PlusMultiplyProcessor processor = new PlusMultiplyProcessor();

	@Test
	public void testMatchRequest() {
        assertTrue(processor.matchRequest("2 plus 5"));
        assertTrue(processor.matchRequest("2 plus 5 plus 6"));
        assertTrue(processor.matchRequest("2 plus 5 multiplied by 8"));
        assertTrue(processor.matchRequest("2 multiplied by 5"));
        assertTrue(processor.matchRequest("2 multiplied by 5 plus 2"));
        assertTrue(processor.matchRequest("2 multiplied by 5 multiplied by 2"));
	}

	@Test
	public void testResult() {
        assertThat(processor.result("dh3h43s1: what is 2 plus 5"), is("7"));
        assertThat(processor.result("dh3h43s1: what is 2 plus 15 plus 3"), is("20"));
        assertThat(processor.result("dh3h43s1: what is 2 plus 5 multiplied by 8"), is("42"));
        assertThat(processor.result("dh3h43s1: what is 2 multiplied by 5"), is("10"));
        assertThat(processor.result("dh3h43s1: what is 2 multiplied by 5 plus 2"), is("12"));
        assertThat(processor.result("dh3h43s1: what is 2 multiplied by 5 multiplied by 2"), is("20"));
	}

}
