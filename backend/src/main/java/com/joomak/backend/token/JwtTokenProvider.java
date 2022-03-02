package com.joomak.backend.token;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class JwtTokenProvider {

    @Value("${secret.key}")
    private String secretKey;

    static final long tokenValidTime = 60 * 60 * 1000L;
    static final String AUTHORIZATION_HEADER = "Authorization";
    static final String TOKEN_PREFIX = "Token ";
    static final int SUBSTRING_TOKEN = 6;

    public String resolveToken(HttpServletRequest request) {
        String header = request.getHeader(AUTHORIZATION_HEADER);
        if (StringUtils.hasText(header) && header.startsWith(TOKEN_PREFIX)) {
            return header.substring(SUBSTRING_TOKEN);
        }
        return null;
    }

    public String getEmailFromToken(String token) {
        return this.getClaimFromToken(token, Claims::getSubject);
    }

    public Date getExpirationDateFromToken(String token) {
        return this.getClaimFromToken(token, Claims::getExpiration);
    }

    private <T> T getClaimFromToken(String jwtToken, Function<Claims, T> claimsResolver) {
        Claims claims = this.getClaimsFromToken(jwtToken);
        return claimsResolver.apply(claims);
    }

    private Claims getClaimsFromToken(String jwtToken) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwtToken).getBody();
    }

    public String createToken(String username) {
        return Jwts.builder()
                .setClaims(Jwts.claims())
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + tokenValidTime))
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }

    public boolean validateToken(String jwtToken) {
        return !this.isTokenExpired(jwtToken);
    }

    private Boolean isTokenExpired(String token) {
        final Date expiration = this.getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }
}