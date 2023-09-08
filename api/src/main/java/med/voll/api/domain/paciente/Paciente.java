package med.voll.api.domain.paciente;

import jakarta.persistence.*;
import lombok.*;
import med.voll.api.domain.direccion.Direccion;

@Getter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Paciente")
@Table(name = "pacientes")
public class Paciente {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean activo;
    private String nombre;
    private String email;
    private String documentoIdentidad;
    private String telefono;

    @Embedded
    private Direccion direccion;

    public Paciente(DatosRegistroPaciente datosRegistroPaciente) {
        this.activo = true;
        this.nombre = datosRegistroPaciente.nombre();
        this.email = datosRegistroPaciente.email();
        this.telefono = datosRegistroPaciente.telefono();
        this.documentoIdentidad = datosRegistroPaciente.documentoIdentidad();
        this.direccion = new Direccion(datosRegistroPaciente.direccion());
    }

    public void actualizarInformacion(DatosActualizacionPaciente datosActualizarPaciente) {
        if (datosActualizarPaciente.nombre() != null)
            this.nombre = datosActualizarPaciente.nombre();

        if (datosActualizarPaciente.telefono() != null)
            this.telefono = datosActualizarPaciente.telefono();

        if (datosActualizarPaciente.direccion() != null)
            direccion.actualizarDatos(datosActualizarPaciente.direccion());
    }
    public void inactivar() {
        this.activo = false;
    }
}