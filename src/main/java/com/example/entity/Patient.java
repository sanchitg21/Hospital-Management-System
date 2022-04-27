package com.example.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="PATIENT")
public class Patient {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int  patientid;

    private String name;

    private String password;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String DOB;
    private String gender;
    private String mobileNo;
    private  String bloodgroup;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "patientid", referencedColumnName = "patientid")
    List<Medicalreport> medicalreport = new ArrayList<>();

    public void setMedicalreport(List<Medicalreport> medicalreport) {
        this.medicalreport = medicalreport;
    }

    public List<Medicalreport> getMedicalreport() {
        return medicalreport;
    }

    public Patient(){
        super();
    }

    public int getPatientid() {
        return patientid;
    }

    public void setPatientid(int patientid) {
        this.patientid = patientid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDOB() {
        return DOB;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getBloodgroup() {
        return bloodgroup;
    }

    public void setBloodgroup(String bloodgroup) {
        this.bloodgroup = bloodgroup;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientid=" + patientid +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", DOB='" + DOB + '\'' +
                ", gender='" + gender + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", bloodgroup='" + bloodgroup + '\'' +
                '}';
    }
}
