package com.resourcehub.resourcehub.service;




import com.resourcehub.resourcehub.dto.request.CreateUserDTO;
import com.resourcehub.resourcehub.dto.response.JwtResponse;
import com.resourcehub.resourcehub.dto.response.LoginRequest;
import com.resourcehub.resourcehub.dto.response.UserDTO;
import com.resourcehub.resourcehub.entity.User;
import com.resourcehub.resourcehub.repository.UserRepository;
import com.resourcehub.resourcehub.security.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public interface AuthService {
JwtResponse login(LoginRequest loginRequest);
    UserDTO registerUser(CreateUserDTO createUserDTO);
}
