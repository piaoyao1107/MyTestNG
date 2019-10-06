package com.course.testng.marketing;

import io.restassured.response.Response;
import org.testng.annotations.BeforeSuite;

import java.util.Locale;
import java.util.ResourceBundle;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class SuiteConfig1 {

    //登陆接口
    @BeforeSuite
    public void testLogin(){

        System.out.println("******************* aaaaaaaaaaa *******************");

        ResourceBundle bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        String url = bundle.getString("test.url");

        String uri = bundle.getString("api.admin.gwy");
        String testUrl = url + uri;
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
        String token = response.path("data.token");

        System.out.println("******************* bbbbbbbbb *******************");
    }
}
