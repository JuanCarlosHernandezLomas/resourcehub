package com.resourcehub.resourcehub.mapper;


import com.resourcehub.resourcehub.dto.response.ResourceRequestDTO;
import com.resourcehub.resourcehub.entity.ResourceRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ResourceRequestMapper {

    ResourceRequestMapper INSTANCE = Mappers.getMapper(ResourceRequestMapper.class);

    @Mapping(source = "project.id", target = "project.id")
    @Mapping(source = "project.name", target = "project.name")
    @Mapping(source = "requestedBy.id", target = "requestedBy.id")
    @Mapping(source = "requestedBy.name", target = "requestedBy.name")
    @Mapping(source = "skill.id", target = "skill.id")
    @Mapping(source = "skill.name", target = "skill.name")
    ResourceRequestDTO toDTO(ResourceRequest resourceRequest);
}
