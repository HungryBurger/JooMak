package com.joomak.backend.token;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

@Slf4j
public class JwtAuthenticationFilterV2 extends GenericFilterBean {
    private final Logger logger = LoggerFactory.getLogger(JwtAuthenticationFilterV2.class);

    private JwtTokenProviderV2 jwtTokenProviderV2;

    public static final String AUTHORIZATION_HEADER = "Authorization";

    public JwtAuthenticationFilterV2(JwtTokenProviderV2 jwtTokenProviderV2) {
        this.jwtTokenProviderV2 = jwtTokenProviderV2;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("JwtAuthenticationFilterV2 - doFilter method is called");

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        // 1. Header의 Authorization에 할당되어있는 Token 값을 받아온다.
        String jwt = resolveToken(httpServletRequest);
        String requestUri = httpServletRequest.getRequestURI();

        // 2. Token을 검증
        if (StringUtils.hasText(jwt) && jwtTokenProviderV2.validateToken(jwt)) {

            // 3. Token을 Parsing -> Claim 객체를 얻는다 -> Claim 객체로부터 Authority 객체를 얻는다 -> User 객체 생성 후 -> UsernamePasswordAuthenticationToken 객체를 반환받는다.
            Authentication authentication = jwtTokenProviderV2.getAuthentication(jwt);

            // 4. Authentication 객체를 받아 SecurityContextHolder에 Setting한다.
            SecurityContextHolder.getContext().setAuthentication(authentication);
            log.info("Security Context에 '{}' 인증 정보를 저장했습니다. Uri : {}", authentication.getName(), requestUri);
        } else {
            log.info("유효한 Jwt 토큰이 없습니다, Uri : {}", requestUri);
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    private String resolveToken(HttpServletRequest req) {
        String bearerToken = req.getHeader(AUTHORIZATION_HEADER);

        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }

        return null;
    }
}
