package com.example.appweb3.repos;

import com.example.appweb3.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface patientrepos extends JpaRepository<Patient,Long> {
Page<Patient> findByNomContains(String Keyword, Pageable pageable);}

/*@Query("select p from Patient p where p.Nom like :x")
Page<Patient> chercher(@Param("x") String Keyword , Pageable pageable);
}*/
