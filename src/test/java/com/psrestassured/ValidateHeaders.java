package com.psrestassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ValidateHeaders {

    public static final String BASE_URL = "https://api.github.com";

    @Test
    public void convenienceMethods() {
        Response response = RestAssured.get(BASE_URL);
        assertEquals(response.getStatusCode(), 200);
        assertEquals(response.getContentType(), "application/json; charset=utf-8" );
    }

    @Test
    public void genericHeader() {
        Response response = RestAssured.get(BASE_URL);

        assertEquals(response.getHeader("Server"), "GitHub.com");

        //getheader() always returns a string, so in this case numbers will be a string
        assertEquals(response.getHeader("X-RateLimit-Limit"), "60");

        //in this case we us parseInt method to validate the actual numberic value
        assertEquals(Integer.parseInt(response.getHeader("X-RateLimit-Limit")), 60);
    }
}
