package com.resourcehub.resourcehub.service;


import com.resourcehub.resourcehub.dto.request.CreateUserDTO;
import com.resourcehub.resourcehub.dto.response.UserDTO;
import java.util.List;

public interface UserService {
    UserDTO createUser(CreateUserDTO userDTO);
    List<UserDTO> getAllUsers();
    UserDTO getUserById(Long id);
    UserDTO updateUser(Long id, CreateUserDTO userDTO);
    void deleteUser(Long id);
}
