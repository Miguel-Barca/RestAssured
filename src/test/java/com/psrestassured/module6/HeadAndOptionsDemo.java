package com.psrestassured.module6;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class HeadAndOptionsDemo {

    public static final String BASE_URL = "https://api.github.com/users/rest-assured";

    @Test
    public void headTest() {
        RestAssured.head(BASE_URL)
                .then()
                .statusCode(200)
                .body(emptyOrNullString());
    }

    @Test
    public void optionsTest() {
        RestAssured.options(BASE_URL)
                .then()
                .statusCode(204)
                .header("access-control-allow-methods", equalTo("GET, POST, PATCH, PUT, DELETE"))
                .body(emptyOrNullString());
    }
}
