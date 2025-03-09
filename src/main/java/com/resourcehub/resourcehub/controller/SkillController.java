package com.resourcehub.resourcehub.controller;



import com.resourcehub.resourcehub.dto.request.CreateSkillDTO;
import com.resourcehub.resourcehub.dto.response.SkillDTO;
import com.resourcehub.resourcehub.service.SkillService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skills")
public class SkillController {

    private final SkillService skillService;

    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @PostMapping
    public ResponseEntity<SkillDTO> createSkill(@Valid @RequestBody CreateSkillDTO skillDTO) {
        return ResponseEntity.ok(skillService.createSkill(skillDTO));
    }

    @GetMapping
    public ResponseEntity<List<SkillDTO>> getAllSkills() {
        return ResponseEntity.ok(skillService.getAllSkills());
    }
}
