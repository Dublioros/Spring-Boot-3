package med.voll.api.domain.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.direccion.DatosDireccion;

public record DatosRegistroMedico(
        @NotBlank(message = "Nombre obligatorio") //No nulo y no blanco
        String nombre,
        @NotBlank(message = "Email obligatorio")
        @Email
        String email,
        @NotNull
        String telefono,
        @NotBlank
        @Pattern(regexp = "\\d{4,6}") //Expresion de 4 a 6 digitos
        String documento,
        @NotNull
        Especialidad especialidad,
        @NotNull
        @Valid
        DatosDireccion direccion) {
}
