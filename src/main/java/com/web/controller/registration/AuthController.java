package com.web.controller.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.entities.RegisterRequest;
import com.web.entities.User;
//import com.web.repositories.UserRepository;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
//	@Autowired
//    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @PostMapping("/register")
	public ResponseEntity<?> registerUser(@RequestBody RegisterRequest registerRequest){
		/*
		 * if (userRepository.existsByUsername(registerRequest.getUsername())) { return
		 * ResponseEntity.badRequest().body("Username is already taken"); }
		 */
		User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));

        //userRepository.save(user);

        return ResponseEntity.ok("User registered successfully");
	}
}
