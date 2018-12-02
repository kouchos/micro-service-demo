package com.kouchos.userprofileservice.service;

import com.kouchos.userprofileservice.domain.UserProfile;
import com.kouchos.userprofileservice.repository.UserProfileRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.Optional;

@Slf4j
@Service
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    UserProfileRepository userRepo;

    @Override
    public Optional<UserProfile> getUserByEmail(String email) {
        if (email == null) {
            log.warn("email is null");
            throw new IllegalArgumentException("email is null");
        }
        return userRepo.findByEmail(email);
    }

    @Override
    public UserProfile addUser(String email, String firstName, String lastName) {
        UserProfile newUserProfile = UserProfile.builder()
                .email(email)
                .firstName(firstName)
                .lastName(lastName)
                .build();
        UserProfile created = userRepo.save(newUserProfile);
        return created;
    }


    public String getTime() {
        return ZonedDateTime.now().toString();
    }
}
