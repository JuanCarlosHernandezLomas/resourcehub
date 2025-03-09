package com.resourcehub.resourcehub.dto.request;


import com.resourcehub.resourcehub.entity.ExperienceLevel;
import jakarta.validation.constraints.NotNull;

public class CreateResourceRequestDTO {

    @NotNull(message = "El ID del proyecto es obligatorio")
    private Long projectId;

    @NotNull(message = "El ID del usuario solicitante es obligatorio")
    private Long requestedById;

    @NotNull(message = "El ID de la habilidad es obligatorio")
    private Long skillId;

    @NotNull(message = "El nivel de experiencia es obligatorio")
    private ExperienceLevel experienceLevel;

    public CreateResourceRequestDTO() {}

    // Getters y Setters

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getRequestedById() {
        return requestedById;
    }

    public void setRequestedById(Long requestedById) {
        this.requestedById = requestedById;
    }

    public Long getSkillId() {
        return skillId;
    }

    public void setSkillId(Long skillId) {
        this.skillId = skillId;
    }

    public ExperienceLevel getExperienceLevel() {
        return experienceLevel;
    }

    public void setExperienceLevel(ExperienceLevel experienceLevel) {
        this.experienceLevel = experienceLevel;
    }
}
