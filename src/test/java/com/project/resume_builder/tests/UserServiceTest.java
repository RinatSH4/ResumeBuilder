package com.project.resume_builder.tests;

import com.project.resume_builder.models.User;
import com.project.resume_builder.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testRegisterUser() {
        User user = new User();
        user.setUsername("testUser");
        user.setPassword("password123");

        User registeredUser = userService.registerUser(user);

        assertNotNull(registeredUser);
        assertEquals("testUser", registeredUser.getUsername());
    }

    // Другие тесты...
}
