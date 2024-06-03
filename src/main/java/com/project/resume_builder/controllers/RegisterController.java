package com.project.resume_builder.controllers;
import com.project.resume_builder.models.User;
import com.project.resume_builder.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class RegisterController {

    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String showRegistrationForm() {
        return "register";
    }

    @PostMapping("/register")
    public ModelAndView registerUser(@RequestParam("username") String username,
                                     @RequestParam("password") String password) {
        ModelAndView mav = new ModelAndView();

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);


        if (userService.registerUser(user) != null) {
            mav.setViewName("login");
            mav.addObject("message", "Registration successful. Please log in.");
        } else {
            mav.setViewName("register");
            mav.addObject("message", "Registration failed. Please try again.");
        }

        return mav;
    }

}