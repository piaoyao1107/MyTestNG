package com.tester.extend.demo;


import org.testng.Assert;
import org.testng.annotations.Test;

public class TestPost {

    @Test
    public void test10(){
        Assert.assertEquals(1,1);
    }

    @Test
    public void test11(){
        Assert.assertEquals(1,2);
    }
}
