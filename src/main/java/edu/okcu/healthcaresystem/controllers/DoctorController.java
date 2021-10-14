package edu.okcu.healthcaresystem.controllers;

import edu.okcu.healthcaresystem.models.Patient;
import edu.okcu.healthcaresystem.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DoctorController {

    @Autowired
    PatientRepository patientRepo;

    @GetMapping("/doctor")
    public String dashboardDoctor(Model model) {
        List<Patient> listPatients = patientRepo.findAll();
        model.addAttribute("listPatients", listPatients);

        return "doctor/dashboard";
    }
}
