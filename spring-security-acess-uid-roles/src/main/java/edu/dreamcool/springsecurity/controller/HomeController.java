package edu.dreamcool.springsecurity.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {
	@GetMapping("/")
	public String test() {
		return "home";
	}
	@GetMapping("/login")
	public String login() {
		return "fancy-login";
	}
	@GetMapping("/leaders")
	public String leadersHome() {
		return "leaders";
	}
	@GetMapping("/systems")
	public String adminsHome() {
		return "system";
	}
	@GetMapping("/acess-denaid")
	public String accessDenaid() {
		return "acess-denaid";
	}
  @RequestMapping(value = "/username", method = RequestMethod.GET)
  @ResponseBody
  public String currentUserName(Principal principal) {
     return principal.getName();
  }
}
