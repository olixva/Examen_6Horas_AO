package banco.activos;

import java.io.IOException;
import java.sql.SQLException;

import examen.dto.MensajeSmsDTO;
import examen.impl.MensajeMysqlImpl;
import examen.impl.MensajeSmsFicheroImpl;

public class Prestamo {
    
    private String nCuenta;

    public Prestamo(String nCuenta) {
        this.nCuenta = nCuenta;
    }

    public void generarNotificacion(String titular, String mensaje, String nTelefono) {
        MensajeSmsDTO notificaionSms = new MensajeSmsDTO(nCuenta, titular, mensaje, nTelefono);
        MensajeMysqlImpl mysqlSms = new MensajeMysqlImpl();

        try {
            mysqlSms.crear(notificaionSms);
        } catch (SQLException e) {
            try {
                MensajeSmsFicheroImpl ficheroSMS = new MensajeSmsFicheroImpl();
                ficheroSMS.crear(notificaionSms);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            
            
        }
    }

    
}
