package com.project.resume_builder.controllers;


import com.project.resume_builder.dto.UserRegistrationDTO;
import com.project.resume_builder.exeptions.UserAlreadyExistsException;
import com.project.resume_builder.models.User;
import com.project.resume_builder.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@Valid @RequestBody UserRegistrationDTO userDTO) {
        try {
            User newUser = new User();
            newUser.setUsername(userDTO.getUsername());
            newUser.setPassword(userDTO.getPassword());
            User createdUser = userService.registerUser(newUser);
            return ResponseEntity.ok(createdUser);
        } catch (UserAlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}