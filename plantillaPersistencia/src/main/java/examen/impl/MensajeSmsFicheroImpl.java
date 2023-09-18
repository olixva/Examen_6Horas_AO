package examen.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import examen.dao.MensajeDAO;
import examen.dto.MensajeAbtractDTO;
import examen.dto.MensajeSmsDTO;

public class MensajeSmsFicheroImpl implements MensajeDAO {

    private List<MensajeSmsDTO> lista;

    public MensajeSmsFicheroImpl() throws IOException {
        lista = new ArrayList<>();

        try {
            this.leerFicheroToCache();
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void crear(MensajeAbtractDTO mensaje) throws IOException {

        try {
            lista.add((MensajeSmsDTO) mensaje);
            this.escribirFichero();
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void actualizar(MensajeAbtractDTO mensaje) throws IOException {

        for (MensajeSmsDTO MensajeSmsDTO : lista) {
            if (mensaje.getnCuenta().equals(MensajeSmsDTO.getnCuenta())) {
                lista.remove(MensajeSmsDTO);
                lista.add((MensajeSmsDTO) mensaje);
            }
        }
        try {

            this.escribirFichero();
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void eliminar(MensajeAbtractDTO mensaje) throws IOException {
        lista.remove(mensaje);

        try {
            this.escribirFichero();
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public MensajeAbtractDTO buscar(String nCuenta) throws IOException {

        for (MensajeSmsDTO MensajeSmsDTO : lista) {
            if (nCuenta.equals(MensajeSmsDTO.getnCuenta())) {
                return MensajeSmsDTO;
            }
        }
        return null;
    }

    private void escribirFichero() throws IOException {

        File file = new File("src\\main\\resources\\ficheroSms.txt");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {

            for (MensajeAbtractDTO mensaje : lista) {
                bw.write(mensaje.toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    private void leerFicheroToCache() throws IOException {

        File file = new File("src\\main\\resources\\ficheroSms.txt");
        lista.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = br.readLine()) != null) {
                String[] m = line.split("&");

                String nCuenta = m[0];
                String titular = m[1];
                String mensaje = m[2];
                String nTelefono = m[3];
                
                lista.add(new MensajeSmsDTO(nCuenta, titular, mensaje, nTelefono));
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }
}