package com.resourcehub.resourcehub.mapper;



import com.resourcehub.resourcehub.dto.response.AssignmentDTO;
import com.resourcehub.resourcehub.entity.Assignment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AssignmentMapper {
    AssignmentMapper INSTANCE = Mappers.getMapper(AssignmentMapper.class);

    @Mapping(source = "project.id", target = "project.id")
    @Mapping(source = "project.name", target = "project.name")
    @Mapping(source = "user.id", target = "user.id")
    @Mapping(source = "user.name", target = "user.name")
    AssignmentDTO toDTO(Assignment assignment);
}
