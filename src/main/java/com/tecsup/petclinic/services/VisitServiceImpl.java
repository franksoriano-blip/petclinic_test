package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Visit;
import com.tecsup.petclinic.exceptions.VisitNotFoundException;
import com.tecsup.petclinic.repositories.VisitRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Service                    // Spring crea este objeto y lo inyecta donde se necesite
@Slf4j                      // Lombok: permite usar log.info(...)
@RequiredArgsConstructor    // Lombok: crea el constructor para recibir el repositorio
public class VisitServiceImpl implements VisitService {

    private final VisitRepository visitRepository;

    @Override
    public Visit findById(Integer id) throws VisitNotFoundException {
        return visitRepository.findById(id)      // devuelve un Optional (puede estar vacío)
                .orElseThrow(() -> new VisitNotFoundException("Visit not found with id: " + id));
    }

    @Override
    public BigDecimal calculateTotalCostByPet(int petId) {
        List<Visit> visits = visitRepository.findByPetId(petId);   // todas sus visitas

        BigDecimal total = visits.stream()
                .map(Visit::getCost)                        // de cada visita, saco el costo
                .filter(Objects::nonNull)                   // ignoro las que no tienen costo
                .reduce(BigDecimal.ZERO, BigDecimal::add);  // sumo todo, empezando desde 0

        log.info("Total cost for pet {}: {}", petId, total);
        return total;
    }
}