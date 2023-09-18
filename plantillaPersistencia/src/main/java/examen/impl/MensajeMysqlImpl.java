package examen.impl;

import java.sql.*;
import examen.dao.MensajeDAO;
import examen.dto.*;
import examen.util.PropertiesUtilSingleton;

/**
 * La clase MensajeMysqlImpl es una implementación Java de la interfaz MensajeDAO que proporciona
 * métodos para crear, actualizar, eliminar y buscar mensajes en una base de datos MySQL.
 */
public class MensajeMysqlImpl implements MensajeDAO {

    @Override
    public void crear(MensajeAbtractDTO mensaje) throws SQLException {
        String query = "INSERT INTO cabeceramsj () VALUES (?,?,?);";

        try (Connection conn = DriverManager.getConnection(
                PropertiesUtilSingleton.getInstance().getconnectionString(),
                PropertiesUtilSingleton.getInstance().getdatabaseUser(),
                PropertiesUtilSingleton.getInstance().getdatabasePass());
                PreparedStatement preparedStmt = conn.prepareStatement(query)) {

            preparedStmt.setString(1, mensaje.getnCuenta());
            preparedStmt.setString(2, mensaje.getTitular());
            preparedStmt.setString(3, mensaje.getMensaje());

            preparedStmt.execute();

            if (mensaje instanceof MensajeEmailDTO) {
                String queryMail = "INSERT INTO cuerpomsjemail () VALUES (?,?,?);";
                PreparedStatement preparedStmtE = conn.prepareStatement(queryMail);

                preparedStmtE.setString(1, mensaje.getnCuenta());
                preparedStmtE.setString(2, ((MensajeEmailDTO) mensaje).getAsunto());
                preparedStmtE.setString(3, ((MensajeEmailDTO) mensaje).getDestinatario());

                preparedStmtE.execute();
                preparedStmtE.close();

            } else if (mensaje instanceof MensajePostalDTO) {
                String queryPostal = "INSERT INTO cuerpomsjpostal () VALUES (?,?,?,?,?);";
                PreparedStatement preparedStmtP = conn.prepareStatement(queryPostal);

                preparedStmtP.setString(1, mensaje.getnCuenta());
                preparedStmtP.setString(2, ((MensajePostalDTO) mensaje).getTipoVia());
                preparedStmtP.setString(3, ((MensajePostalDTO) mensaje).getNombreVia());
                preparedStmtP.setInt(4, ((MensajePostalDTO) mensaje).getNumVivienda());
                preparedStmtP.setString(5, ((MensajePostalDTO) mensaje).getPiso());

                preparedStmtP.execute();
                preparedStmtP.close();
            } else {
                String querySms = "INSERT INTO cuerpomsjsms () VALUES (?,?);";
                PreparedStatement preparedStmtS = conn.prepareStatement(querySms);

                preparedStmtS.setString(1, mensaje.getnCuenta());
                preparedStmtS.setString(2, ((MensajeSmsDTO) mensaje).getnTelefono());

                preparedStmtS.execute();
                preparedStmtS.close();
            }

        } catch (SQLException e) {

            e.printStackTrace();
            throw e;
        }

    }

    @Override
    public void actualizar(MensajeAbtractDTO mensaje) throws SQLException {
        try (Connection conn = DriverManager.getConnection(
                PropertiesUtilSingleton.getInstance().getconnectionString(),
                PropertiesUtilSingleton.getInstance().getdatabaseUser(),
                PropertiesUtilSingleton.getInstance().getdatabasePass())) {

            if (mensaje instanceof MensajeEmailDTO) {
                String queryMail = "UPDATE cuerpomsjemail SET asunto=?, destinatario=? WHERE numcuenta=?;";
                PreparedStatement preparedStmtE = conn.prepareStatement(queryMail);

                preparedStmtE.setString(1, ((MensajeEmailDTO) mensaje).getAsunto());
                preparedStmtE.setString(2, ((MensajeEmailDTO) mensaje).getDestinatario());
                preparedStmtE.setString(3, mensaje.getnCuenta());

                preparedStmtE.executeUpdate();
                preparedStmtE.close();

            } else if (mensaje instanceof MensajePostalDTO) {
                String queryPostal = "UPDATE cuerpomsjpostal SET tipovia=?, nombrevia=?, numvivienda=?, piso=? WHERE numcuenta=?;";
                PreparedStatement preparedStmtP = conn.prepareStatement(queryPostal);

                preparedStmtP.setString(1, ((MensajePostalDTO) mensaje).getTipoVia());
                preparedStmtP.setString(2, ((MensajePostalDTO) mensaje).getNombreVia());
                preparedStmtP.setInt(3, ((MensajePostalDTO) mensaje).getNumVivienda());
                preparedStmtP.setString(4, ((MensajePostalDTO) mensaje).getPiso());
                preparedStmtP.setString(5, mensaje.getnCuenta());

                preparedStmtP.executeUpdate();
                preparedStmtP.close();
            } else {
                String querySms = "UPDATE cuerpomsjsms SET numtelefono=? WHERE numcuenta=?;";
                PreparedStatement preparedStmtS = conn.prepareStatement(querySms);

                preparedStmtS.setString(1, ((MensajeSmsDTO) mensaje).getnTelefono());
                preparedStmtS.setString(2, mensaje.getnCuenta());

                preparedStmtS.executeUpdate();
                preparedStmtS.close();
            }

        } catch (SQLException e) {

            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void eliminar(MensajeAbtractDTO mensaje) throws SQLException {
        try (Connection conn = DriverManager.getConnection(
                PropertiesUtilSingleton.getInstance().getconnectionString(),
                PropertiesUtilSingleton.getInstance().getdatabaseUser(),
                PropertiesUtilSingleton.getInstance().getdatabasePass())) {

            if (mensaje instanceof MensajeEmailDTO) {
                String queryMail = "DELETE FROM cuerpomsjemail WHERE numcuenta=?;";
                PreparedStatement preparedStmtE = conn.prepareStatement(queryMail);

                preparedStmtE.setString(1, mensaje.getnCuenta());

                preparedStmtE.executeUpdate();
                preparedStmtE.close();

            } else if (mensaje instanceof MensajePostalDTO) {
                String queryPostal = "DELETE FROM cuerpomsjpostal WHERE numcuenta=?;";
                PreparedStatement preparedStmtP = conn.prepareStatement(queryPostal);

                preparedStmtP.setString(1, mensaje.getnCuenta());

                preparedStmtP.executeUpdate();
                preparedStmtP.close();

            } else {
                String querySms = "DELETE FROM cuerpomsjsms WHERE numcuenta=?;";
                PreparedStatement preparedStmtS = conn.prepareStatement(querySms);

                preparedStmtS.setString(1, mensaje.getnCuenta());

                preparedStmtS.executeUpdate();
                preparedStmtS.close();
            }

            String query = "DELETE FROM cabeceramsj WHERE numcuenta=?;";
            PreparedStatement preparedStmt = conn.prepareStatement(query);

            preparedStmt.setString(1, mensaje.getnCuenta());

            preparedStmt.executeUpdate();
            preparedStmt.close();

        } catch (SQLException e) {

            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public MensajeAbtractDTO buscar(String nCuenta) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscar'");
    }
}
