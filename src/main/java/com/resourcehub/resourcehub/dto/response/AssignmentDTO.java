package com.resourcehub.resourcehub.dto.response;



import com.resourcehub.resourcehub.entity.AssignmentStatus;
import java.time.LocalDate;

public class AssignmentDTO {
    private Long id;
    private ProjectDTO project;
    private UserDTO user;
    private LocalDate startDate;
    private LocalDate endDate;
    private AssignmentStatus status;

    public AssignmentDTO() {}

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProjectDTO getProject() {
        return project;
    }

    public void setProject(ProjectDTO project) {
        this.project = project;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public AssignmentStatus getStatus() {
        return status;
    }

    public void setStatus(AssignmentStatus status) {
        this.status = status;
    }
}
