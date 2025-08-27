package com.eafit.nutrition.repository;

import com.eafit.nutrition.model.Medicion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface MedicionRepository extends JpaRepository<Medicion, Long> {

    // 🔹 Método usando Spring Data JPA (sin necesidad de consulta nativa)
    List<Medicion> findByPacienteIdOrderByFechaDesc(Long pacienteId);

    // 🔹 Otra forma con Spring Data JPA: trae solo la última medición
    Optional<Medicion> findFirstByPacienteIdOrderByFechaDesc(Long pacienteId);

    // 🔹 Consulta nativa para mayor control
    @Query(value = "SELECT * FROM medicion WHERE paciente_id = :pacienteId ORDER BY fecha DESC LIMIT 1", nativeQuery = true)
    Optional<Medicion> findLastMedicionByPacienteId(@Param("pacienteId") Long pacienteId);
}
