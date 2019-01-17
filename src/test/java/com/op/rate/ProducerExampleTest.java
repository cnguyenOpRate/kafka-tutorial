package com.op.rate;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProducerExampleTest {

    private ProducerExample example = new ProducerExample();

    @Test
    public void test_sendMessage() {
        example.sendMessage();
    }
}