package com.project.resume_builder.controllers;

public class BasicErrorResponse {
    private int statusCode;
    private String message;

    public BasicErrorResponse(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    // Геттеры и сеттеры для statusCode и message
}
