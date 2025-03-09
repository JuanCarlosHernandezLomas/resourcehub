package com.resourcehub.resourcehub.dto.response;



import com.resourcehub.resourcehub.entity.RequestStatus;
import java.time.LocalDateTime;

public class ResourceRequestDTO {

    private Long id;
    private ResourceRequestProjectDTO project;
    private ResourceRequestUserDTO requestedBy;
    private SkillDTO skill;
    private String experienceLevel;
    private RequestStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ResourceRequestDTO() {}

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ResourceRequestProjectDTO getProject() {
        return project;
    }

    public void setProject(ResourceRequestProjectDTO project) {
        this.project = project;
    }

    public ResourceRequestUserDTO getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(ResourceRequestUserDTO requestedBy) {
        this.requestedBy = requestedBy;
    }

    public SkillDTO getSkill() {
        return skill;
    }

    public void setSkill(SkillDTO skill) {
        this.skill = skill;
    }

    public String getExperienceLevel() {
        return experienceLevel;
    }

    public void setExperienceLevel(String experienceLevel) {
        this.experienceLevel = experienceLevel;
    }

    public RequestStatus getStatus() {
        return status;
    }

    public void setStatus(RequestStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
