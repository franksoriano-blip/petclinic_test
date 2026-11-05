package com.tecsup.petclinic.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity(name = "visits")   // esta clase representa la tabla "visits"
@NoArgsConstructor         // Lombok: crea un constructor vacío
@AllArgsConstructor        // Lombok: crea un constructor con todos los campos
@Data                      // Lombok: crea getters, setters y toString
public class Visit {

    @Id                                                   // clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)   // autoincremental
    private Integer id;

    @Column(name = "pet_id")      // columna pet_id de la tabla
    private int petId;

    @Column(name = "vet_id")
    private Integer vetId;

    @Column(name = "visit_date")
    private LocalDate visitDate;

    private String description;

    private BigDecimal cost;      // dinero → BigDecimal, NUNCA double
}