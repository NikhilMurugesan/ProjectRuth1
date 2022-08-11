package com.example.springapp.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.springapp.entity.*;

public interface NotesRepository extends JpaRepository<NOTE, Integer> {

 //   @Query(value = "SELECT * FROM NOTE WHERE uid = uid", nativeQuery = true)
   // List<NOTE> findAllByUid(@Param("uid") String uid);
        

    @Query(value = "SELECT * FROM NOTE WHERE UID IN ('UID')", nativeQuery = true)
    List<NOTE> findAllByUid(@Param("UID") String UID);
    }
