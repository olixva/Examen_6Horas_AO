package examen.dto;

/**
 * Esta es una clase abstracta para un mensaje DTO (objeto de transferencia de datos) con campos para
 * el número de cuenta, el nombre del titular de la cuenta y el mensaje.
 */
public abstract class MensajeAbtractDTO {
    
    protected String nCuenta;
    protected String titular;
    protected String mensaje;
    
    protected MensajeAbtractDTO(String nCuenta, String titular, String mensaje) {
        this.nCuenta = nCuenta;
        this.titular = titular;
        this.mensaje = mensaje;
    }

    public String getnCuenta() {
        return nCuenta;
    }

    public void setnCuenta(String nCuenta) {
        this.nCuenta = nCuenta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}
