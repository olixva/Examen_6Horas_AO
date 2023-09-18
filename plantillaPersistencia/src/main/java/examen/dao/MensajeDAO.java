package examen.dao;

import java.sql.SQLException;

import examen.dto.MensajeAbtractDTO;


// Esta es una interfaz de Java llamada `MensajeDAO` que define cuatro métodos para realizar
// operaciones CRUD (Crear, Leer, Actualizar, Eliminar) en un objeto `MensajeAbtractDTO`.
public interface MensajeDAO {
    
    public void crear(MensajeAbtractDTO mensaje) throws Exception;

    public void actualizar(MensajeAbtractDTO mensaje) throws Exception;

    public void eliminar(MensajeAbtractDTO mensaje) throws Exception;

    public MensajeAbtractDTO buscar(String nCuenta) throws Exception;

}
