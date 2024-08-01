package com.web.controller.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.config.JwtTokenProvider;
import com.web.entities.AuthResponse;
import com.web.entities.LoginRequest;

@RestController
@RequestMapping("/api/auth")
public class LoginController {
	
	/*
	 * @Autowired private AuthenticationManager authenticationManager;
	 */

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
		/*
		 * Authentication authentication = authenticationManager.authenticate( new
		 * UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
		 * loginRequest.getPassword()) );
		 * 
		 * SecurityContextHolder.getContext().setAuthentication(authentication);
		 */

        String token = jwtTokenProvider.generateToken(loginRequest.getUsername());

        return ResponseEntity.ok(new AuthResponse(token));
    }
}
