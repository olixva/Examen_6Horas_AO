package examen.main;

import java.sql.SQLException;

import examen.dto.MensajeEmailDTO;
import examen.dto.MensajePostalDTO;
import examen.dto.MensajeSmsDTO;
import examen.impl.MensajeMysqlImpl;

public class MainMysql {
  public static void main(String[] args) throws SQLException {
    
    MensajeEmailDTO mE = new MensajeEmailDTO("1", "Juan", "Hola",
        "Ninguni", "A mi");

    MensajePostalDTO mP = new MensajePostalDTO("2", "Mario", "Hola", "Avenida",
        "Casillas", 12, "2A");

    MensajeSmsDTO mS = new MensajeSmsDTO("3", "Antonio", "Adios", "123456789");

    MensajeMysqlImpl mSQL = new MensajeMysqlImpl();

    mSQL.crear(mE);
    mSQL.crear(mP);
    mSQL.crear(mS);

    mE.setAsunto("Nuevo asunto");
    mP.setNombreVia("Nueva Via");
    mS.setnTelefono("Movil");

    mSQL.actualizar(mE);
    mSQL.actualizar(mP);
    mSQL.actualizar(mS);

    mSQL.eliminar(mE);
    mSQL.eliminar(mP);
    mSQL.eliminar(mS);
  }
}
