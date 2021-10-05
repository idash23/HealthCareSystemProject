package edu.okcu.healthcaresystem;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/forget-password")
    public String forget() {
        return "forget-password";
    }

    @GetMapping("/doctor-add-patient")
    public String addPatient() {
        return "doctor-add-patient";
    }

    @GetMapping("/dashboard-doctor")
    public String dashboardDoctor() {
        return "dashboard-doctor";
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

    @PostMapping(value="/forget-post")
    public String forgetPost(@RequestParam("email") String email) {
        //check if email exist

        return "forget-password";
// logout
        @RequestMapping(value="/logout", method=RequestMethod.GET)
        public String logoutPage(HttpServletRequest request, HttpServletResponse response){
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();

            if(auth != null){
                new SecurityContextLogoutHandler().logout(request, response, auth);
            }

            return "redirect:/login";
        }
    }

}
