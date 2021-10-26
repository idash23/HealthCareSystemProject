package edu.okcu.healthcaresystem.services;

import edu.okcu.healthcaresystem.models.Doctor;
import edu.okcu.healthcaresystem.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import  java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    //return list of doctors
    public List<Doctor> getDoctors(){
        return doctorRepository.findAll();
    }

    // get by id
    public Optional<Doctor> findById(long id) {
        return doctorRepository.findById(id);
    }

    //get doctors by keyword
    public List<Doctor> findByKeyword(String keyword){
        return doctorRepository.findByKeyword(keyword);
    }

}
