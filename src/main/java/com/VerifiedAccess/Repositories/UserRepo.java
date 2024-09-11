package com.VerifiedAccess.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.VerifiedAccess.Entities.user;

public interface UserRepo extends JpaRepository<user, Integer> {
	Optional<user> findByEmail(String email);
}
