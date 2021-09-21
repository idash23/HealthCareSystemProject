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

	@PostMapping(value="/login-post")
	public String loginPost(@RequestParam("username") String username, 
							@RequestParam("password") String password,
							Model model) {
		if (username.equals("demo") && password.equals("demo")) {
			return "dashboard";
		} else {
			String message = "Error logging in";
			model.addAttribute("message", message);
			return "login";
		}
	}

}
