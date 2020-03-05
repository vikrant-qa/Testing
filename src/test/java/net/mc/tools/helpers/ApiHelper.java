package net.mc.tools.helpers;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.specification.RequestSpecification;
import com.typesafe.config.Config;
import net.mc.tools.utilities.ConfigLoader;

import java.net.URI;

import static com.jayway.restassured.RestAssured.given;

public class ApiHelper {

    static Config conf = ConfigLoader.load();

    static String webDriverBaseUrl = conf.getString("webDriverBaseUrl");

    protected static RequestSpecification auth() {
        RestAssured.baseURI = URI.create(webDriverBaseUrl).toString();
        return given()
                .header("host","auth")
                .header("apikey", "e7b4e90efa6942798fde1c43c589d75a")
                .header("Content-Type", "application/json");
    }

    protected static RequestSpecification authWithToken(String token){
        RestAssured.baseURI = URI.create(webDriverBaseUrl).toString();
        return given()
                .header("host","auth")
                .header("apikey", "e7b4e90efa6942798fde1c43c589d75a")
                .header("Content-Type", "application/json")
                .header("token", token);

    }

    protected static RequestSpecification productWithToken(String token){
        RestAssured.baseURI = URI.create(webDriverBaseUrl).toString();
        return given()
                .header("host","product")
                .header("apikey", "e7b4e90efa6942798fde1c43c589d75a")
                .header("Content-Type", "application/json")
                .header("token", token);
    }

    protected static RequestSpecification bulkWithToken(String token){
        RestAssured.baseURI = URI.create(webDriverBaseUrl).toString();
        return given()
                .header("host","bulk-upload")
                .header("apikey", "e7b4e90efa6942798fde1c43c589d75a")
                .header("Content-Type", "application/json")
                .header("token", token);
    }

    protected static RequestSpecification emailWithToken(String token){
        RestAssured.baseURI = URI.create(webDriverBaseUrl).toString();
        return given()
                .header("host","email")
                .header("apikey", "e7b4e90efa6942798fde1c43c589d75a")
                .header("Content-Type", "application/json")
                .header("token", token);
    }

    protected static RequestSpecification orderWithToken(String token){
        RestAssured.baseURI = URI.create(webDriverBaseUrl).toString();
        return given()
                .header("host","order")
                .header("apikey", "e7b4e90efa6942798fde1c43c589d75a")
                .header("Content-Type", "application/json")
                .header("token", token);
    }
    protected static RequestSpecification emailWithoutToken(){
        RestAssured.baseURI = URI.create(webDriverBaseUrl).toString();
        return given()
                .header("host","email")
                .header("apikey", "e7b4e90efa6942798fde1c43c589d75a")
                .header("Content-Type", "application/json");

    }
}
