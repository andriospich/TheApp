package com.develogical;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Test;
import com.develogical.web.FibonacciProcessor;

public class FinbonacciProcessorTest {
    @Test
    public void name() throws Exception {
        String s = "what is the 6th number in the Fibonacci sequence";
        FibonacciProcessor processor = new FibonacciProcessor();
        assertThat(processor.matchRequest(s), is(true));
        assertThat(processor.result(s),is("8"));
    }
}
