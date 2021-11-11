package edu.okcu.healthcaresystem.controllers;

import edu.okcu.healthcaresystem.models.*;
import edu.okcu.healthcaresystem.repository.*;
import edu.okcu.healthcaresystem.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PatientController {
    @Autowired
    PersonRepository personRepo;
    @Autowired
    PatientRepository patientRepo;
    @Autowired
    PatientService patientService;
    @Autowired
    VisitRepository visitRepo;
    @Autowired
    VaccinationRepository vacRepo;
    @Autowired
    VitalRepository vitalRepo;

    @GetMapping("/patient")
    public String dashboardPatient(Model model, @RequestParam Long userID) {
        Person person = new Person();
        person = personRepo.findByUserID(userID);
        Patient p = patientRepo.findByUserID(userID);
        String gender = patientRepo.getGender(userID);
        String DOB = patientRepo.getDOB(userID);
        String allergies = patientRepo.getAllergies(userID);
        String insurance = patientRepo.getInsurance(userID);

        Patient patientFinal = new Patient(userID, person.getfName(), person.getlName(),
                person.getPhoneNumber(), person.getAddress(), userID,
                DOB, gender, allergies, insurance);

        model.addAttribute("patient", patientFinal);

        List<Visit> visit = visitRepo.findAllByUserID(userID);
        model.addAttribute("listVisits", visit);
        model.addAttribute("visit", new Visit());

        List<Vaccination> vac = vacRepo.findAllByUserID(userID);
        model.addAttribute("listVacs", vac);
        model.addAttribute("vacs", new Vaccination());

        List<Vital> vital = vitalRepo.findAllByUserID(userID);
        model.addAttribute("listVitals", vital);
        model.addAttribute("vital", new Vital());


        //  model.addAttribute("userTitles" , userTitleService.getUserTitles());
        /*
        if (keyword != null) {
            model.addAttribute("listDoctors", doctorRepository.findByKeyword(keyword));
        } else {
            model.addAttribute("listDoctors", doctorRepository.findAll());
        }
        */
        return "patient/dashboard";


    }
}
