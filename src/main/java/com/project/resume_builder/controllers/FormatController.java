package com.project.resume_builder.controllers;

import com.project.resume_builder.models.Resume;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.project.resume_builder.services.FileGenerationService;
import com.project.resume_builder.services.ResumeService;
import org.springframework.http.HttpHeaders;



@RestController
@RequestMapping("/api/resume")
public class FormatController {
    private final ResumeService resumeService;
    private final FileGenerationService fileGenerationService;

    public FormatController(ResumeService resumeService, FileGenerationService fileGenerationService) {
        this.resumeService = resumeService;
        this.fileGenerationService = fileGenerationService;
    }

    @PostMapping("/{resumeId}/format")
    public ResponseEntity<?> chooseFormat(@PathVariable Long resumeId, @RequestParam String format) {
        Resume resume = resumeService.getResumeById(resumeId);

        if ("pdf".equalsIgnoreCase(format)) {
            byte[] pdfContent = fileGenerationService.generatePdf(resume);
            if (pdfContent != null) {
                HttpHeaders headers = new HttpHeaders();
                headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=resume.pdf");
                return ResponseEntity.ok().headers(headers).body(pdfContent);
            } else {
                return ResponseEntity.status(500).body("Error generating PDF");
            }
        }

        // Логика для других форматов
        return ResponseEntity.badRequest().body("Unsupported format: " + format);
    }
}