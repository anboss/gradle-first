package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GradleFirstController {
	
	@RequestMapping("/greeting")
	public @ResponseBody String greeting() {
		return "Hello from gradle first";
	}
}
