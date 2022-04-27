package com.example.controller;

import com.example.entity.Catalogue;
import com.example.entity.Patient;
import com.example.entity.Room;
import com.example.entity.Staff;
import com.example.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
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
    public String dashboard(Model model,@PathVariable("name")String name){
        Staff staff = staffRepository.getStaffByName(name);
        model.addAttribute("staff", staff);
        return "ADMIN/admin_dashboard";
    }

    //view profile
    @GetMapping("/profile/{name}")
    public String showProfile(@PathVariable("name")String name , Model model){
        Staff staff = staffRepository.getStaffByName(name);
        model.addAttribute("staff", staff);
        return "ADMIN/profile";
    }

    //show all patients
    @GetMapping("/show-patients/{name}")
    public String showPatients(@PathVariable("name")String name ,Model model){
        List<Patient> patients = this.patientRepository.findAll();
        model.addAttribute("patients", patients);
        Staff staff = staffRepository.getStaffByName(name);
        model.addAttribute("staff", staff);
        return "ADMIN/show_patients";
    }

    //show rooms
    @GetMapping("/show-rooms/{name}")
    public String showRooms( @PathVariable("name")String name ,Model model){
        List<Room> rooms = this.roomRepository.findAll();
        Staff staff = staffRepository.getStaffByName(name);
        model.addAttribute("staff", staff);
        model.addAttribute("rooms", rooms);
        return "ADMIN/show_rooms";
    }

    //show catalogue items
    @GetMapping("/show-catalogue/{name}")
    public String showCatalogue(Model model,@PathVariable("name")String name){
        List<Catalogue> catalogues = this.catalogueRepository.findAll();
        Staff staff = staffRepository.getStaffByName(name);
        model.addAttribute("staff", staff);
        model.addAttribute("catalogues", catalogues);
        return "ADMIN/show_catalogue";
    }
    //show all staff
    @GetMapping("/show-staff/{name}")
    public String showStaff(Model model,@PathVariable("name")String name){
        List<Staff> staffs = this.staffRepository.findAll();
        Staff staff = staffRepository.getStaffByName(name);
        model.addAttribute("staff", staff);
        model.addAttribute("staffs", staffs);
        return "ADMIN/show_staff";
    }

    //open add room
    @GetMapping("/add-room/{name}")
    public String openAddRoomForm(Model model,@PathVariable("name")String name){
        Staff staff = staffRepository.getStaffByName(name);
        model.addAttribute("staff", staff);
        model.addAttribute("room",new Room());
        return "ADMIN/add_room_form";
    }

    //processing add room form
    @PostMapping("/process-room/{name}")
    public String processRoom(@ModelAttribute("room") Room room,Model model,@PathVariable("name")String name){
        roomRepository.save(room);
        Staff staff = staffRepository.getStaffByName(name);
        model.addAttribute("staff", staff);
        return "ADMIN/add_room_form";
    }


    //open add staff
    @GetMapping("/add-staff/{name}")
    public String openAddStaffForm(Model model,@PathVariable("name")String name){
        Staff staff = staffRepository.getStaffByName(name);
        model.addAttribute("staff", staff);

        model.addAttribute("stafff",new Staff());
        return "ADMIN/add_staff_form";
    }

    //processing add staff form
    @PostMapping("/process-staff/{name}")
    public String processStaff(@ModelAttribute("stafff") Staff stafff,@PathVariable("name")String name,Model model){
        stafff.setPassword("ghilodsnlhms");
        staffRepository.save(stafff);
        Staff staff = staffRepository.getStaffByName(name);
        model.addAttribute("staff", staff);

        return "ADMIN/add_staff_form";
    }

    //open add catalogue form
    @GetMapping("/add-catalogue/{name}")
    public String openAddCatalogueForm(Model model,@PathVariable("name")String name){
        Staff staff = staffRepository.getStaffByName(name);
        model.addAttribute("staff", staff);
        model.addAttribute("catalogue",new Catalogue());
        return "ADMIN/add_catalogue_form";
    }

    //processing add catalogue form
    @PostMapping("/process-catalogue/{name}")
    public String processCatalogue(@ModelAttribute("catalogue") Catalogue catalogue,@PathVariable("name")String name,Model model){
        Staff staff = staffRepository.getStaffByName(name);
        model.addAttribute("staff", staff);
        catalogueRepository.save(catalogue);

        return "ADMIN/add_catalogue_form";
    }

    @GetMapping("/show-patients/{sname}/deletepatient/{name}")
    public String deletePatient(@PathVariable("sname") String staffname,@PathVariable("name") String name,Model model){
        Patient patient =this.patientRepository.getPatientByName(name);
        this.patientRepository.delete(patient);
        String redirectUrl = "/admin/show-patients/" + staffname;
        return "redirect:" + redirectUrl;
    }

    @GetMapping("/show-staff/{sname}/deletestaff/{name}")
    public String deleteStaff(@PathVariable("sname") String staffname,@PathVariable("name") String name,Model model){
        Staff staff =this.staffRepository.getStaffByName(name);
        this.staffRepository.delete(staff);
        String redirectUrl = "/admin/show-staff/" + staffname;
        return "redirect:" + redirectUrl;
    }

//    @GetMapping("/show-rooms/{sname}/deleteroom/{roomno}")
//    public String deleteRoom(@PathVariable("sname") String staffname,@PathVariable("roomno") Integer roomno,Model model){
//        Room room =this.roomRepository.findRoomByroomno(roomno);
//        this.roomRepository.delete(room);
//        String redirectUrl = "/admin/show-rooms/" + staffname;
//        return "redirect:" + redirectUrl;
//    }
}
