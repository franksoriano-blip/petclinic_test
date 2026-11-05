package com.tecsup.petclinic.services;

import com.tecsup.petclinic.exceptions.VisitNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Grupo 4 - Integrante C: Calculos y errores (Frank Soriano)
 */
@SpringBootTest   // levanta la app con la BD H2 (datos de data.sql)
@Slf4j
public class VisitServiceTest {

    @Autowired
    private VisitService visitService;

    // PRUEBA 1: sumar costos con BigDecimal
    @Test
    public void testCalculateTotalCostByPet() {

        int PET_ID = 8;                                           // PREPARAR
        BigDecimal TOTAL_EXPECTED = new BigDecimal("295.00");

        BigDecimal total = visitService.calculateTotalCostByPet(PET_ID);   // EJECUTAR

        log.info("Total de la mascota {}: {}", PET_ID, total);
        assertEquals(0, TOTAL_EXPECTED.compareTo(total));         // VERIFICAR
    }

    // PRUEBA 2: si no hay visitas, devuelve BigDecimal.ZERO
    @Test
    public void testCalculateTotalCostByPet_NoVisits() {

        int PET_ID = 2;                                           // Basil no tiene visitas

        BigDecimal total = visitService.calculateTotalCostByPet(PET_ID);

        assertEquals(BigDecimal.ZERO, total);
    }

    // PRUEBA 3: buscar una visita que no existe debe lanzar VisitNotFoundException
    @Test
    public void testFindVisitById_NotFound() {

        Integer ID = 9999;                                        // ese id no existe

        assertThrows(VisitNotFoundException.class,
                () -> visitService.findById(ID));
    }
}