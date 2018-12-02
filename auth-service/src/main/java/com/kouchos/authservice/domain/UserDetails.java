package com.kouchos.authservice.domain;

import org.springframework.security.core.GrantedAuthority;

import java.time.LocalDate;
import java.util.Collection;

public class UserDetails implements org.springframework.security.core.userdetails.UserDetails {

    User user;

    public UserDetails(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return user.getAccount().getAccountExpiry() == null || user.getAccount().getAccountExpiry().isBefore(LocalDate.now());
    }

    @Override
    public boolean isAccountNonLocked() {
        return !user.getAccount().isAccountLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return !user.isDisabled() && !user.getAccount().isDisabled();
    }
}
