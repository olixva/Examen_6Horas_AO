package examen.dto;

/**
 * La clase MensajeSmsDTO es una subclase de MensajeAbtractDTO que incluye un campo de número de
 * teléfono para mensajes SMS.
 */
public class MensajeSmsDTO extends MensajeAbtractDTO {

    private String nTelefono;

    public MensajeSmsDTO(String nCuenta, String titular, String mensaje, String nTelefono) {
        super(nCuenta, titular, mensaje);
        this.nTelefono = nTelefono;
    }

    public String getnTelefono() {
        return nTelefono;
    }

    public void setnTelefono(String nTelefono) {
        this.nTelefono = nTelefono;
    }

    @Override
    public String toString() {
        return "" + nCuenta + "&" + titular + "&" + mensaje + "&" + nTelefono + "\n";
    }
}
