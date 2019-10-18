package com.course.demo;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.*;

import static io.restassured.RestAssured.given;

public class TestDemo {

    @Test(enabled = true)
    public void testcase1(){
        System.out.println("执行了 >>> testcase1");
        Assert.assertEquals(1,1);
    }

    @Test(enabled = true)
    public void testcase2(){
        System.out.println("执行了 >>> testcase2");
        Assert.assertEquals(1,2);
    }

    @Test(priority = 1,enabled = false)
    public void testBaidu(){Response response =
                given().
                        when().
                        get("https://www.baidu.com").
                        then().log().ifError().
                        statusCode(200).
                        extract().response();
        System.out.println("百度首页接口返回信息 >>> "+response.asString());
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("执行了 >>> beforeTest");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("执行了 >>> afterTest");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("执行了 >>> beforeMethod");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("执行了 >>> afterMethod");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("执行了 >>> beforeClass");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("执行了 >>> afterClass");
    }

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("执行了 >>> beforeSuite");
    }

    @AfterSuite
    public void AfterSuite(){
        System.out.println("执行了 >>> AfterSuite");
    }
}

