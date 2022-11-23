package com.joomak.backend.domain.member.dto;

import com.joomak.backend.domain.member.entity.Role;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Getter
@Setter
@NoArgsConstructor
public class MemberLoginDto implements UserDetails {
    private String email;
    private String password;
    private String memberName;
    private String nickName;
    private TokenDto tokenDto;
    private Collection<? extends GrantedAuthority> roles;
    private boolean isAutoLogin;

    @Builder
    public MemberLoginDto(String email, String password, String memberName, String nickName,
        TokenDto tokenDto, Collection<? extends GrantedAuthority> roles, boolean isAutoLogin) {
        this.email = email;
        this.password = password;
        this.memberName = memberName;
        this.nickName = nickName;
        this.tokenDto = tokenDto;
        this.roles = roles;
        this.isAutoLogin = isAutoLogin;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
