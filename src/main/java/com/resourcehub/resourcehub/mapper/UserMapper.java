package com.resourcehub.resourcehub.mapper;

import com.resourcehub.resourcehub.dto.request.CreateUserDTO;
import com.resourcehub.resourcehub.dto.response.ResourceRequestUserDTO;
import com.resourcehub.resourcehub.dto.response.UserDTO;
import com.resourcehub.resourcehub.entity.Role;
import com.resourcehub.resourcehub.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    // Convierte una entidad User en un UserDTO
    @Mapping(source = "roles", target = "roles", qualifiedByName = "mapRolesToSet")
    UserDTO toDTO(User user);

    // Convierte una entidad User en un ResourceRequestUserDTO
    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    ResourceRequestUserDTO toResourceRequestUserDTO(User user);

    // Convierte un DTO CreateUserDTO a una entidad User
    @Mapping(target = "id", ignore = true)
    @Mapping(source = "roles", target = "roles", ignore = true) // 🔹 Se manejará manualmente en el servicio
    User toEntity(CreateUserDTO userDTO);

    // Métodos auxiliares para convertir los enums a String y viceversa
    @Named("mapRolesToSet")
    static Set<String> mapRolesToSet(Set<Role> roles) {
        return roles.stream().map(Role::getName).collect(Collectors.toSet());
    }
}
