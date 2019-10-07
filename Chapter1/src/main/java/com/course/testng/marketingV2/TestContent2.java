package com.course.testng.marketingV2;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import com.course.linkMysql;


public class TestContent2 {



    private String url;
    private String token;
    private ResourceBundle bundle;

    @BeforeClass
    public void beforeTest(){

        token = linkMysql.mysqlSelect();
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        url = bundle.getString("test.url");
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
