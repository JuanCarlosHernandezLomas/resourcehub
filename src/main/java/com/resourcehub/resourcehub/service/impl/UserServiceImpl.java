package com.resourcehub.resourcehub.service.impl;

import com.resourcehub.resourcehub.dto.request.CreateUserDTO;
import com.resourcehub.resourcehub.dto.response.UserDTO;
import com.resourcehub.resourcehub.entity.User;
import com.resourcehub.resourcehub.mapper.UserMapper;
import com.resourcehub.resourcehub.repository.UserRepository;
import com.resourcehub.resourcehub.service.UserService;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDTO createUser(CreateUserDTO userDTO) {
        User user = userMapper.toEntity(userDTO);
        return userMapper.toDTO(userRepository.save(user));
    }

    @Override
    public List<UserDTO> getAllUsers() {
        logger.info("Buscando todos los usuarios...");
        List<User> users = userRepository.findAll();
        logger.info("Usuarios encontrados: {}", users.size());

        return users.stream()
                .map(user -> {
                    logger.info("Mapeando usuario: {}", user.getName());
                    return userMapper.toDTO(user);
                })
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserById(Long id) {
        return userRepository.findById(id)
                .map(userMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    @Override
    public UserDTO updateUser(Long id, CreateUserDTO userDTO) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        user.setName(userDTO.getName());
        user.setJobTitle(userDTO.getJobTitle());
        user.setExperienceLevel(userDTO.getExperienceLevel());
        user.setAvailabilityStatus(userDTO.getAvailabilityStatus());
        user.setLocation(userDTO.getLocation());

        return userMapper.toDTO(userRepository.save(user));
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
