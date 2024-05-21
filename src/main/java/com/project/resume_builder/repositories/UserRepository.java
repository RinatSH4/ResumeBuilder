package com.project.resume_builder.repositories;

import com.project.resume_builder.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByUsername(String username);
    User findByUsername(String username);
    void deleteByUsername(String username);

    // Дополнительные методы, если необходимо
}
