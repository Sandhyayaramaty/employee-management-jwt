package com.example.employeemanagement.exception;

public class ErrorResponse {
    //It is simply a Java object that represents our error response.

    private String message;
    private int status;

    public ErrorResponse(String message, int status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }
}