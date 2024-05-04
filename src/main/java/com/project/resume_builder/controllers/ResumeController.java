package com.project.resume_builder.controllers;


import com.project.resume_builder.models.Resume;
import com.project.resume_builder.services.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/resumes")
public class ResumeController {
    @Autowired
    private ResumeService resumeService;

    @PostMapping("/create")
    public Resume createResume(@RequestBody Resume resume) {
        return resumeService.createResume(resume);
    }

    // Другие методы контроллера
}
