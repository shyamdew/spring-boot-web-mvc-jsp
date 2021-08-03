package edu.dreamcool.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {
	@GetMapping("/")
	public String test() {
		return "hello";
	}
	@GetMapping("/login")
	public String login() {
		return "fancy-login";
	}
}
