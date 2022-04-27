package com.example.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="CATALOGUE")
public class Catalogue {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int accessID;
    private String accessName;
    private int quantity;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "accessid", referencedColumnName = "accessID")
    List<Manages> manages = new ArrayList<>();

    public Catalogue() {
        super();

    }

    public int getAccessID() {
        return accessID;
    }
    public void setAccessID(int accessID) {
        this.accessID = accessID;
    }
    public String getAccessName() {
        return accessName;
    }
    public void setAccessName(String accessName) {
        this.accessName = accessName;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<Manages> getManages() {
        return manages;
    }

    public void setManages(List<Manages> manages) {
        this.manages = manages;
    }

    @Override
    public String toString() {
        return "Catalogue{" +
                "accessID=" + accessID +
                ", accessName='" + accessName + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
