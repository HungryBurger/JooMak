package com.joomak.backend.domain.member.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TokenDto {
    private String token;

    @Builder
    public TokenDto(String token) {
        this.token = token;
    }
}
