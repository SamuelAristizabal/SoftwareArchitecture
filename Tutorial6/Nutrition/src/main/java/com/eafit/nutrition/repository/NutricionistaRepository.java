package com.eafit.nutrition.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.eafit.nutrition.model.Nutricionista;

public interface NutricionistaRepository extends JpaRepository<Nutricionista, Long> {

    // Opción 1: con EntityGraph
    @EntityGraph(attributePaths = { "pacientes" })
    @Query("SELECT n FROM Nutricionista n WHERE n.id = :id")
    Optional<Nutricionista> findByIdWithPacientesGraph(@Param("id") Long id);

    // Opción 2: con JOIN FETCH
    @Query("SELECT n FROM Nutricionista n LEFT JOIN FETCH n.pacientes WHERE n.id = :id")
    Optional<Nutricionista> findByIdWithPacientes(@Param("id") Long id);

}
