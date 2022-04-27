package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entity.Staff;

import java.util.List;

@Repository
public interface StaffRepository extends JpaRepository<Staff,Integer> {
    @Query("select u from Staff u where u.name = :name")
    public Staff getStaffByName(@Param("name") String name);
}
