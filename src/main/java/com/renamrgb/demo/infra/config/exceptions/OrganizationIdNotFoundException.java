package com.renamrgb.demo.infra.config.exceptions;

public class OrganizationIdNotFoundException extends RuntimeException {
    public OrganizationIdNotFoundException(String message) {
        super(message);
    }
}
