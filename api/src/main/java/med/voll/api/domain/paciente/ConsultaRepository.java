package med.voll.api.domain.paciente;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface ConsultaRepository extends JpaRepository<Paciente, Long> {
    Page<Paciente> findByActivoTrue(Pageable paginacion);
    @Query("""
        SELECT p.activo
        FROM Paciente p
        WHERE p.id=:idPaciente
        """)
    Object findByActivoById(Long idPaciente);

    Boolean existsByPacienteIdAndDataBetween(Long idPaciente, LocalDateTime primerHorario, LocalDateTime ultimoHorario);

    Object existsByPacienteIdAndFechaBetween(Long aLong, LocalDateTime primerHorario, LocalDateTime ultimoHorario);
}