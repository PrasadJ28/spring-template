package com.web.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.web.util.JwtUtil;

import jakarta.servlet.http.HttpServletRequest;

@Aspect
@Component
public class SecurityAspect {
	
	 @Autowired
	    private JwtUtil jwtUtil;

	    @Autowired
	    private UserDetailsService userDetailsService;

	    @Before("execution(* com.web.controller..*(..))")
	    public void authenticateRequest() {
	        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
	        if (requestAttributes == null) {
	            throw new RuntimeException("Request attributes not found");
	        }
	        
	        HttpServletRequest request = requestAttributes.getRequest();
	        String authorizationHeader = request.getHeader("Authorization");

	        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
	            throw new RuntimeException("Missing or invalid Authorization header");
	        }

	        String token = authorizationHeader.substring(7);
	        if (!jwtUtil.validateToken(token)) {
	            throw new RuntimeException("Invalid JWT token");
	        }

	        String username = jwtUtil.getUsernameFromToken(token);
	        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
	        UsernamePasswordAuthenticationToken authenticationToken =
	                new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
	        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
	    }
}
