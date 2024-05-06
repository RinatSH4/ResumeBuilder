package com.project.resume_builder.repositories;

import com.project.resume_builder.models.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResumeRepository extends JpaRepository<Resume, Long> {
    // Дополнительные методы, если необходимо
}
