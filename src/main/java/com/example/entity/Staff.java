package com.example.entity;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "STAFF")
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int staffid;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String DOB;
    private String name;

    private String password;
    private String mobileno;
    private int salary;
    private String designation;
    private String department;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "staffid", referencedColumnName = "staffid")
    List<Medicalreport> medicalreport = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "staffid", referencedColumnName = "staffid")
    List<Manages> manages = new ArrayList<>();

    public Staff() {
        super();
    }

    public List<Manages> getManages() {
        return manages;
    }

    public void setManages(List<Manages> manages) {
        this.manages = manages;
    }

    public void setMedicalreport(List<Medicalreport> medicalreport) {
        this.medicalreport = medicalreport;
    }

    public List<Medicalreport> getMedicalreport() {
        return medicalreport;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public int getStaffid() {
        return staffid;
    }

    public void setStaffid(int staffid) {
        this.staffid = staffid;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "staffid=" + staffid +
                ", DOB='" + DOB + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", mobileNo='" + mobileno + '\'' +
                ", salary=" + salary +
                ", designation='" + designation + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
