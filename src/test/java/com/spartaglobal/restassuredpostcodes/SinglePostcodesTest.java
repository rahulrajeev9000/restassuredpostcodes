package com.spartaglobal.restassuredpostcodes;

import io.restassured.response.ValidatableResponse;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.xml.validation.Validator;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class SinglePostcodesTest {


    private static ValidatableResponse jsonBody;

    @BeforeClass
    public static void setup(){
        baseURI = "https://api.postcodes.io";
        basePath = "/postcodes/";
        jsonBody = get("e62de").then();

    }

    @Test
    public void testSinglePostcodeService(){
        jsonBody.body("status",equalTo(200));
    }

    @Test
    public void testEqual(){
        jsonBody.body("result.quality", equalTo(1));
    }
}
