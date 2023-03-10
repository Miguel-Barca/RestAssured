package com.psrestassured.module7;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class PostMethodDemo {

    public static final String BASE_URL = "https://api.github.com/user/repos";

    public static final String TOKEN = "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";

    @Test(description = "Failing test")
    public void postTestWithoutCredentials() {

        RestAssured
                .given()
                    .body("{\"name\": \"deleteme\"}")
                .when()
                    .post(BASE_URL)
                .then()
                    .statusCode(201);
    }

    @Test(description = "Create a repo")
    public void postTestWithCredentials() {

        RestAssured
                .given()
                .header("Authorization", "token " + TOKEN)
                    .body("{\"name\": \"deleteme\"}")
                .when()
                    .post(BASE_URL)
                .then()
                    .statusCode(201);
    }

}
