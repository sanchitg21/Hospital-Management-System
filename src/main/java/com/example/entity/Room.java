package com.example.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="ROOM")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int roomno;
    private String roomtype;
    private int charge;
    private int maxoccup;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "roomno", referencedColumnName = "roomno")
    List<Medicalreport> medicalreport = new ArrayList<>();

    public Room() {
        super();
    }

    public void setMedicalreport(List<Medicalreport> medicalreport) {
        this.medicalreport = medicalreport;
    }

    public List<Medicalreport> getMedicalreport() {
        return medicalreport;
    }

    public int getRoomno() {
        return roomno;
    }

    public void setRoomno(int roomno) {
        this.roomno = roomno;
    }

    public String getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(String roomtype) {
        this.roomtype = roomtype;
    }


    public int getCharge() {
        return charge;
    }

    public void setCharge(int charge) {
        this.charge = charge;
    }

    public int getMaxoccup() {
        return maxoccup;
    }

    public void setMaxoccup(int maxoccup) {
        this.maxoccup = maxoccup;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomno=" + roomno +
                ", roomtype='" + roomtype + '\'' +
                ", charge=" + charge +
                ", maxoccup=" + maxoccup +
                '}';
    }
}
