package com.api.demo.advice;

import com.api.demo.exception.EmployeeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionHandlerClass {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
        Map<String,String> errorMap=new HashMap<>();
        ex.getAllErrors().forEach(err ->{
            errorMap.put("errorMsg",err.getDefaultMessage());
        });
        return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<Map<String,String>> hanldeEmployeeNotFoundException(EmployeeNotFoundException ex){
        Map<String,String> errorMap=new HashMap<>();
        errorMap.put("errorMsg",ex.getLocalizedMessage());
        return new ResponseEntity<>(errorMap,HttpStatus.BAD_REQUEST);
    }
}
