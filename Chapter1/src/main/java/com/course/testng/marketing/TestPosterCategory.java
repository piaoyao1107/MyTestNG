package com.course.testng.marketing;

import com.alibaba.fastjson.JSON;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestPosterCategory {

    private String url;
    private String token;
    private String categoryId;
    private int ordinal;
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

    //精品海报分类列表接口
    @Test(priority = 1)
    public void testListCategory(){
        String uri = bundle.getString("test.list.poster.category");
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
        System.out.println("【查询海报分类列表】接口返回信息是："+response.asString());
        //获取列表数据条数
        List content = response.path("param.content");
        Assert.assertTrue(content.size() > 0);
    }

    //添加海报分类接口
    @Test(priority = 2)
    public void testAddPosterCategory(){

        String uri = bundle.getString("test.add.poster.category");
        String testUrl = this.url + uri;

        SimpleDateFormat df = new SimpleDateFormat("HHmmss");//设置日期格式
        String nowDate =  df.format(new Date());
        String categoryName = "分类"+nowDate;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name",categoryName);
        String mapJson = JSON.toJSONString(map);

        Response response =
                given().
                        headers("Authorization",token,
                                "token",token,
                                "Content-Type","application/json; charset=UTF-8").
                        body(mapJson).
                        when().
                        post(testUrl).
                        then().log().ifError().
                        body("msg",equalTo("成功")).
                        extract().response();
        System.out.println("【添加海报分类】接口返回信息是："+response.asString());
        categoryId = response.path("param.id");
        ordinal = response.path("param.ordinal");
    }

    //编辑海报分类接口
    @Test(priority = 3)
    public void testEditPosterCategory(){

        String uri = bundle.getString("test.edit.poster.category");
        String testUrl = this.url + uri;

        SimpleDateFormat df = new SimpleDateFormat("HHmmss");//设置日期格式
        String nowDate =  df.format(new Date());
        String categoryName = "类分"+nowDate;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name",categoryName);
        map.put("id",categoryId);
        map.put("ordinal",ordinal);
        String mapJson = JSON.toJSONString(map);

        Response response =
                given().
                        headers("Authorization",token,
                                "token",token,
                                "Content-Type","application/json; charset=UTF-8").
                        body(mapJson).
                        when().
                        put(testUrl).
                        then().log().ifError().
                        body("msg",equalTo("成功")).
                        extract().response();
        System.out.println("【编辑海报分类】接口返回信息是："+response.asString());

    }

    //删除海报分类接口
    @Test(priority = 4)
    public void testDeletePosterCategory(){

        String uri = bundle.getString("test.delete.poster.category");
        String testUrl = this.url + uri+categoryId;

        Response response =
                given().
                        headers("Authorization",token,
                                "token",token,
                                "Content-Type","application/json; charset=UTF-8").
                        when().
                        post(testUrl).
                        then().log().ifError().
                        body("msg",equalTo("成功")).
                        extract().response();
        System.out.println("【删除海报分类】接口返回信息是："+response.asString());
    }

}

