package com.example.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

@Entity
@Table(name="MEDICALREPORT")
public class Medicalreport {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int reportid;
    private String disease;
    private String pulse;
    private String bp;
    private String temp;
    private String weight;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String iindate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String oindate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String odate;

    private int billno;
    private int treatcharges;
    private int medcharges;
    private int roomcharges;
    private String treatment;
    private String prescription;

    private int patientid;
    private int staffid;
    private int roomno;

    public int getPatientid() {
        return patientid;
    }

    public void setPatientid(int patientid) {
        this.patientid = patientid;
    }

    public int getStaffid() {
        return staffid;
    }

    public void setStaffid(int staffid) {
        this.staffid = staffid;
    }

    public int getRoomno() {
        return roomno;
    }

    public void setRoomno(int roomno) {
        this.roomno = roomno;
    }

    public Medicalreport() {
        super();
    }

    public int getReportid() {
        return reportid;
    }

    public void setReportid(int reportid) {
        this.reportid = reportid;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getPulse() {
        return pulse;
    }

    public void setPulse(String pulse) {
        this.pulse = pulse;
    }

    public String getBp() {
        return bp;
    }

    public void setBp(String bp) {
        this.bp = bp;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getIindate() {
        return iindate;
    }

    public void setIindate(String iindate) {
        this.iindate = iindate;
    }

    public String getOindate() {
        return oindate;
    }

    public void setOindate(String oindate) {
        this.oindate = oindate;
    }

    public String getOdate() {
        return odate;
    }

    public void setOdate(String odate) {
        this.odate = odate;
    }

    public int getBillno() {
        return billno;
    }

    public void setBillno(int billno) {
        this.billno = billno;
    }

    public int getTreatcharges() {
        return treatcharges;
    }

    public void setTreatcharges(int treatcharges) {
        this.treatcharges = treatcharges;
    }

    public int getMedcharges() {
        return medcharges;
    }

    public void setMedcharges(int medcharges) {
        this.medcharges = medcharges;
    }

    public int getRoomcharges() {
        return roomcharges;
    }

    public void setRoomcharges(int roomcharges) {
        this.roomcharges = roomcharges;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    @Override
    public String toString() {
        return "Medicalreport{" +
                "reportid=" + reportid +
                ", disease='" + disease + '\'' +
                ", pulse='" + pulse + '\'' +
                ", bp='" + bp + '\'' +
                ", temp='" + temp + '\'' +
                ", weight='" + weight + '\'' +
                ", iindate='" + iindate + '\'' +
                ", oindate='" + oindate + '\'' +
                ", odate='" + odate + '\'' +
                ", billno=" + billno +
                ", treatcharges=" + treatcharges +
                ", medcharges=" + medcharges +
                ", roomcharges=" + roomcharges +
                ", treatment='" + treatment + '\'' +
                ", prescription='" + prescription + '\'' +
                '}';
    }

}
