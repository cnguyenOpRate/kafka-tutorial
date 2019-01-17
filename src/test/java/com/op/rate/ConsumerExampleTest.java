package com.op.rate;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConsumerExampleTest {

    private ConsumerExample example = new ConsumerExample();

    @Test
    public void test_readMessages() {
        example.readMessages();
    }
}