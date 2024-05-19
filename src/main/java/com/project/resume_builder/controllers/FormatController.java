package com.project.resume_builder.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/resume")
public class FormatController {

    @PostMapping("/{resumeId}/format")
    public ResponseEntity<?> chooseFormat(@PathVariable Long resumeId, @RequestParam String format) {
        // Логика для обработки выбора формата и сохранения резюме
        return ResponseEntity.ok().build();
    }
}