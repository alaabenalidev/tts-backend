package com.example.demo.Authentification;

import com.example.demo.entity.Role;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class AuthenticationResponse {
    private String jwt;
    private String name;
    private Role role;
    private String  id;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private boolean mfaEnabled;
    private String token;

}
