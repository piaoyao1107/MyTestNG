package com.course.testng.apps;

import com.course.linkMysql;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Locale;
import java.util.ResourceBundle;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;



public class AppLogin {


    //登陆接口
    @Test
    public void testLogin(){
        String testUrl = "https://service-wbs300.newtamp.cn/http/advisor/login.json" ;
        Response response =
                given().
//                        formParams("access_token","2496b3771d024f01b2e5f38b155c877e",
//                                "app_key","test",
//                                "data","%7B%22mobile%22%3A%2218514506336%22%2C%22password%22%3A%22YTExMTExMQ%3D%3D%22%7D",
//                                "format","json",
//                                "name","gwy.base.login",
//                                "sign","BF4D59FF8A18584F66B8EE957EAF4E76",
//                                "timestamp","2019-09-27 12:14:05",
//                                "version","").
                        formParams("data","{\"param\":{\"mobile\":\"18810180001\",\"password\":\"2892153a828936a011816c31a90daf61\",\"cid\":\"Apq__jBsnliM0RQW0x48iranJzWsERmOeTJ0inzahoCE\",\"platform\":\"1\",\"did\":\"4573b0983d0080db\"},\"sign\":\"ea0d5af9cd37cdf17bc80ea4f40043c3\"}").
                        when().
                        post(testUrl).
                        then().
                        extract().response();
        System.out.println("【登陆】接口返回信息是："+response.asString());
        String token = response.path("data.token");
        System.out.println("token >>> "+token);
    }
}
