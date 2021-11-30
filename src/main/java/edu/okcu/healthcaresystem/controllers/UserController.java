package edu.okcu.healthcaresystem.controllers;

import edu.okcu.healthcaresystem.models.*;
import edu.okcu.healthcaresystem.repository.DoctorRepository;
import edu.okcu.healthcaresystem.repository.PersonRepository;
import edu.okcu.healthcaresystem.repository.UserRepository;
import edu.okcu.healthcaresystem.services.DoctorService;
import edu.okcu.healthcaresystem.services.PatientService;
import edu.okcu.healthcaresystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;


@Controller
public class UserController {

//    @Autowired
//    SignupValidator signupValidator;

    @Autowired
    UserService userService;
    UserRepository userRepository;

    @Autowired
    PatientService patientService;

    @Autowired
    DoctorService doctorService;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    DoctorRepository doctorRepository;
    private String password;

    @GetMapping("/")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "user/login";
    }

    @PostMapping("/process_login")
    public String login(@ModelAttribute("user") User user) {
        User authUser = userService.login(user.getEmail(), user.getPassword());
        if (Objects.nonNull(authUser)) {
            String Patient ="";
            if(authUser.getPersonType().equals("doctor")){
                Patient = "&patient=all";
            }
            return "redirect:/" + userService.userTypeByEmail(user.getEmail()) + "?userID=" + authUser.getUserID() + Patient;
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/user/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        //BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        //this.password = passwordEncoder.encode(password);
        return "user/register";
    }

    @PostMapping(value = "/patient/save-patient/{userID}")
    public String savePatient(Model model, Patient patient, @PathVariable Long userID) {
        patientService.updatePerson(patient);

        if(!(patient.getDOB().isEmpty()) && !(patient.getGender().isEmpty()) && !(patient.getAllergies().isEmpty())
                && !(patient.getInsuranceInfo().isEmpty())){
            patientService.updatePatient(patient);
        }

        return "redirect:/patient?userID="+userID;
    }

    @PostMapping(value = "/patient/save-vital/{userID}")
    public String saveVital(Vital vital, @PathVariable Long userID) {
        String modify = userService.userTypeByID(userID) + " " + patientService.getFirstAndLast(userID);
        vital.setModifyBy(modify);
        patientService.insertVital(vital);

        return "redirect:/patient?userID="+userID;
    }

    @PostMapping(value = "/patient/save-vacs/{userID}")
    public String saveVisit(Vaccination vaccination, @PathVariable Long userID) {
        String modify = userService.userTypeByID(userID) + " " + patientService.getFirstAndLast(userID);
        vaccination.setModifyBy(modify);
        patientService.insertVacs(vaccination);

        return "redirect:/patient?userID="+userID;
    }

    @PostMapping(value = "/patient/save-visit/{userID}")
    public String saveVisit(Visit visit, @PathVariable Long userID) {
        String modify = userService.userTypeByID(userID) + " " + patientService.getFirstAndLast(userID);
        visit.setModifyBy(modify);
        patientService.insertVisit(visit);

        return "redirect:/patient?userID="+userID;
    }

    @GetMapping("/doctor/add-patient-info")
    public String addInfo(Model model, Long patID){
        Person p = personRepository.findByUserID(patID);
        model.addAttribute("person", p);
        model.addAttribute("visit", new Visit());
        model.addAttribute("vacs", new Vaccination());
        model.addAttribute("vital", new Vital());
        return "doctor/add-patient-info";
    }

    @PostMapping(value = "/doctor/save-visit")
    public String saveVisitDoc(Visit visit, Long userID, Long patID) {
        String modify = userService.userTypeByID(userID) + " " + patientService.getFirstAndLast(userID);
        visit.setModifyBy(modify);
        visit.setUserID(patID);
        patientService.insertVisit(visit);

        return "redirect:/doctor?userID="+userID+"&patient=all";
    }

    @PostMapping(value = "/doctor/save-vacs")
    public String saveVisitDoc(Vaccination vacs, Long userID, Long patID) {
        String modify = userService.userTypeByID(userID) + " " + patientService.getFirstAndLast(userID);
        vacs.setModifyBy(modify);
        vacs.setUserID(patID);
        patientService.insertVacs(vacs);

        return "redirect:/doctor?userID="+userID+"&patient=all";
    }

    @PostMapping(value = "/doctor/save-vital")
    public String saveVitalDoc(Vital vital, Long userID, Long patID) {
        String modify = userService.userTypeByID(userID) + " " + patientService.getFirstAndLast(userID);
        vital.setModifyBy(modify);
        vital.setUserID(patID);
        patientService.insertVital(vital);

        return "redirect:/doctor?userID="+userID+"&patient=all";
    }

    @GetMapping("/patient/search-doctor")
    public String searchDoctor(Model model, String keyword, Long userID) {
        if (keyword != null) {
            model.addAttribute("listDoctors", doctorService.findByKeyword(keyword));
        } else {
            model.addAttribute("listDoctors", doctorService.findAllByID());
        }
        return "patient/search-doctor";
    }

    @PostMapping("/patient/search-doctor")
    public String postDoctor(Model model, String keyword, Long userID) {
        if (keyword != null) {
            model.addAttribute("listDoctors", doctorService.findByKeyword(keyword));
        } else {
            model.addAttribute("listDoctors", doctorService.findAllByID());
        }
        return "redirect:/patient/search-doctor?keyword="+keyword+"&userID="+userID;
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

    @PostMapping(value = "/user/register-post")
    public String registerPost(User user) {
        userService.save(user);

        Person person = new Person();
        person.setUserID(userService.userID(user.getEmail()));
        userService.savePerson(person);

        return "redirect:/user/detail-info/person?userID="+person.getUserID();
    }

    @GetMapping("/user/detail-info/person")
    public String doctorInfo(@ModelAttribute("person") Person person, @RequestParam Long userID) {
        person.setUserID(userID);
        return "user/detail-info/person";
    }

    @PostMapping(value="/user/detail-info/person_post/{userID}")
    public String doctorInfoPost(Person person, @PathVariable Long userID) {
        person.setUserID(userID);
        userService.updatePerson(person);
        return "redirect:/"+ userService.userTypeByID(person.getUserID()) + "?userID="+person.getUserID();
    }

    @PostMapping(value = "/forget-post")
    public String forgetPost(@RequestParam("email") String email, Model model) {
        //check if email exist

        var message = "";
        model.addAttribute("message", message);

        return "forget-password";
    }

    // processing logout in controller

    @GetMapping("/logout")
    public String fetchSignoutSite(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }

        return "/";

    }
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

