package com.shyren.unittesting.unittesting.spike;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {

    String actualResp = "{\"id\": 1,\n" +
            "    \"price\": 100,\n" +
            "    \"quantity\": 10,\n" +
            "    \"name\": \"Ball\"\n" +
            "}";

    @Test
    public void jsonAssert() throws JSONException {
        // JSONAssert.assertEquals(expected, actual, strict);
        String expected = "{\"id\": 1,\n" +
                "    \"price\": 100,\n" +
                "    \"quantity\": 10,\n" +
                "    \"name\": \"Ball\"\n" +
                "}";
        JSONAssert.assertEquals(expected, actualResp, true);

    }
}
