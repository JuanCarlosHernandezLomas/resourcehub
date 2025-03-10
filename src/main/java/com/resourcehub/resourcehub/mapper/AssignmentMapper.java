package com.resourcehub.resourcehub.mapper;



import com.resourcehub.resourcehub.dto.response.AssignmentDTO;
import com.resourcehub.resourcehub.entity.Assignment;
import com.resourcehub.resourcehub.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface AssignmentMapper {
    AssignmentMapper INSTANCE = Mappers.getMapper(AssignmentMapper.class);

    @Mapping(source = "project.id", target = "project.id")
    @Mapping(source = "project.name", target = "project.name")
    @Mapping(source = "user.id", target = "user.id")
    @Mapping(source = "user.name", target = "user.name")
    @Mapping(source = "user.roles", target = "user.roles", qualifiedByName = "mapRolesToSet")
    AssignmentDTO toDTO(Assignment assignment);
    @Named("mapRolesToSet")
    static Set<String> mapRolesToSet(Set<Role> roles) {
        if (roles == null) {
            return Set.of(); // 🔹 Evita errores de null
        }
        return roles.stream().map(Role::getName).collect(Collectors.toSet());
    }
}
