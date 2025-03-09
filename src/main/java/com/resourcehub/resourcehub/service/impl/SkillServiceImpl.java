package com.resourcehub.resourcehub.service.impl;



import com.resourcehub.resourcehub.dto.request.CreateSkillDTO;
import com.resourcehub.resourcehub.dto.response.SkillDTO;
import com.resourcehub.resourcehub.entity.Skill;
import com.resourcehub.resourcehub.mapper.SkillMapper;
import com.resourcehub.resourcehub.repository.SkillRepository;
import com.resourcehub.resourcehub.service.SkillService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SkillServiceImpl implements SkillService {

    private final SkillRepository skillRepository;
    private final SkillMapper skillMapper;

    public SkillServiceImpl(SkillRepository skillRepository, SkillMapper skillMapper) {
        this.skillRepository = skillRepository;
        this.skillMapper = skillMapper;
    }

    @Override
    public SkillDTO createSkill(CreateSkillDTO skillDTO) {
        Skill skill = new Skill();
        skill.setName(skillDTO.getName());
        return skillMapper.toDTO(skillRepository.save(skill));
    }

    @Override
    public List<SkillDTO> getAllSkills() {
        return skillRepository.findAll().stream()
                .map(skillMapper::toDTO)
                .collect(Collectors.toList());
    }
}
