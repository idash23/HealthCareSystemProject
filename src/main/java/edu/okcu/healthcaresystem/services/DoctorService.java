package edu.okcu.healthcaresystem.services;

import edu.okcu.healthcaresystem.models.Doctor;
import edu.okcu.healthcaresystem.models.Person;
import edu.okcu.healthcaresystem.models.User;
import edu.okcu.healthcaresystem.repository.DoctorRepository;
import edu.okcu.healthcaresystem.repository.PersonRepository;
import edu.okcu.healthcaresystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import  java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private UserRepository userRepository;

    //return list of doctors
    public List<Doctor> getDoctors(){
        return doctorRepository.findAll();
    }

    // get by id
    public Optional<Doctor> findById(long id) {
        return doctorRepository.findById(id);
    }

    //get doctors by keyword
    /*public List<Doctor> findByKeyword(String keyword){
        return doctorRepository.findByKeyword(keyword);
    }*/

    public List<Doctor> findAllByID() {
        List<Long> listID = userRepository.findDoctorID();
        List<Doctor> listDoc = new ArrayList<Doctor>();;
        for(int i =0; i < listID.size(); i++){
            Doctor d = new Doctor();
            User r = userRepository.findByUserID(listID.get(i));
            Person p = personRepository.findByUserID(listID.get(i));
            d.setUserID(listID.get(i));
            d.setfName(p.getfName());
            d.setlName(p.getlName());
            d.setEmail(r.getEmail());
            System.out.println(listID.get(i));
            listDoc.add(d);
        }
        return listDoc;
    }

    public List<Doctor> findByKeyword(String keyword) {
        List<Long> listID = userRepository.findDoctorID();
        List<Doctor> listDoc = new ArrayList<Doctor>();;
        for(int i =0; i < listID.size(); i++){
            Doctor d = new Doctor();
            User r = userRepository.findByUserID(listID.get(i));
            Person p = personRepository.findByUserID(listID.get(i));
            if((p.getfName().toLowerCase().contains(keyword.toLowerCase())) || (p.getlName().toLowerCase().contains(keyword.toLowerCase()))
                    || (r.getEmail().toLowerCase().contains(keyword.toLowerCase()))) {
                d.setUserID(listID.get(i));
                d.setfName(p.getfName());
                d.setlName(p.getlName());
                d.setEmail(r.getEmail());
                System.out.println(listID.get(i));
                listDoc.add(d);
            }
        }
        return listDoc;
    }
}
