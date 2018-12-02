package com.kouchos.userprofileservice;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class PWEncoderTest {
    @Test
    public void testPWEncoding() throws Exception {
        final String PASSWORD = "abcdefg12345";
        final String BAD_PASSWORD = "12345abcdefg";

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        final String encoded = encoder.encode(PASSWORD);
        System.out.println(encoded);
        assertThat(encoded, is(not(nullValue())));
        assertThat(encoded.isEmpty(), is(not(true)));

        assertThat(encoder.matches(BAD_PASSWORD, encoded), is(false));
        assertThat(encoder.matches(PASSWORD, encoded), is(true));

    }
}
