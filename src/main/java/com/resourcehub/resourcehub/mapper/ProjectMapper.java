package com.resourcehub.resourcehub.mapper;


import com.resourcehub.resourcehub.dto.response.ProjectDTO;
import com.resourcehub.resourcehub.entity.Project;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProjectMapper {
    ProjectMapper INSTANCE = Mappers.getMapper(ProjectMapper.class);
    ProjectDTO toDTO(Project project);
}
