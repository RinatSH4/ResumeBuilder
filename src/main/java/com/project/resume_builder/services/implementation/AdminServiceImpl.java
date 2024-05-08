package com.project.resume_builder.services.implementation;

import com.project.resume_builder.config.DesignConfig;
import com.project.resume_builder.config.StepConfig;
import com.project.resume_builder.services.AdminService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {



    @Override
    public void configureSteps(List<StepConfig> stepConfigs) {
        // Реализация метода для конфигурации шагов резюме
    }

    @Override
    public void configureDesign(DesignConfig designConfig) {
        // Реализация метода для конфигурации оформления резюме
    }

    // Другие методы для настройки параметров резюме...
}
