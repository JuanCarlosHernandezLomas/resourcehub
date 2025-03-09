package com.resourcehub.resourcehub.service;

import com.resourcehub.resourcehub.dto.request.CreateSkillDTO;
import com.resourcehub.resourcehub.dto.response.SkillDTO;
import java.util.List;

public interface SkillService {
    SkillDTO createSkill(CreateSkillDTO skillDTO);
    List<SkillDTO> getAllSkills();
}
