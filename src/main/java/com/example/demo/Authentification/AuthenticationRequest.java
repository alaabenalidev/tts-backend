package com.example.demo.Authentification;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequest {
    @NotBlank(message="password is mandotary")
    @Size(min=6,message="Passwword should be 6 caracters minimum")
    private String password;
    @Email(message = "Email is not formatted")
    @NotBlank(message="Email is mandotary")
    private String email;
    private boolean mfaEnabled;
}
