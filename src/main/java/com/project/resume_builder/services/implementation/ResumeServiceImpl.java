package com.project.resume_builder.services.implementation;

import com.project.resume_builder.exeptions.ResourceNotFoundException;
import com.project.resume_builder.models.Resume;
import com.project.resume_builder.models.User;
import com.project.resume_builder.repositories.ResumeRepository;
import com.project.resume_builder.services.ResumeService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ResumeServiceImpl implements ResumeService {

    private final ResumeRepository resumeRepository;

    public ResumeServiceImpl(ResumeRepository resumeRepository) {
        this.resumeRepository = resumeRepository;
    }

    @Override
    @CacheEvict(value = "resumes", key = "#resume.user.id")
    @CachePut(value = "resumes", key = "#result.id")
    public Resume createResume(User user, Resume resume) {
        resume.setUser(user);
        return resumeRepository.save(resume);
    }

    @Override
    @Cacheable(value = "resumes", key = "#resumeId")
    public Resume getResumeById(Long resumeId) {
        return resumeRepository.findById(resumeId)
                .orElseThrow(() -> new ResourceNotFoundException("Resume not found with id: " + resumeId));
    }

    @Override
    @CacheEvict(value = "resumes", key = "#resumeId")
    public void deleteResumeById(Long resumeId) {
        resumeRepository.deleteById(resumeId);
    }

    @Override
    @Cacheable(value = "resumes", key = "#user.id")
    public List<Resume> getResumesByUser(User user) {
        return resumeRepository.findByUser(user);
    }

    @Override
    @CacheEvict(value = "resumes", key = "#resumeId")
    @CachePut(value = "resumes", key = "#resumeId")
    public Resume updateResume(Long resumeId, Resume updatedResume) {
        Resume existingResume = getResumeById(resumeId);
        existingResume.setTitle(updatedResume.getTitle());
        existingResume.setContent(updatedResume.getContent());
        existingResume.setFirstName(updatedResume.getFirstName());
        existingResume.setLastName(updatedResume.getLastName());
        existingResume.setEmail(updatedResume.getEmail());
        existingResume.setPhone(updatedResume.getPhone());
        existingResume.setEducationList(updatedResume.getEducationList());
        existingResume.setExperienceList(updatedResume.getExperienceList());
        return resumeRepository.save(existingResume);
    }
}