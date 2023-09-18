package examen.main;

import java.io.IOException;
import java.sql.SQLException;

import examen.dto.MensajeEmailDTO;
import examen.dto.MensajePostalDTO;
import examen.dto.MensajeSmsDTO;
import examen.impl.MensajeEmailFicheroImpl;
import examen.impl.MensajePostalFicheroImpl;
import examen.impl.MensajeSmsFicheroImpl;

public class MainFicheros {
    public static void main(String[] args) {

        /* Prueba MensajeEmailFicheroImpl
        try {
            MensajeEmailDTO mE = new MensajeEmailDTO("123", "Antonio", "Hola", "Ninguno", "Profe");
            MensajeEmailFicheroImpl mEI = new MensajeEmailFicheroImpl();
        
            mEI.crear(mE);
            mE.setAsunto("Nuevo");
            mEI.actualizar(mE);
        
            MensajeEmailDTO mE2 = (MensajeEmailDTO) mEI.buscar("123");
            System.out.println(mE2.toString());
        
            mEI.eliminar(mE);
        } catch (IOException e) {
            e.printStackTrace();
        }
        */

        /*  Prueba MensajePostalFicheroImpl
        try {
            MensajePostalDTO mP = new MensajePostalDTO("123", "Antonio", "Hola", "Ninguno", "Profe", 5, "5A");
            MensajePostalFicheroImpl mPI = new MensajePostalFicheroImpl();
        
            mPI.crear(mP);
            mP.setNumVivienda(7);
            mPI.actualizar(mP);
        
            MensajePostalDTO mP2 = (MensajePostalDTO) mPI.buscar("123");
            System.out.println(mP2.toString());
        
            mPI.eliminar(mP);
        } catch (IOException e) {
            e.printStackTrace();
        }
        */

        /* Prueba MensajeSmsFicheroImpl
        try {
            MensajeSmsDTO mS = new MensajeSmsDTO("123", "Antonio", "Hola", "1234");
            MensajeSmsFicheroImpl mSI = new MensajeSmsFicheroImpl();

            mSI.crear(mS);
            mS.setnTelefono("4321");
            mSI.actualizar(mS);

            MensajeSmsDTO mS2 = (MensajeSmsDTO) mSI.buscar("123");
            System.out.println(mS2.toString());

            mSI.eliminar(mS);
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
    }
}
