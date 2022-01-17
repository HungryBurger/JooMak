package com.joomak.backend.domain.common;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@Builder
public class CommonResponse<T> {

    private final HttpStatus httpStatus;

    private final String message;

    private final T data;
}
