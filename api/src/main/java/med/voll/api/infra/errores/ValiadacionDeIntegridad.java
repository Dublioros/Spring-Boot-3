package med.voll.api.infra.errores;

public class ValiadacionDeIntegridad extends RuntimeException {
    public ValiadacionDeIntegridad(String s) {
        super(s);
    }
}
