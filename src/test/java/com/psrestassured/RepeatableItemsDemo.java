package com.psrestassured;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class RepeatableItemsDemo {
    public static final String BASE_URL = "https://reqres.in/api/users?page=1";

    @Test
    public void repeatingItems(){
        RestAssured.get(BASE_URL)
                .then()
                .body("data.id[0]", equalTo(1));
    }
}
