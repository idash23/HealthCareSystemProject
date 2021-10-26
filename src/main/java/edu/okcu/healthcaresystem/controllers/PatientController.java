package edu.okcu.healthcaresystem.controllers;

import edu.okcu.healthcaresystem.models.Doctor;
import edu.okcu.healthcaresystem.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PatientController {
    @Autowired
    DoctorRepository doctorRepo;

    @GetMapping("/patient")
    public String dashboardPatient(Model model) {
        List<Doctor> listDoctors = doctorRepo.findAll();
        model.addAttribute("listDoctors", listDoctors);

        return "patient/dashboard";


    }
}
