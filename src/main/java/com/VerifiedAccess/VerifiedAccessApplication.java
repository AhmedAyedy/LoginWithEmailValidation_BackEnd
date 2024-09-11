package com.VerifiedAccess;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

import com.VerifiedAccess.Entities.Role;
import com.VerifiedAccess.Repositories.RoleRepo;

@SpringBootApplication
@EnableJpaAuditing
@EnableAsync
//@EntityScan(basePackages = "com.VerifiedAccess.Entities")
public class VerifiedAccessApplication {

	public static void main(String[] args) {
		SpringApplication.run(VerifiedAccessApplication.class, args);
	}
	@Bean
	public CommandLineRunner runner(RoleRepo roleRepository) {
		return args -> {
			if (roleRepository.findByName("USER").isEmpty()) {
				roleRepository.save(Role.builder().name("USER").build());
			}
		};
	}

}
