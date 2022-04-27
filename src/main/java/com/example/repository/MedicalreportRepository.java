package com.example.repository;

import com.example.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entity.Medicalreport;

import java.util.List;

@Repository
public interface MedicalreportRepository extends JpaRepository<Medicalreport,Integer> {

    public List<Medicalreport> findMedicalreportByPatientid(@Param("x") Integer patientid);
}
