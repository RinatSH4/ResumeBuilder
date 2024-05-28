package com.project.resume_builder.repositories;

import com.project.resume_builder.models.Role;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
   @EntityGraph(attributePaths = {"users"})
   Optional<Role> findByName(String name);
}