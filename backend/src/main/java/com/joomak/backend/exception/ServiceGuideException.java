package com.joomak.backend.exception;

import org.springframework.http.HttpStatus;
public class ServiceGuideException extends RuntimeException{

    private HttpStatus httpStatus = HttpStatus.OK;

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public ServiceGuideException() {
    }

    public ServiceGuideException(HttpStatus httpStatus, ServiceGuideMessage message) {
        super(message.getUserGuideMessage());
        this.httpStatus = httpStatus;
    }

    public ServiceGuideException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public ServiceGuideException(ServiceGuideMessage message, Throwable cause) {
        super(message.getUserGuideMessage(), cause);
    }
}