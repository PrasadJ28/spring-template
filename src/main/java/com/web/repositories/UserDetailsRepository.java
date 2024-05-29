package com.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.entities.UserDetails;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Long>{
	
	UserDetails findByUserId(Long id);

}
