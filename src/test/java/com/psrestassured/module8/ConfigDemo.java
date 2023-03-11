package com.psrestassured.module8;

import io.restassured.RestAssured;
import io.restassured.config.FailureConfig;
import io.restassured.listener.ResponseValidationFailureListener;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.config.FailureConfig.*;
import static org.hamcrest.Matchers.equalTo;

public class ConfigDemo {

    public static final String BASE_URL = "https://api.github.com/";

    @Test
    public void failureConfigExample() {

        //implement a listener
        ResponseValidationFailureListener failureListener =
                (requestSpecification, responseSpecification, response) ->
                        System.out.printf("Status code was %s and body contained %s",
                        response.getStatusCode(), response.body().asPrettyString());

        RestAssured.config = RestAssured.config().failureConfig(failureConfig().failureListeners(failureListener));

        RestAssured.get(BASE_URL + "users/Miguel-Barca")
                .then()
                .body("some.path", equalTo("something"));
    }

}
