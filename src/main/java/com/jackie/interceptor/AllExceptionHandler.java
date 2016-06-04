package com.jackie.interceptor;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by jackie on 2016/5/20.
 */
@ControllerAdvice
public class AllExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String exceptionHandler(Exception e) {
        System.out.println(e.getMessage());
        e.printStackTrace();
        return "error";
    }
}
