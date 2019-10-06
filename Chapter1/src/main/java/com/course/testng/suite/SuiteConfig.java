package com.course.testng.suite;

import org.testng.annotations.*;

public class SuiteConfig {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("beforeSuite运行啦～");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("afterSuite运行啦～");
    }

//    @BeforeTest
//    public void beforeTest(){
//        System.out.println("beforeTest");
//    }
//
//    @AfterTest
//    public void afterTest(){
//        System.out.println("afterTest");
//    }
//
//    @BeforeMethod
//    public void beforeMethod(){
//        System.out.println("这是在测试方法之前执行的");
//    }
//
//    @AfterMethod
//    public void afterMethod(){
//        System.out.println("这是在测试方法之后执行的");
//    }
}
