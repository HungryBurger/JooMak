package com.joomak.backend.token;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.joomak.backend.exception.ErrorResponse;
import com.joomak.backend.exception.ServiceGuideMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

import static javax.servlet.http.HttpServletResponse.SC_UNAUTHORIZED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private final ObjectMapper objectMapper;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setStatus(SC_UNAUTHORIZED);
        response.setContentType(APPLICATION_JSON_VALUE);

        ErrorResponse errorResponse = ErrorResponse.builder()
                .message(ServiceGuideMessage.REQUIRED_LOGIN.getUserGuideMessage())
                .build();

        OutputStream outputStream = response.getOutputStream();
        objectMapper.writeValue(outputStream, errorResponse);
        outputStream.flush();
    }
}
