package com.course.demo;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestDemo {

    @Test
    public void testcase1(){
        System.out.println("****** 这是case1 ******");
        Assert.assertEquals(1,1);
    }

    @Test
    public void testcase2(){
        System.out.println("****** 这是case2 ******");
        Assert.assertEquals(1,2);
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("****** beforeTest 执行了 ******");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("****** afterTest 执行了 ******");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("****** beforeMethod 执行了 ******");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("****** afterMethod 执行了 ******");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("****** beforeClass 执行了 ******");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("****** afterClass 执行了 ******");
    }

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("****** beforeSuite 执行了 ******");
    }

    @AfterSuite
    public void AfterSuite(){
        System.out.println("****** AfterSuite 执行了 ******");
    }
}

