package com.api.demo.exception;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(String s) {
        super(s);
    }
}
