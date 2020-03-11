package com.futurice.date;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, @Nullable Object body, HttpHeaders headers,
                                                             HttpStatus status, WebRequest request) {
        String errorMessage;

        if(ex instanceof MethodArgumentTypeMismatchException)
            errorMessage = "Please provide date as YYYY-MM-DD";
        else if(HttpStatus.INTERNAL_SERVER_ERROR.equals(status))
            errorMessage = "Unknown error while processing request";
        else
            errorMessage = ex.getMessage();

        JSONObject errorResponse = new View().createErrorResponse(errorMessage);
        return new ResponseEntity<>(errorResponse, headers, status);
    }
}
