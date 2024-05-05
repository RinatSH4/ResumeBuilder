package com.project.resume_builder.repositories;

import com.project.resume_builder.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Дополнительные методы, если необходимо
}
