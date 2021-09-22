package edu.okcu.healthcaresystem;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/register")
	public String register() {
		return "register";
	}

	@PostMapping(value="/login-post")
	public String loginPost(@RequestParam("username") String username, 
							@RequestParam("password") String password,
							Model model) {
		if (username.equals("demo") && password.equals("demo")) {
			return "dashboard-doctor";
		} else {
			String message = "Error logging in";
			model.addAttribute("message", message);
			return "login";
		}
	}

	@PostMapping(value="/register-post")
	public String registerPost(@RequestParam("password") String password, 
							@RequestParam("cPassword") String cPassword,
							Model model) {
		if (password.equals(cPassword)) {
			return "login";
		} else {
			String message = "Passwords are not matching";
			model.addAttribute("message", message);
			return "register";
		}
	}

}
