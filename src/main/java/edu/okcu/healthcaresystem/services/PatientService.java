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

    public void insertVisit(Visit visit, Long userID) {
        Visit v = new Visit();
        v.setUserID(userID);
        v.setReason(visit.getReason());
        v.setDate(visit.getDate());
        v.setNote(visit.getNote());
        visitRepo.save(v);
    }

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

    public void insertVital(Vital vital, Long userID) {
        System.out.println("vital method");
        Vital v = new Vital();
        v.setUserID(userID);
        v.setDate(vital.getDate());
        v.setHeight(vital.getHeight());
        v.setWeight(vital.getWeight());
        v.setBloodPress(vital.getBloodPress());
        v.setTemp(vital.getTemp());
        vitalRepo.save(v);
    }

    public void insertVacs(Vaccination vaccination, Long userID) {
        Vaccination v = new Vaccination();
        v.setUserID(userID);
        v.setName(vaccination.getName());
        v.setDate(vaccination.getDate());
        vacsRepo.save(v);
    }
}
