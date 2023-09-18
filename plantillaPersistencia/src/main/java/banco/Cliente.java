package banco;

import banco.activos.*;
import banco.enums.NotificacionesEnum;

public class Cliente {
    String nombre;
    String tipoVia;
    String nombreVia;
    int nVivienda;
    String piso;

    String nTelefono;

    private Cuenta cuenta;
    private Tarjeta tarjeta;
    private Prestamo prestamo;

    private NotificacionesEnum preferenciaNotificaciones;

    
    public Cliente(String nombre, String tipoVia, String nombreVia, int nVivienda, String piso, String nTelefono,
           NotificacionesEnum preferenciaNotificaciones) {
        this.nombre = nombre;
        this.tipoVia = tipoVia;
        this.nombreVia = nombreVia;
        this.nVivienda = nVivienda;
        this.piso = piso;
        this.nTelefono = nTelefono;
        this.preferenciaNotificaciones = preferenciaNotificaciones;
    }


    public void notificar() {
        
        if (preferenciaNotificaciones == NotificacionesEnum.SMS) {
            prestamo.generarNotificacion(nombre, "hola", nTelefono);

        }
    }

    
    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }
}
