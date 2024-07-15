package com.web.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.entities.UserDetails;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {
	Optional<UserDetails> findByUsername(String username);
}

