package ru.testproj.book.backend.security.jwt;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.UUID;



public class JwtUser implements UserDetails {

    private final UUID id;
    private final String login;
    private final String password;
    private final Collection<? extends GrantedAuthority> authorities;

    public JwtUser(
            UUID id,
            String login,
            String password,
            Collection<? extends GrantedAuthority> authorities
            )
    {
        this.id = id;
        this.login = login;
        this.password = password;
        this.authorities = authorities;
    }

    @JsonIgnore
    public UUID getId() {
        return id;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }


    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    @JsonIgnore
    public boolean isEnabled() {
        return true;
    }


}
