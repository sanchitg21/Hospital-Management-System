package com.example.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "MANAGES")
public class Manages {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int staffid ;
    private int accessid;
    public Manages() {
        super();
    }

    public int getStaffid() {
        return staffid;
    }

    public void setStaffid(int staffid) {
        this.staffid = staffid;
    }

    public int getAccessid() {
        return accessid;
    }

    public void setAccessid(int accessid) {
        this.accessid = accessid;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "staffid=" + staffid +
                ", accessid ='" + accessid + '\'' +
                '}';
    }
}
