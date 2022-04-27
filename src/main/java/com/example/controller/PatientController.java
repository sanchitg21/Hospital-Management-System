package com.example.controller;

import com.example.entity.*;
import com.example.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private MedicalreportRepository medicalreportRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private CatalogueRepository catalogueRepository;


    @RequestMapping("/index/{name}")
    public String dashboard(@PathVariable("name")String name , Model model){
        Patient patient = patientRepository.getPatientByName(name);
        model.addAttribute("patient", patient);
        return "PATIENT/patient_dashboard";
    }

    //view profile
    @GetMapping("/profile/{name}")//doubtful - to send the principal or not for the profile page
    public String showProfile(Model model,@PathVariable("name")String name ){
        Patient patient = patientRepository.getPatientByName(name);
        model.addAttribute("patient", patient);
        return "PATIENT/profile";
    }


    //show all patient's history of medical reports and bills//DOUBTFUL
    @GetMapping("/show-history/{name}")
    public String showHistory(@PathVariable("name")String name ,Model model){

        Patient patient = patientRepository.getPatientByName(name);
        Integer y=patient.getPatientid();
        List<Medicalreport> medicalreports = this.medicalreportRepository.findMedicalreportByPatientid(y);
        model.addAttribute("patient", patient);
        model.addAttribute("medicalreports", medicalreports);
        return "PATIENT/show_history";
    }

    //show rooms
    @GetMapping("/show-rooms/{name}")
    public String showRooms(Model model,@PathVariable("name")String name){
        List<Room> rooms = this.roomRepository.findAll();
        Patient patient = patientRepository.getPatientByName(name);
        model.addAttribute("patient", patient);
        model.addAttribute("rooms", rooms);
        return "PATIENT/show_rooms";
    }

    //show catalogue items
    @GetMapping("/show-catalogue/{name}")
    public String showCatalogue(Model model,@PathVariable("name")String name){
        List<Catalogue> catalogues = this.catalogueRepository.findAll();
        Patient patient = patientRepository.getPatientByName(name);
        model.addAttribute("patient", patient);
        model.addAttribute("catalogues", catalogues);
        return "PATIENT/show_catalogue";
    }

}
