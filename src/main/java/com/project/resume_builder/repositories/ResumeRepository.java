package com.project.resume_builder.repositories;

import com.project.resume_builder.models.Resume;
import com.project.resume_builder.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResumeRepository extends JpaRepository<Resume, Long> {
    List<Resume> findByUser(User user);
    // Дополнительные методы, если необходимо
}
