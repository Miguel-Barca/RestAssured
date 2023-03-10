package com.psrestassured.module6;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.restassured.RestAssured;
import org.example.User;
import org.testng.annotations.Test;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.*;


public class  ObjectMappingDemo {

    public static final String BASE_URL = "https://api.github.com/users/rest-assured";

    @Test
    public void objectMappingTestOne() {

        User user = RestAssured.get(BASE_URL)
                .as(User.class);

        assertEquals(user.getLogin(), "rest-assured");
        assertEquals(user.getId(), 19369327);
        assertEquals(user.getPublicRepos(),2);

    }
}
