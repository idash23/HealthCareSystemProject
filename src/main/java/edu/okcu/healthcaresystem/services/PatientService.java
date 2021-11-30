package edu.okcu.healthcaresystem.services;

import edu.okcu.healthcaresystem.models.*;
import edu.okcu.healthcaresystem.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService {
    @Autowired
    private PatientRepository repo;

    @Autowired
    private DocPatRepository docPatRepo;

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
            System.out.println("insert patient");
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

    public long[] getPatientID(long userID){
        long[] patID = docPatRepo.findPatientID(userID);
        return patID;
    }

    public List<Patient> findMyPatient(long[] patID) {
        List<Patient> listPatient = new ArrayList<Patient>();
        for(int i = 0; i < patID.length; i++){
            Patient patient = repo.findByUserID(patID[i]);
            listPatient.add(patient);
        }
        return listPatient;
    }

    public List<Patient> findMyPatientByKeyword(String keyword, long[] patID) {
        List<Patient> listPatient = new ArrayList<Patient>();
        for(int i = 0; i < patID.length; i++){
            Patient patient = repo.findMyPatientByKeyword(keyword, patID[i]);
            listPatient.add(patient);
        }
        return listPatient;
    }
}
