package com.example.repository;

import com.example.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entity.Patient;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Integer> {


    @Query("select u from Patient u where u.name = :name")
    public Patient getPatientByName(@Param("name") String name);


}
