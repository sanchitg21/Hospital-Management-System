package com.example.controller;

import com.example.entity.Patient;
import com.example.entity.Staff;
import com.example.repository.PatientRepository;
import com.example.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;


@Controller
public class HomeController {
    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private PatientRepository patientRepository;

    @RequestMapping("/logout")
    public String logout(){
        return  "home";
    }


    @RequestMapping("/home")
    public String home(){
        return  "home";
    }

    //go to login/signup page for staff
    @RequestMapping("/dlogin")
    public String dlogin(){
        return  "DOCTOR/dlogin";
    }

    //go to login page for staff
    @RequestMapping("/dlog")
    public String dlog(Model model){
        model.addAttribute("staff",new Staff());
        return  "DOCTOR/dlog";
    }

    //go to signup page for staff
    @RequestMapping("/dreg")
    public String dreg(Model model ){
        model.addAttribute("staff",new Staff());
        return  "DOCTOR/dreg";
    }

    //do new registration - process the registration info
    @RequestMapping(value="/dodreg", method= RequestMethod.POST)
    public String dodreg(@ModelAttribute("staff") Staff staff,Model model){
        this.staffRepository.save(staff);
        return  "DOCTOR/dlogin";

    }

    //process the login info
    @RequestMapping(value="/dodlog", method= RequestMethod.POST)
    public String dodlog(@ModelAttribute("staff") Staff staff, Model model){
        List<Staff> staffs = staffRepository.findAll();
        for (Staff x : staffs) {
            if ((x.getName()).equals(staff.getName()) &&( (x.getPassword()).equals(staff.getPassword())) ){
                model.addAttribute("staff", staff);
                return "DOCTOR/staff_dashboard";
            }
        }
        return "DOCTOR/dlog";
    }
//////////////////////////////////////////////////////////////////////////////////////////////////

    //go to login page for admin
    @RequestMapping("/alogin")
    public String alogin(Model model){
        model.addAttribute("staff",new Staff());
        return  "ADMIN/alog";
    }

    //process the login info of admin
    @RequestMapping(value="/doalog", method= RequestMethod.POST)
    public String doalog(@ModelAttribute("staff") Staff staff, Model model){
       if(("DSNL").equals(staff.getName()) && ("1234").equals(staff.getPassword())){
           //set other values of admin dashboard also- or directly show it on the html page
          model.addAttribute("staff",staff);
           return "ADMIN/admin_dashboard";
       }
        return "ADMIN/alog";
    }

    /////////////////////////////////////////////////////////
    //go to login/signup page for patient
    @RequestMapping("/plogin")
    public String plogin(){
        return  "PATIENT/plogin";
    }

    //go to login page for patient
    @RequestMapping("/plog")
    public String plog(Model model){
        model.addAttribute("patient",new Patient());
        return  "PATIENT/plog";
    }

    //go to signup page for patient
    @RequestMapping("/preg")
    public String preg(Model model){
        model.addAttribute("patient",new Patient());
        return  "PATIENT/preg";
    }

    //do new registration - process the registration info
    @RequestMapping(value="/dopreg", method= RequestMethod.POST)
    public String dopreg(@ModelAttribute("patient") Patient patient,Model model){
        this.patientRepository.save(patient);
        return  "PATIENT/plogin";

    }

    //process the login info
    @RequestMapping(value="/doplog", method= RequestMethod.POST)
    public String doplog(@ModelAttribute("patient") Patient patient, Model model){
        List<Patient> patients = patientRepository.findAll();
        for (Patient x : patients) {
            if ((x.getName()).equals(patient.getName()) &&( (x.getPassword()).equals(patient.getPassword())) ){
                model.addAttribute("patient", patient);
                return "PATIENT/patient_dashboard";
            }
        }
        return "PATIENT/plog";
    }


}
