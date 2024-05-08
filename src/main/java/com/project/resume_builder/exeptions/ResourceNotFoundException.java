package com.project.resume_builder.exeptions;

import lombok.Data;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
