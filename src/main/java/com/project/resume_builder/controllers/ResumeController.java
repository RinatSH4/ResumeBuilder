package com.project.resume_builder.controllers;


import com.project.resume_builder.models.Resume;
import com.project.resume_builder.models.User;
import com.project.resume_builder.services.ResumeService;
import com.project.resume_builder.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/resume")
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

    @Autowired
    private UserService userService;

    @GetMapping("/create")
    public String showCreateResumePage() {
        return "createResume"; // Имя HTML-шаблона без расширения
    }

    @PostMapping("/create")
    public ResponseEntity<Resume> createResume(@RequestParam Long userId, @RequestBody Resume resume) {
        User user = userService.getUserById(userId);
        return ResponseEntity.ok(resumeService.createResume(user, resume));
    }

    @GetMapping("/{resumeId}")
    public ResponseEntity<Resume> getResumeById(@PathVariable Long resumeId) {
        Resume resume = resumeService.getResumeById(resumeId);
        return ResponseEntity.ok(resume);
    }

    @DeleteMapping("/{resumeId}")
    public ResponseEntity<?> deleteResumeById(@PathVariable Long resumeId) {
        resumeService.deleteResumeById(resumeId);
        return ResponseEntity.ok().build();
    }
}
