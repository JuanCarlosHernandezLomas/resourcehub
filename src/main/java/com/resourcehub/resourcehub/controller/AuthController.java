package com.resourcehub.resourcehub.controller;




import com.resourcehub.resourcehub.dto.request.CreateUserDTO;
import com.resourcehub.resourcehub.dto.response.JwtResponse;
import com.resourcehub.resourcehub.dto.response.LoginRequest;
import com.resourcehub.resourcehub.dto.response.UserDTO;
import com.resourcehub.resourcehub.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }


    @PostMapping("/register")
    public ResponseEntity<UserDTO> registerUser(@Valid @RequestBody CreateUserDTO createUserDTO) {
        return ResponseEntity.ok(authService.registerUser(createUserDTO));
    }

    // 🔹 Endpoint para iniciar sesión y obtener un token JWT
    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(authService.login(loginRequest));
    }
}
