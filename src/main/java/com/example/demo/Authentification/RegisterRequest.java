package com.example.demo.Authentification;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    @NotEmpty(message="Name is required")
    private String name;

    @NotEmpty(message="phone is required")
    private String phone;

    @Email(message = "Email is not formatted")
    @NotEmpty(message="Email is required")
    private String email;

    @NotEmpty(message="password is required")
    @Size(min=5,message="Passwword should be 6 caracters minimum")
    private String password;
}