package edu.okcu.healthcaresystem.services;

import edu.okcu.healthcaresystem.models.*;
import edu.okcu.healthcaresystem.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    @Autowired
    private PatientRepository repo;

    @Autowired
    private PersonRepository personRepo;

    @Autowired
    private VisitRepository visitRepo;

    @Autowired
    private VitalRepository vitalRepo;

    @Autowired
    private VaccinationRepository vacsRepo;

    public void updatePerson(Patient patient){
        personRepo.updatePerson(patient.getfName(), patient.getlName(), patient.getPhoneNumber(), patient.getAddress(),  patient.getUserID());

    }

    public void updatePatient(Patient patient){
        if(repo.findByUserID(patient.getUserID())==null){
            repo.insert(patient.getUserID(), patient.getDOB(), patient.getGender(), patient.getAllergies(), patient.getInsuranceInfo());
        }else{
            repo.updatePatient(patient.getDOB(), patient.getGender(), patient.getAllergies(), patient.getInsuranceInfo(), patient.getUserID());
        }
    }

    public String getFirstAndLast(long userID){
        System.out.println(userID);
        Person p = personRepo.findByUserID(userID);
        String fAndL = p.getfName() + " " + p.getlName();
        return fAndL;
    }

    public void insertVisit(Visit visit) {
        visitRepo.save(visit);
    }

    public void insertVital(Vital vital) {
        vitalRepo.save(vital);
    }

    public void insertVacs(Vaccination vaccination) {
        vacsRepo.save(vaccination);
    }
}
