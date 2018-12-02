package com.kouchos.authservice.service;

import com.kouchos.authservice.domain.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService {
    public User createUser(User newUser);

    public User findUserByEmail(String email) throws UsernameNotFoundException;

}
