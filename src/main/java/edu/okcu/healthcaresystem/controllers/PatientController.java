package edu.okcu.healthcaresystem.controllers;

import edu.okcu.healthcaresystem.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PatientController {
    @Autowired
    DoctorRepository doctorRepository;

    @GetMapping("/patient")
    public String dashboardPatient(Model model, String keyword) {
        //  model.addAttribute("userTitles" , userTitleService.getUserTitles());

        if (keyword != null) {
            model.addAttribute("listDoctors", doctorRepository.findByKeyword(keyword));
        } else {
            model.addAttribute("listDoctors", doctorRepository.findAll());
        }
        return "patient/dashboard";


    }
}
