package com.resourcehub.resourcehub.dto.request;


import com.resourcehub.resourcehub.entity.AvailabilityStatus;
import com.resourcehub.resourcehub.entity.ExperienceLevel;
import jakarta.validation.constraints.NotNull;

import java.util.HashSet;
import java.util.Set;

public class CreateUserDTO {

    private String username;
    private String password;
    private String getEmployeeId;

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
    private Set<String> roles= new HashSet<>();

    public CreateUserDTO() {
    }

    // Getters y Setters

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGetEmployeeId() {
        return getEmployeeId;
    }

    public void setGetEmployeeId(String getEmployeeId) {
        this.getEmployeeId = getEmployeeId;
    }

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

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
}
