package com.project.resume_builder.controllers;

import com.project.resume_builder.config.DesignConfig;
import com.project.resume_builder.config.StepConfig;
import com.project.resume_builder.services.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/config/steps")
    public ResponseEntity<?> configureSteps(@RequestBody List<StepConfig> stepConfigs) {
        adminService.configureSteps(stepConfigs);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/config/design")
    public ResponseEntity<?> configureDesign(@RequestBody DesignConfig designConfig) {
        adminService.configureDesign(designConfig);
        return ResponseEntity.ok().build();
    }


}

