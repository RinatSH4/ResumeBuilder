package com.project.resume_builder.repositories;

import com.project.resume_builder.models.Resume;
import com.project.resume_builder.models.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResumeRepository extends JpaRepository<Resume, Long> {
    @EntityGraph(attributePaths = {"user", "educationList", "experienceList"})
    @Query("SELECT r FROM Resume r WHERE r.user.id = :userId")
    List<Resume> findByUser(User user);
    // Дополнительные методы, если необходимо
}
