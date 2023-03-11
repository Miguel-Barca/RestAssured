package com.psrestassured.module1through5;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class BasicTest {

    public static final String BASE_URL = "https://api.github.com";
    @Test
    public void someTest() {
        RestAssured.get(BASE_URL)
                .then()
                .statusCode(200);
    }

    @Test
    public void peek() {
        RestAssured.get(BASE_URL)
                .peek();
    }

    @Test
    public void prettyPeek() {
        RestAssured.get(BASE_URL)
                .prettyPeek();
    }
}
