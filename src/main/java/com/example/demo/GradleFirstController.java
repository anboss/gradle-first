package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GradleFirstController {
	
	@RequestMapping("/greeting")
	public @ResponseBody String greeting() {
		String password="test";
		String sql = "SELECT * FROM users WHERE username='' AND password='" + password + "'";
		return "Hello from gradle first" + password;
	}
}
