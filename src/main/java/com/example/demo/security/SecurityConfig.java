package com.example.demo.security;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity(securedEnabled = true)
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig {

    private JwtAuthFilter jwtF;


    private final AuthenticationProvider authenticationProvider;


    @Autowired
    public SecurityConfig(JwtAuthFilter jwtF, AuthenticationProvider authenticationProvider) {
        this.jwtF = jwtF;
        this.authenticationProvider = authenticationProvider;
    }


    @Bean
    public SecurityFilterChain securityfilterChain(HttpSecurity http) throws Exception {
        System.out.println("Filtrage securite");
        return http
                .cors(withDefaults())
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(
                        requests -> requests
                                .requestMatchers("/auth/login","/auth/register").permitAll()
                                .requestMatchers("/User/**").hasAuthority("USER")
                                .requestMatchers("/Admin/****").hasAuthority("ADMIN")
                                .anyRequest().authenticated()
                )
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtF, UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling(e ->
                        e.accessDeniedHandler((request, response, accessDeniedException) -> response.setStatus(403))
                                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED  )))
                .build();
    }

}
