package com.joomak.backend.token;

import com.joomak.backend.domain.member.dto.MemberLoginDto;
import com.joomak.backend.domain.member.entity.Member;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class JwtTokenProviderV2 implements InitializingBean {
    private final Logger logger = LoggerFactory.getLogger(JwtTokenProviderV2.class);

    @Value("${jwt.key}")
    private String JWT_KEY;
    private final String AUTHORITIES_KEY;

    private final String secret;
    private final long tokenValidityInMilliseconds;

    private Key key;

    /*
      참조 file : application.yml
      jwt:
          header: Authorization
          secret: T3VyU2lkZVByb2plY3RJc0pvb21ha091clNpZGVQcm9qZWN0SXNKb29tYWtPdXJTaWRlUHJvamVjdElzSm9vbWFrT3VyU2lkZVByb2plY3RJc0pvb21ha091clNpZGVQcm9qZWN0SXNKb29tYWs=
          token-validity-in-seconds: 86400
    */
    public JwtTokenProviderV2(
        @Value("${jwt.secret}") String secret,
        @Value("${jwt.token-validity-in-seconds}") Long tokenValidityInMilliseconds
    ) {
        this.secret = secret;
        this.tokenValidityInMilliseconds = tokenValidityInMilliseconds;
        this.AUTHORITIES_KEY = "authorities";
    }

    @Override
    public void afterPropertiesSet() {
        // application.yaml 파일의 jwt -> secret 에 BASE64로 Encoding 되어있는 값을 Decoding하여 KeyBytes 생성
        byte[] keyBytes = Decoders.BASE64.decode(secret);

        // Decoding된 KeyBytes를 가지고 Signature Algorithm을 적용해 Key를 생성한다.
        this.key = Keys.hmacShaKeyFor(keyBytes);
    }

    public String createToken(Authentication authentication) {
        var a = (MemberLoginDto)authentication.getPrincipal();

        // Member에서 받아온 Authority는 GrantedAuthority를 상속하고 있지 않기 때문에 변환하는 작업을 거친다.
        String authorities = authentication.getAuthorities().stream()
            .map(GrantedAuthority::getAuthority)
            .collect(Collectors.joining(","));

        long now = (new Date()).getTime();
        Date validity = new Date(now + this.tokenValidityInMilliseconds);

        return Jwts.builder()
            .setSubject(authentication.getName())
            .claim(AUTHORITIES_KEY, authorities)
            .signWith(key, SignatureAlgorithm.HS512)
            .setExpiration(validity)
            .compact();
    }

    public Authentication getAuthentication(String token) {
        // Secret 값을 BASE64로 Decoding하여 Signature Algorithm을 적용하여 만든 Key를 통해 Token을 Parsing하여 Claim 객체를 얻는다.
        // Claim은 Map<String, Object>를 extends 하고 있으며, Key를 추가하고 싶으면 put Method를 사용하면 된다.
        Claims claims = Jwts.parserBuilder()
            .setSigningKey(key)
            .build()
            .parseClaimsJws(token)
            .getBody();

        // Token을 생성할 때( createToken ) AUTHORITIES_KEY를 Key로 하는 Property를 Claim에 추가하는데 그걸 받아온다.
        Collection<? extends GrantedAuthority> authorities =
            Arrays.stream(claims.get(AUTHORITIES_KEY).toString().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());


        MemberLoginDto principal = MemberLoginDto.builder()
            .email(claims.getSubject())
            .roles(authorities)
            .build();

        // SecurityContex에 저장하여 둘 정보를 저장한다.
        return new UsernamePasswordAuthenticationToken(principal, token, authorities);
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (io.jsonwebtoken.security.SecurityException | MalformedJwtException e) {
            logger.info("잘못된 Jwt 서명입니다.");
        } catch (ExpiredJwtException e) {
            logger.info("만료된 Jwt 토큰입니다.");
        } catch (UnsupportedJwtException e) {
            logger.info("지원되지 않는 Jwt 토큰입니다.");
        } catch (IllegalArgumentException e) {
            logger.info("Jwt 토큰이 잘못되었습니다.");
        }

        return false;
    }
}
