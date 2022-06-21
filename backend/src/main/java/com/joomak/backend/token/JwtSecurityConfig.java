package com.joomak.backend.token;

import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class JwtSecurityConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
    private JwtTokenProviderV2 jwtTokenProviderV2;

    public JwtSecurityConfig(JwtTokenProviderV2 jwtTokenProviderV2) {
        this.jwtTokenProviderV2 = jwtTokenProviderV2;
    }

    @Override
    public void configure(HttpSecurity http) {
        JwtAuthenticationFilterV2 customFilter = new JwtAuthenticationFilterV2(jwtTokenProviderV2);
        http.addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class);
    }
}

