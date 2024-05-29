package com.web.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeRestController {
	
	@GetMapping("/check")
	public Boolean returnBoolean() {
		
		return true;
	}
}
