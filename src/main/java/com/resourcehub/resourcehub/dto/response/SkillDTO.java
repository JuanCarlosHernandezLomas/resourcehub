package com.resourcehub.resourcehub.dto.response;



public class SkillDTO {
    private Long id;
    private String name;

    public SkillDTO() {}

    public SkillDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
