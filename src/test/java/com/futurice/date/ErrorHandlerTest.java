package com.futurice.date;

import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ErrorHandlerTest {
    private ErrorHandler errorHandler;
    private View view;

    @BeforeEach
    void setup() {
        errorHandler = new ErrorHandler();
        view = new View();
    }

    @Test
    void handleExceptionInternal_whenMethodArgumentTypeMismatchException_returnResponseWithDateFormatError() throws NoSuchMethodException {
        JSONObject expected = view.createErrorResponse("Please provide date as YYYY-MM-DD");
        MethodArgumentTypeMismatchException ex = new MethodArgumentTypeMismatchException((Object) null,
                String.class,
                "test",
                new MethodParameter(Object.class.getMethod("toString"), -1),
                new Throwable());
        ResponseEntity<Object> response = errorHandler.handleExceptionInternal(ex, (Object) null, new HttpHeaders(), HttpStatus.BAD_REQUEST, null);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals(expected, response.getBody());
    }

    @Test
    void handleExceptionInternal_whenINTERNAL_SERVER_ERROR_returnResponseWithUnknownError() {
        JSONObject expected = view.createErrorResponse("Unknown error while processing request");
        ResponseEntity<Object> response = errorHandler.handleExceptionInternal(new Exception(), (Object) null, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, null);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals(expected, response.getBody());
    }

    @Test
    void handleExceptionInternal_forOtherExceptions_returnResponseWithExceptionMessage() {
        JSONObject expected = view.createErrorResponse("Exception");
        ResponseEntity<Object> response = errorHandler.handleExceptionInternal(new Exception("Exception"), (Object) null, new HttpHeaders(), HttpStatus.GATEWAY_TIMEOUT, null);

        assertEquals(HttpStatus.GATEWAY_TIMEOUT, response.getStatusCode());
        assertEquals(expected, response.getBody());
    }
}