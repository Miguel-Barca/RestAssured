package com.psrestassured.module1through5;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class bodyValidationDemo {
    public static final String BASE_URL = "https://api.github.com/";

    @DataProvider(name = "test-data")
    public Object[][] inputString() {
        return new Object[][] {
                {"rate_limit"},
                {"rest-assured"}
        };
    }

    @Test(dataProvider = "test-data")
    public void nestedBodyValidation(String name) {
        //System.out.println(name);
        RestAssured.get(BASE_URL+ name)
                .prettyPeek();
    }

    @Test
    public void nestedBodyValidation_2() {
        RestAssured.get(BASE_URL+ "rate_limit")
                .then()
                .rootPath("resources.core")
                    .body("limit", equalTo(60));
    }

}
