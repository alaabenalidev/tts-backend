package com.example.demo.security.auth;

import lombok.*;
import com.example.demo.security.user.Role;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RegisterRequest {

  private String name;
  private String email;
  private String address;
  private String phoneNumber;
  private String password;
  private Role role;
}
