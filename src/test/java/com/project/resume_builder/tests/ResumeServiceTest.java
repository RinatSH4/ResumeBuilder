package com.project.resume_builder.tests;

import com.project.resume_builder.models.Resume;
import com.project.resume_builder.models.User;
import com.project.resume_builder.services.ResumeService;
import com.project.resume_builder.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;


@SpringBootTest
public class ResumeServiceTest {

    @Autowired
    private ResumeService resumeService;

    @Autowired
    private UserService userService;

    private User user;

    @BeforeEach
    public void setup() {
        // Попытка найти и удалить пользователя перед регистрацией нового
        String username = "testuser";
        User existingUser = userService.findByUsername(username);
        if (existingUser != null) {
            userService.deleteUser(existingUser.getId());
        }

        // Создаем пользователя для тестов
        user = new User();
        user.setUsername(username);
        user.setPassword("testpass");
        user = userService.registerUser(user);
    }

    @Test
    public void testCreateResume() {
        Resume resume = new Resume();
        resume.setTitle("Software Developer");
        resume.setFirstName("John");
        resume.setLastName("Doe");
        resume.setEmail("john.doe@example.com");
        resume.setPhone("+1234567890");
        resume.setContent("Experienced software developer with a background in Java and Spring Boot."); // Устанавливаем значение для поля content

        Resume createdResume = resumeService.createResume(user, resume);
        assertNotNull(createdResume);
        assertEquals("John", createdResume.getFirstName());
    }

    @Test
    public void testGetResumeById() {
        Resume resume = new Resume();
        resume.setTitle("Software Developer");
        resume.setFirstName("John");
        resume.setLastName("Doe");
        resume.setEmail("john.doe@example.com");
        resume.setPhone("+1234567890");
        resume.setContent("Experienced software developer with a background in Java and Spring Boot."); // Устанавливаем значение для поля content

        Resume createdResume = resumeService.createResume(user, resume);
        Resume foundResume = resumeService.getResumeById(createdResume.getId());
        assertNotNull(foundResume);
        assertEquals(createdResume.getId(), foundResume.getId());
    }
}
