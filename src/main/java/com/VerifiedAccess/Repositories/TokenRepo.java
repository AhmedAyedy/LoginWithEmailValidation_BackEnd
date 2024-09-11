package com.VerifiedAccess.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.VerifiedAccess.Entities.Token;

public interface TokenRepo extends JpaRepository<Token, Integer> {
	Optional<Token> findByToken(String token);

}
