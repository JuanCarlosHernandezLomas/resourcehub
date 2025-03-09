package com.resourcehub.resourcehub.mapper;



import com.resourcehub.resourcehub.dto.request.CreateUserDTO;
import com.resourcehub.resourcehub.dto.response.UserDTO;
import com.resourcehub.resourcehub.dto.response.ResourceRequestUserDTO;
import com.resourcehub.resourcehub.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    // Convierte una entidad User en un GeneralUserDTO
    @Mapping(source = "experienceLevel", target = "experienceLevel")
    @Mapping(source = "availabilityStatus", target = "availabilityStatus")
    UserDTO toDTO(User user);

    // Convierte una entidad User en un ResourceRequestUserDTO
    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    ResourceRequestUserDTO toResourceRequestUserDTO(User user);

    // Convierte un DTO GeneralUserDTO a una entidad User
    @Mapping(target = "id", ignore = true)
    @Mapping(source = "experienceLevel", target = "experienceLevel")
    @Mapping(source = "availabilityStatus", target = "availabilityStatus")
    User toEntity(CreateUserDTO userDTO);
}
