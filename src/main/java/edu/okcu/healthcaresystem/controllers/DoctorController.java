package edu.okcu.healthcaresystem.controllers;

import edu.okcu.healthcaresystem.models.Patient;
import edu.okcu.healthcaresystem.repository.DoctorRepository;
import edu.okcu.healthcaresystem.repository.PatientRepository;
import edu.okcu.healthcaresystem.services.DoctorService;
import edu.okcu.healthcaresystem.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;

@Controller
public class DoctorController {

    @Autowired
    PatientRepository patientRepository;
    DoctorRepository doctorRepository;

    @Autowired
    PatientService patientService;

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
    public String getDoctors(Model model, String keyword, String patient, long userID) {
        if(patient.equals("my")){
            long[] patID = patientService.getPatientID(userID);
            List<Patient> patientList = patientService.findMyPatient(patID);
            if (keyword != null) {
                patientList = patientService.findMyPatientByKeyword(keyword, patID);
                if(patientList.get(0) == null){
                    patientList = Collections.<Patient>emptyList();
                }
            }
            model.addAttribute("listPatients", patientList);
        }else{
            if (keyword != null) {
                model.addAttribute("listPatients", patientRepository.findByKeyword(keyword));
            } else {
                model.addAttribute("listPatients", patientRepository.findAll());
            }
        }

        return "doctor/dashboard";
    }

        }



