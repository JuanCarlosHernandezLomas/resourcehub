package com.resourcehub.resourcehub.dto.request;


import com.resourcehub.resourcehub.entity.AvailabilityStatus;
import com.resourcehub.resourcehub.entity.ExperienceLevel;
import jakarta.validation.constraints.NotNull;

public class CreateUserDTO {

    @NotNull(message = "El ID del empleado es obligatorio")
    private String employeeId;

    @NotNull(message = "El nombre es obligatorio")
    private String name;

    @NotNull(message = "El puesto de trabajo es obligatorio")
    private String jobTitle;

    @NotNull(message = "El nivel de experiencia es obligatorio")
    private ExperienceLevel experienceLevel;

    @NotNull(message = "El estado de disponibilidad es obligatorio")
    private AvailabilityStatus availabilityStatus;

    @NotNull(message = "La ubicación es obligatoria")
    private String location;

    public CreateUserDTO() {}

    // Getters y Setters

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public ExperienceLevel getExperienceLevel() {
        return experienceLevel;
    }

    public void setExperienceLevel(ExperienceLevel experienceLevel) {
        this.experienceLevel = experienceLevel;
    }

    public AvailabilityStatus getAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setAvailabilityStatus(AvailabilityStatus availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
