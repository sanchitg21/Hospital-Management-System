package com.example.controller;

import com.example.entity.Medicalreport;
import com.example.entity.Patient;
import com.example.entity.Room;
import com.example.entity.Staff;
import com.example.repository.MedicalreportRepository;
import com.example.repository.PatientRepository;
import com.example.repository.RoomRepository;
import com.example.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;
import javax.persistence.PostLoad;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/staff")
public class StaffController {

     @Autowired
     private StaffRepository staffRepository;

    @Autowired
    private MedicalreportRepository medicalreportRepository;
     @Autowired
     private PatientRepository patientRepository;
    @Autowired
    private RoomRepository roomRepository;


   @GetMapping("/index/{name}")
    public String dashboard(@PathVariable("name")String name , Model model){
       Staff staff = staffRepository.getStaffByName(name);
       model.addAttribute("staff", staff);
       return "DOCTOR/staff_dashboard";
   }

   //open add patient
    @GetMapping("/add-patient/{name}")
    public String openAddPatientForm( @PathVariable("name")String name ,Model model){
        Staff staff = staffRepository.getStaffByName(name);
        model.addAttribute("staff", staff);
         model.addAttribute("patient",new Patient());
       return "DOCTOR/add_patient_form";
    }

    //processing add patient form
    @PostMapping("/process-patient/{name}")
    public String processPatient(@ModelAttribute("patient") Patient patient,@PathVariable("name")String name , Model model){
       patient.setPassword("ghilodsnlhms");
       patientRepository.save(patient);
        Staff staff = staffRepository.getStaffByName(name);
        model.addAttribute("staff", staff);
         return "DOCTOR/add_patient_form";
    }

    //show all patients
    @GetMapping("/show-patients/{name}")
    public String showPatients(@PathVariable("name")String name ,Model model){
        List<Patient> patients = this.patientRepository.findAll();
        model.addAttribute("patients", patients);
        Staff staff = staffRepository.getStaffByName(name);
        model.addAttribute("staff", staff);
         return "DOCTOR/show_patients";
    }

    //view profile
    @GetMapping("/profile/{name}")
    public String showProfile(@PathVariable("name")String name , Model model){
        Staff staff = staffRepository.getStaffByName(name);
        model.addAttribute("staff", staff);
         return "DOCTOR/profile";
    }

    //show rooms
    @GetMapping("/show-rooms/{name}")
    public String showRooms( @PathVariable("name")String name ,Model model){
        List<Room> rooms = this.roomRepository.findAll();
        Staff staff = staffRepository.getStaffByName(name);
        model.addAttribute("staff", staff);
        model.addAttribute("rooms", rooms);
        return "DOCTOR/show_rooms";
    }

    //open add medical reports and bills
    @GetMapping("/add-medrepandbill/{name}")
    public String openAddMedrepAndBillForm(@PathVariable("name")String name , Model model){
        Staff staff = staffRepository.getStaffByName(name);
        model.addAttribute("staff", staff);
        model.addAttribute("medicalreport",new Medicalreport());
        return "DOCTOR/add_medrepandbill_form";
    }
Integer x=1;
    //processing add medical reports and bills form
    @PostMapping("/process-medrepandbill/{name}")
    public String processMedrepAndBill(@ModelAttribute("medicalreport") Medicalreport medicalreport,@PathVariable("name")String name , Model model){

        medicalreport.setBillno(x); x=x+1;
        medicalreportRepository.save(medicalreport);
        Staff staff = staffRepository.getStaffByName(name);
        model.addAttribute("staff", staff);
        return "DOCTOR/add_medrepandbill_form";
    }

    //show all medical reports and bills
    @GetMapping("/show-medrepsandbills/{name}")
    public String showMedrepAndBills(@PathVariable("name")String name , Model model){
        List<Medicalreport> medicalreports = this.medicalreportRepository.findAll();
        Staff staff = staffRepository.getStaffByName(name);
        model.addAttribute("staff", staff);
        model.addAttribute("medicalreports", medicalreports);
        return "DOCTOR/show_medrepsandbills";
    }

    @GetMapping("/show-patients/{sname}/deletepatient/{name}")
    public String deletePatient(@PathVariable("sname") String staffname,@PathVariable("name") String name,Model model){
        Patient patient =this.patientRepository.getPatientByName(name);

        this.patientRepository.delete(patient);
        String redirectUrl = "/staff/show-patients/" + staffname;
        return "redirect:" + redirectUrl;
    }

//    @GetMapping("/show-medrepsandbills/{sname}/deletereport/{id}")
//    public String deleteMedicalReport(@PathVariable("sname") String staffname,@PathVariable("id") Integer id,Model model){
//        List<Medicalreport> report =  this.medicalreportRepository.findMedicalreportByPatientid(id);
//
//        String redirectUrl = "/staff/show-medrepsandbills/" + staffname;
//        return "redirect:" + redirectUrl;
//    }
}
