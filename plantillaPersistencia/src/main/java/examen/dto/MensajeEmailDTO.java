package examen.dto;

/**
 * La clase `MensajeEmailDTO` amplía `MensajeAbtractDTO` y agrega campos para el asunto y el
 * destinatario del correo electrónico.
 */
public class MensajeEmailDTO extends MensajeAbtractDTO {

    private String asunto;
    private String destinatario;

    public MensajeEmailDTO(String nCuenta, String titular, String mensaje, String asunto, String destinatario) {
        super(nCuenta, titular, mensaje);
        this.asunto = asunto;
        this.destinatario = destinatario;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    @Override
    public String toString() {
        return "" + nCuenta + "&" + titular + "&" + mensaje + "&" + asunto + "&" + destinatario + "\n";
    }
}
