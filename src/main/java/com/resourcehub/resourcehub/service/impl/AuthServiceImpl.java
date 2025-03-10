package com.resourcehub.resourcehub.service.impl;





import com.resourcehub.resourcehub.dto.request.CreateUserDTO;
import com.resourcehub.resourcehub.dto.response.JwtResponse;
import com.resourcehub.resourcehub.dto.response.LoginRequest;
import com.resourcehub.resourcehub.dto.response.UserDTO;
import com.resourcehub.resourcehub.entity.Role;
import com.resourcehub.resourcehub.entity.User;
import com.resourcehub.resourcehub.mapper.UserMapper;
import com.resourcehub.resourcehub.repository.RoleRepository;
import com.resourcehub.resourcehub.repository.UserRepository;

import com.resourcehub.resourcehub.security.JwtUtil;
import com.resourcehub.resourcehub.service.AuthService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    public AuthServiceImpl(AuthenticationManager authenticationManager, UserRepository userRepository,
                           RoleRepository roleRepository, JwtUtil jwtUtil, PasswordEncoder passwordEncoder,
                           UserMapper userMapper) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
    }

    @Override
    public JwtResponse login(LoginRequest loginRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);

            User user = userRepository.findByUsername(loginRequest.getUsername())
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

            String token = jwtUtil.generateToken(user.getUsername(),
                    user.getRoles().stream().map(Role::getName).collect(Collectors.toSet()));

            return new JwtResponse(token);

        } catch (BadCredentialsException e) {
            throw new RuntimeException("Credenciales incorrectas");
        }
    }

    @Override
    public UserDTO registerUser(CreateUserDTO createUserDTO) {
        if (userRepository.existsByUsername(createUserDTO.getUsername())) {
            throw new RuntimeException("El usuario ya existe");
        }

        User user = userMapper.toEntity(createUserDTO);
        user.setPassword(passwordEncoder.encode(createUserDTO.getPassword())); // Cifrar la contraseña

        // Si no se envían roles, asigna "USER" por defecto
        Set<String> rolesSet = (createUserDTO.getRoles().isEmpty()) ? Set.of("USER") : createUserDTO.getRoles();

        Set<Role> roles = rolesSet.stream()
                .map(roleName -> roleRepository.findByName(roleName)
                        .orElseThrow(() -> new RuntimeException("Rol no encontrado: " + roleName)))
                .collect(Collectors.toSet());

        user.setRoles(roles);

        return userMapper.toDTO(userRepository.save(user));
    }
}