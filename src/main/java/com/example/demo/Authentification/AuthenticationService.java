package com.example.demo.Authentification;


import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository repository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        var userRole = "USER";
        var user = User.builder()
                .name(request.getName())
                .phone(Double.parseDouble(request.getPhone())) // Convert phone to Double if needed
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.valueOf(userRole))
                .accountLocked(false)
                .enabled(true)
                .mfaEnabled(false)
                .secretKey(null)
                .build();

        User savedUser = repository.save(user);
        var claims = new HashMap<String, Object>();
        claims.put("name", savedUser.getName());

        String jwt = jwtService.generateToken(claims, savedUser);

        AuthenticationResponse authenticationResponse = new AuthenticationResponse(jwt, savedUser.getName(), savedUser.getRole(), savedUser.getId().toString(), savedUser.isMfaEnabled(),null);
        return authenticationResponse;

    }

    public AuthenticationResponse Authenticate(AuthenticationRequest request) {
        try {
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
            );

            var claims = new HashMap<String, Object>();
            var user = (User) auth.getPrincipal();

            claims.put("name", user.getName());
            String jwt = jwtService.generateToken(claims, user);

            AuthenticationResponse response = new AuthenticationResponse();
            response.setJwt(jwt);
            response.setName(user.getName());
            response.setRole(user.getRole());
            response.setId(String.valueOf(user.getId()));
            response.setMfaEnabled(user.isMfaEnabled());
            response.setToken(jwt);

            return response;
        } catch (Exception e) {
            throw new RuntimeException("Incorrect username or password", e);
        }
    }
}