package com.project.resume_builder.services;

import com.project.resume_builder.config.DesignConfig;
import com.project.resume_builder.config.StepConfig;

import java.util.List;

public interface AdminService {
    void configureSteps(List<StepConfig> stepConfigs);
    void configureDesign(DesignConfig designConfig);
    // Другие методы для настройки параметров резюме...
}
