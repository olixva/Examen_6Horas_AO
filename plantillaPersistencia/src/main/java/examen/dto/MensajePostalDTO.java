package examen.dto;

/**
 * La clase MensajePostalDTO es una subclase de MensajeAbtractDTO que representa
 * un mensaje postal con
 * información sobre la dirección.
 */
public class MensajePostalDTO extends MensajeAbtractDTO {

    private String tipoVia;
    private String nombreVia;
    private int numVivienda;
    private String piso;

    public MensajePostalDTO(String nCuenta, String titular, String mensaje, String tipoVia, String nombreVia,
            int numVivienda, String piso) {
        super(nCuenta, titular, mensaje);
        this.tipoVia = tipoVia;
        this.nombreVia = nombreVia;
        this.numVivienda = numVivienda;
        this.piso = piso;
    }

    public String getTipoVia() {
        return tipoVia;
    }

    public void setTipoVia(String tipoVia) {
        this.tipoVia = tipoVia;
    }

    public String getNombreVia() {
        return nombreVia;
    }

    public void setNombreVia(String nombreVia) {
        this.nombreVia = nombreVia;
    }

    public int getNumVivienda() {
        return numVivienda;
    }

    public void setNumVivienda(int numVivienda) {
        this.numVivienda = numVivienda;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    @Override
    public String toString() {
        return "" + nCuenta + "&" + titular + "&" + mensaje + "&" + tipoVia + "&" + nombreVia + "&" + numVivienda + "&"
                + piso
                + "\n";
    }
}
