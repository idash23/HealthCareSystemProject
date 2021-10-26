package edu.okcu.healthcaresystem.controllers;

import edu.okcu.healthcaresystem.models.Doctor;
import edu.okcu.healthcaresystem.models.Patient;
import edu.okcu.healthcaresystem.repository.DoctorRepository;
import edu.okcu.healthcaresystem.repository.PatientRepository;
import edu.okcu.healthcaresystem.services.DoctorService;
import edu.okcu.healthcaresystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DoctorController {

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    private DoctorService doctorService;

/*
    @GetMapping("/doctor")
    public String dashboardDoctor(Model model, String keyword) {
        List<Doctor> listDoctors = doctorRepository.findAll();
        model.addAttribute("listDoctors", listDoctors);

        if (keyword != null) {
            model.addAttribute("doctors", doctorService.findByKeyword(keyword));
        } else {
            model.addAttribute("doctors", doctorService.getDoctors());
        }

        return "doctor/DoctorsSearch";

    }
}
*/


    @GetMapping("/doctor")
    public String getDoctors(Model model, String keyword) {

        //  model.addAttribute("userTitles" , userTitleService.getUserTitles());

        if (keyword != null) {
            model.addAttribute("doctors", doctorService.findByKeyword(keyword));
        } else {
            model.addAttribute("doctors", doctorService.getDoctors());
        }
        return "doctor/DoctorsSearch";
    }
}



