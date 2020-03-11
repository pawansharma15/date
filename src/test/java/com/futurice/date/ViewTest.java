package com.futurice.date;

import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ViewTest {
    private View view;

    @BeforeEach
    void setup() {
        view = new View();
    }

    @Test
    void createSuccessResponse_givenInteger_returnsJsonMessage() {
        JSONObject expected = new JSONObject()
                .fluentPut("error", false)
                .fluentPut("result", 1);

        assertEquals(expected, view.createSuccessResponse(1));
    }

    @Test
    void createErrorResponse_givenErrorString_returnsJsonMessage() {
        JSONObject expected = new JSONObject()
                .fluentPut("error", true)
                .fluentPut("message", "Error Message");

        assertEquals(expected, view.createErrorResponse("Error Message"));
    }
}