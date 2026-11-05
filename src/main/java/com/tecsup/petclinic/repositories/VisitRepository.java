package com.tecsup.petclinic.repositories;

import com.tecsup.petclinic.entities.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Integer> {

    // Spring crea la consulta solo, a partir del nombre del método:
    // SELECT * FROM visits WHERE pet_id = ?
    List<Visit> findByPetId(int petId);
}