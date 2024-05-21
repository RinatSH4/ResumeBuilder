package com.project.resume_builder.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Resume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 100)
    private String title;

    @NotBlank
    private String content;

    @NotBlank
    @Size(max = 50)
    private String firstName;

    @NotBlank
    @Size(max = 50)
    private String lastName;

    @Email
    @NotBlank
    private String email;

    @Pattern(regexp = "^\\+?[0-9. ()-]{7,25}$", message = "Invalid phone number")
    private String phone;

    @ElementCollection
    @CollectionTable(name = "resume_education", joinColumns = @JoinColumn(name = "resume_id"))
    private List<Education> educationList;

    @ElementCollection
    @CollectionTable(name = "resume_experience", joinColumns = @JoinColumn(name = "resume_id"))
    private List<Experience> experienceList;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}