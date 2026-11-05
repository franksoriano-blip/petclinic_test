package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Visit;
import com.tecsup.petclinic.exceptions.VisitNotFoundException;

import java.math.BigDecimal;

public interface VisitService {

    // Busca una visita por su id. Si no existe, lanza VisitNotFoundException
    Visit findById(Integer id) throws VisitNotFoundException;

    // Suma el costo de todas las visitas de una mascota
    BigDecimal calculateTotalCostByPet(int petId);
}