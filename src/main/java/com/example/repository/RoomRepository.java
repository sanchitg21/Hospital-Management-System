package com.example.repository;

import com.example.entity.Medicalreport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.entity.Room;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room,Integer> {

//    @Query("select u from Room u where u.roomno = :roomno")
    public Room findRoomByroomno(@Param("x") Integer roomno);
}
