package com.course.testng;

import org.testng.annotations.*;

public class BasicAnnotation {

    @Test
    public void testcase1(){
        System.out.println("这是测试用例1");
    }

    @Test
    public void testcase2(){
        System.out.println("这是测试用例2");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("这是在测试方法之前执行的");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("这是在测试方法之后执行的");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("这是在测试类之前执行的");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("这是在测试类之后执行的");
    }

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("这是在测试套件之前执行的");
    }

    @AfterSuite
    public void AfterSuite(){
        System.out.println("这是在测试套件之后执行的");
    }
}

