package com.course.testng.marketing;

import com.alibaba.fastjson.JSON;
import io.restassured.response.Response;
import org.testng.annotations.*;

import java.util.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import com.course.linkMysql;


public class TestCategory {

    private String url;
    private String token;
    private ResourceBundle bundle;

    @BeforeTest
    public void beforeTest(){

        token = linkMysql.mysqlSelect();
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        url = bundle.getString("test.url");
    }

//    @BeforeTest
//    public void beforeTest(){
//        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
//        url = bundle.getString("test.url");
//    }
//
//
//    //登陆接口
//    @BeforeClass
//    public void testLogin(){
//        String uri = bundle.getString("api.admin.gwy");
//        String testUrl = this.url + uri;
//        Response response =
//                given().
//                        formParams("access_token","2496b3771d024f01b2e5f38b155c877e",
//                                "app_key","test",
//                                "data","%7B%22mobile%22%3A%2218514506336%22%2C%22password%22%3A%22YTExMTExMQ%3D%3D%22%7D",
//                                "format","json",
//                                "name","gwy.base.login",
//                                "sign","BF4D59FF8A18584F66B8EE957EAF4E76",
//                                "timestamp","2019-09-27 12:14:05",
//                                "version","").
//                        when().
//                        post(testUrl).
//                        then().
//                        body("code",equalTo("0")).
//                        extract().response();
//        System.out.println("【登陆】接口返回信息是："+response.asString());
//        token = response.path("data.token");
//    }

    //查询分类列表接口
    @Test(priority = 1)
    public void testListCategory(){
        String uri = bundle.getString("test.list.category");
        String testUrl = this.url + uri;
        Response response =
                given().
                        headers("Authorization",token,
                                "token",token).
                        when().
                        get(testUrl).
                        then().
                        body("msg",equalTo("成功")).
                        extract().response();
        System.out.println("【查询分类列表1】接口返回信息是："+response.asString());
    }


    //添加分类接口
    @Test(priority = 2)
    public void testAddCategory(){
        String uri = bundle.getString("test.add.category");
        String testUrl = this.url + uri;
        long nowDate =  new Date().getTime();
        String categoryName = "分类"+nowDate;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name",categoryName);
        String mapJson = JSON.toJSONString(map);
        Response response =
                given().
                        body(mapJson).
                        headers("token",token,
                                "Content-Type","application/json; charset=UTF-8").
                        when().
                        post(testUrl).
                        then().
                        body("msg",equalTo("成功")).
                        body("success",equalTo(true)).
                        body("param.status",equalTo("INITIALIZED")).
                        extract().response();
        System.out.println("【添加分类】接口返回信息是："+response.asString());
    }

}
