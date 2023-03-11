package com.psrestassured.module7;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class PostMethodDemo {

    public static final String BASE_URL = "https://api.github.com/user/repos";

    public static final String TOKEN = "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"; //This is deleted after pushed to github. You should generate a new token to run the code

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

    @Test(description = "Update Repo")
    public void patchTestWithCredentials() {

        RestAssured
                .given()
                    .header("Authorization", "token " + TOKEN)
                    .body("{\"name\": \"deleteme-patched\"}")
                .when()
                    .patch("https://api.github.com/repos/Miguel-Barca/deleteme")
                .then()
                    .statusCode(200);
    }

    @Test(description = "Deleting Repo")
    public void deleteTestWithCredentials() {

        RestAssured
                .given()
                .header("Authorization", "token " + TOKEN)
                .when()
                .delete("https://api.github.com/repos/Miguel-Barca/deleteme-patched")
                .then()
                .statusCode(204);
    }
}
