package com.resourcehub.resourcehub.dto.request;



import jakarta.validation.constraints.NotBlank;

public class CreateSkillDTO {

    @NotBlank(message = "El nombre de la habilidad es obligatorio")
    private String name;

    public CreateSkillDTO() {}

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}

