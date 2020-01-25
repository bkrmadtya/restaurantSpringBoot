package com.sda.course.project.restaurant.validation;

import com.sda.course.project.restaurant.validation.customExceptions.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
//TODO: i would move the classs out of validation package [maybe under exception package or controller package]
//TODO: remove unused lines
@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({PersonNotFoundException.class, OrderNotFoundException.class, RoleNotFoundException.class, MealNotFoundException.class, OrderDetailNotFound.class})
    public void springHandleNotFound(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.NOT_FOUND.value());
    }

    // Error handler for validating path variables and request params
//    @ExceptionHandler(ConstraintViolationException.class)
//    public void constraintViolationException(HttpServletResponse response) throws IOException {
//        response.sendError(HttpStatus.BAD_REQUEST.value());
//    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    String handleConstraintViolationException(ConstraintViolationException e) {
        return "Not valid due to validation error: " + e.getMessage();
    }

    // Error handler for @Valid
    @Override
    protected ResponseEntity<Object>
    handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", new Date());
        body.put("status", status.value());

        //Get all errors
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage()).collect(Collectors.toList());
        body.put("errors", errors);

        return new ResponseEntity<>(body, headers,status);
    }


}
