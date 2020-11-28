package com.example.NFJuara.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/app")
public class Ping {
	
	@GetMapping("/ping")
	public Object ping() {
		return "pong";
	}
}
