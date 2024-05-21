package com.project.resume_builder.controllers;


import com.project.resume_builder.models.Resume;
import com.project.resume_builder.models.User;
import com.project.resume_builder.services.ResumeService;
import com.project.resume_builder.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/resume")
public class ResumeController {

    private final ResumeService resumeService;

    private final UserService userService;

    public ResumeController(ResumeService resumeService, UserService userService) {
        this.resumeService = resumeService;
        this.userService = userService;
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

    @PutMapping("/{resumeId}")
    public ResponseEntity<Resume> updateResume(@PathVariable Long resumeId, @RequestBody Resume resume) {
        return ResponseEntity.ok(resumeService.updateResume(resumeId, resume));
    }
}
