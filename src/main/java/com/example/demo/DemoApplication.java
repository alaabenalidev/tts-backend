package com.example.demo;

import com.example.demo.security.auth.AuthenticationService;
import com.example.demo.security.auth.RegisterRequest;
import com.example.demo.security.user.Role;
import com.example.demo.security.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)

public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			AuthenticationService service,
			UserRepository userRepository
	) {
		return args -> {
			if(!userRepository.existsUserByEmail("admin@mail.com")){

				var admin = RegisterRequest.builder()
						.name("Admin")
						.email("admin@mail.com")
						.password("password")
						.role(Role.ADMIN)
						.build();
				service.register(admin);
			}

			if(!userRepository.existsUserByEmail("superadmin@mail.com")){

				var superadmin = RegisterRequest.builder()
						.name("Admin")
						.email("superadmin@mail.com")
						.password("password")
						.role(Role.SUPERADMIN)
						.build();
				service.register(superadmin);
			}

		};
	}

}
