package com.kouchos.userprofileservice.controller;

import com.kouchos.userprofileservice.domain.UserProfile;
import com.kouchos.userprofileservice.dto.UserProfileDTO;
import com.kouchos.userprofileservice.service.UserProfileService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RestController
public class UserProfileController {

    @Autowired
    UserProfileService userProfileService;

    @GetMapping(path = {"/v1"})
    ResponseEntity<UserProfileDTO> getUserByEmail(@RequestParam String email) {

        log.info("getUserByEmail(" + email + ")");
        if (email == null || email.trim().isEmpty())
            return ResponseEntity.badRequest().build();

        Optional<UserProfile> userByEmail = userProfileService.getUserByEmail(email);
        if (userByEmail.isPresent())
            return ResponseEntity.ok(new ModelMapper().map(userByEmail.get(), UserProfileDTO.class));
        else
            return ResponseEntity.notFound().build();
    }

    @PostMapping(path = {"/v1"})
    ResponseEntity<UserProfileDTO> createUser(@RequestBody UserProfileDTO newUserProfileDTO) {
        log.info("createUser({})", newUserProfileDTO);
        UserProfile newUserProfile = userProfileService.addUser(newUserProfileDTO.getEmail(), newUserProfileDTO.getFirstName(), newUserProfileDTO.getLastName());
        return ResponseEntity.ok(new ModelMapper().map(newUserProfile, UserProfileDTO.class));
    }

    @GetMapping(path = "/testCreate/")
    ResponseEntity<UserProfile> testCreate(@RequestParam String email, @RequestParam String firstName, @RequestParam String lastName) {
        log.info("testCreate(" + email + ", " + firstName + ", " + lastName + ")");
        UserProfile newUserProfile = userProfileService.addUser(email, firstName, lastName);
        return ResponseEntity.ok(newUserProfile);
    }
}
