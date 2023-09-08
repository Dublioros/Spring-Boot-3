package med.voll.api.domain.consulta.validaciones;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.DatosAgendarConsulta;
import med.voll.api.domain.paciente.ConsultaRepository;

public class PacienteActivo {

    private ConsultaRepository repository;
    public void validar(DatosAgendarConsulta datos) {
        if(datos.idPaciente() == null) {
            return;
        }

        var pacienteActivo = (boolean) repository.findByActivoById(datos.idPaciente());
        if (!pacienteActivo)
            throw new ValidationException("No se puede agendar citas a pacientes inactivos");
    }
}
