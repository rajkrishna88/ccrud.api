package com.api.demo.advice;

import com.api.demo.exception.EmployeeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerClass {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionMsg> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
       ExceptionMsg response=new ExceptionMsg();
        ex.getAllErrors().forEach(err ->
            response.setError(err.getDefaultMessage()));
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ExceptionMsg> hanldeEmployeeNotFoundException(EmployeeNotFoundException msg){
        ExceptionMsg response=new ExceptionMsg();
        response.setError(msg.getLocalizedMessage());
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }
}
