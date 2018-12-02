package com.kouchos.userprofileservice.service;

import com.kouchos.userprofileservice.domain.UserProfile;
import com.kouchos.userprofileservice.repository.UserProfileRepository;
import lombok.extern.slf4j.Slf4j;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserProfileServiceImplTest {

    @InjectMocks
    UserProfileServiceImpl userServiceImpl;

    @Mock
    UserProfileRepository userProfileRepository;

    @Test
    public void shouldFindByEmailAddress() throws Exception {
        final String EMAIL = "fake@email.com";
        UserProfile mockUserProfile = UserProfile.builder().id(1L).email(EMAIL).firstName("first").lastName("Last").build();

        Mockito.when(userProfileRepository.findByEmail(EMAIL)).thenReturn(Optional.of(mockUserProfile));

        Optional<UserProfile> userByEmail = userServiceImpl.getUserByEmail(EMAIL);
        assertThat(userByEmail, is(not(nullValue())));
    }

    @Test
    public void runTest() throws Exception {
        String time = userServiceImpl.getTime();
        assertThat(time, Matchers.is(not(nullValue())));
        log.info(time);
        System.out.println(time);
    }
}