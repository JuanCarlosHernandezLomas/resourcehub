package com.resourcehub.resourcehub.mapper;



import com.resourcehub.resourcehub.dto.response.SkillDTO;
import com.resourcehub.resourcehub.entity.Skill;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SkillMapper {
    SkillMapper INSTANCE = Mappers.getMapper(SkillMapper.class);
    SkillDTO toDTO(Skill skill);
}
