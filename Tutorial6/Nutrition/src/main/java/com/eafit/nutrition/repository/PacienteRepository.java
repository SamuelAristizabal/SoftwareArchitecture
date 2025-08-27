package com.eafit.nutrition.repository;

import com.eafit.nutrition.model.Paciente;
import com.eafit.nutrition.projections.PacienteResumen;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    @Query("SELECT p.id as id, p.nombre as nombre, p.apellido as apellido FROM Paciente p WHERE p.nutricionista.id = :nutricionistaId")

    List<PacienteResumen> findPacienteResumenByNutricionistaId(@Param("nutricionistaId") Long nutricionistaId);
}
