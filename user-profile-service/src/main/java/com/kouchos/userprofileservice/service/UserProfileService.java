package com.kouchos.userprofileservice.service;

import com.kouchos.userprofileservice.domain.UserProfile;

import java.util.Optional;

public interface UserProfileService {
    Optional<UserProfile> getUserByEmail(String email);

    UserProfile addUser(String email, String firstName, String lastName);
}
