package edu.okcu.healthcaresystem.controllers;

import edu.okcu.healthcaresystem.models.Patient;
import edu.okcu.healthcaresystem.models.User;
import edu.okcu.healthcaresystem.repository.PatientRepository;
import edu.okcu.healthcaresystem.repository.UserRepository;
import edu.okcu.healthcaresystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;


@Controller
public class UserController {

//    @Autowired
//    SignupValidator signupValidator;

    @Autowired
    UserService userService;
    UserRepository userRepo;
    PatientRepository patientRepo;

    @GetMapping("/")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "user/login";
    }

    @PostMapping("/process_login")
    public String login(@ModelAttribute("user") User user ) {
        User authUser = userService.login(user.getEmail(), user.getPassword());

        System.out.print(authUser);
        System.out.println(" *** user type: " + userService.userType(user.getEmail()));
        if (Objects.nonNull(authUser)) {
            String path = "redirect:/";
            if(userService.userType(user.getEmail()).equals("doctor")){
                path += "doctor";
            } else if(userService.userType(user.getEmail()).equals("patient")){
                path += "patient";
            }//else if
            return path;
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/user/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "user/register";
    }

    @GetMapping("/user/forget")
    public String forget(Model model) {
        var message = "";
        model.addAttribute("message", message);
        return "user/forget-password";
    }

    @GetMapping("/doctor-add-patient")
    public String addPatient() {
        return "doctor-add-patient";
    }

    @PostMapping(value="/user/register-post")
    public String registerPost(User user) {
        userRepo.save(user);
        var email = user.getEmail();
        Patient p = new Patient();
        p.setEmail(email);
        patientRepo.save(p);
        return "doctor/dashboard";
    }

    @PostMapping(value="/forget-post")
    public String forgetPost(@RequestParam("email") String email, Model model) {
        //check if email exist

        var message = "";
        model.addAttribute("message", message);

        return "forget-password";
    }
/*
    @PostMapping(value="/add-patient-post")
    public String addPatientPost(@RequestParam("email") String email,@RequestParam("height") String height,
                                 @RequestParam("weigth") String weight,@RequestParam("vision") String vision,
                                 @RequestParam("bloodPress") String bloodPress,@RequestParam("pulseRate") String pulseRate,
                                 @RequestParam("chickenpox") String chickenpox,@RequestParam("diphtheria") String diphtheria,
                                 @RequestParam("flu") String flu,@RequestParam("hepatitisA") String hepatitisA,
                                 @RequestParam("hepatitisB") String hepatitisB,@RequestParam("mmr") String mmr,
                                 @RequestParam("tetanus") String tetanus,@RequestParam("polio") String polio,
                                 @RequestParam("surgery") String surgery,@RequestParam("insurance") String insurance) {
        myDB database = new myDB();
        database.addPatientInfo(email, height, weight, vision, bloodPress, pulseRate, chickenpox, diphtheria, flu, hepatitisA,
                hepatitisB, mmr, tetanus, polio, surgery, insurance);
        return "doctor-add-patient";
    }

    @PostMapping(value="/search-patient-post")
    public String searchPatient(@RequestParam("toSearch") String toSearch) {
        myDB database = new myDB();
        database.search(toSearch);
        return "dashboard-doctor";
    }

        @RequestMapping(value="/logout", method= RequestMethod.GET)
        public String logoutPage(HttpServletRequest HttpServletRequest request;
        request, HttpServletResponse HttpServletResponse response;
        {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();

            if(auth != null){
                new SecurityContextLogoutHandler().logout(request, response, auth);
            }

            return "login";
        }
    }

    @RequestMapping(value="/list", method=RequestMethod.GET)
    public ModelAndView list(){
        ModelAndView model = new ModelAndView("user/list");
        model.addObject("list", userService.list());

        return model;
    }

    @RequestMapping(value="/changePass/{username}", method=RequestMethod.GET)
    public ModelAndView changePass(@PathVariable("username") String username){
        ModelAndView model = new ModelAndView("user/change_pass");
        model.addObject("user", userService.findUserByUsername(username));

        return model;
    }

    @RequestMapping(value="/save", method=RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("user") UserInfo user){
        ModelAndView model = changePass(user.getUsername());
        userService.update(user.getUsername(), user.getPassword());
        model.addObject("msg", "Your password has been changed successfully!");

        return model;
    }

    @RequestMapping(value="/signup", method=RequestMethod.GET)
    public ModelAndView signup(){
        ModelAndView model = new ModelAndView("user/signup");
        model.addObject("userForm", new UserForm());

        return model;
    }

    @RequestMapping(value="/register", method=RequestMethod.POST)
    public String register(@ModelAttribute("userForm") UserForm userForm,
                           BindingResult result, RedirectAttributes redirectAttributes){

        signupValidator.validate(userForm, result);

        if(result.hasErrors()){
            return "/user/signup";
        } else {
            userService.add(userForm.getUsername(), userForm.getPassword());
            redirectAttributes.addFlashAttribute("msg", "Your account has been created successfully!");

            return "redirect:/login";
        }
    }

     */

}