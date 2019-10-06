package com.course.testng.marketing;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestContent {

    private String url;
    private String token;
    private ResourceBundle bundle;

    @BeforeTest
    public void beforeTest(){
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        url = bundle.getString("test.url");
    }

    //登陆接口
    @BeforeClass
    public void testLogin(){
        String uri = bundle.getString("api.admin.gwy");
        String testUrl = this.url + uri;
        Response response =
                given().
                        formParams("access_token","2496b3771d024f01b2e5f38b155c877e",
                                "app_key","test",
                                "data","%7B%22mobile%22%3A%2218514506336%22%2C%22password%22%3A%22YTExMTExMQ%3D%3D%22%7D",
                                "format","json",
                                "name","gwy.base.login",
                                "sign","BF4D59FF8A18584F66B8EE957EAF4E76",
                                "timestamp","2019-09-27 12:14:05",
                                "version","").
                        when().
                        post(testUrl).
                        then().
                        body("code",equalTo("0")).
                        extract().response();
        System.out.println("【登陆】接口返回信息是："+response.asString());
        token = response.path("data.token");
    }


    //查询转发助手列表接口
    @Test(priority = 1)
    public void testListContent(){
        String uri = bundle.getString("test.list.content");
        String testUrl = this.url + uri;
        Response response =
                given().
                        headers("Authorization",token,
                                "token",token).
                        when().
                        get(testUrl).
                        then().log().ifError().
                        body("msg",equalTo("成功")).
                        extract().response();
        System.out.println("【查询转发助手列表】接口返回信息是："+response.asString());
        //获取列表数据条数
        List content = response.path("param.content");
        Assert.assertTrue(content.size() > 0);
    }
}
