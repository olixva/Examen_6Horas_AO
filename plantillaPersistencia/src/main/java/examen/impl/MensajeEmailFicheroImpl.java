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
import examen.dto.MensajeEmailDTO;

public class MensajeEmailFicheroImpl implements MensajeDAO {

    private List<MensajeEmailDTO> lista;

    public MensajeEmailFicheroImpl() throws IOException {
        lista = new ArrayList<>();
        
        try {
            this.leerFicheroToCache();
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void crear(MensajeAbtractDTO mensaje) throws IOException  {
        
        try {
            lista.add((MensajeEmailDTO) mensaje);
            this.escribirFichero();
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void actualizar(MensajeAbtractDTO mensaje) throws IOException {
        
        for (MensajeEmailDTO mensajeEmailDTO : lista) {
            if (mensaje.getnCuenta().equals(mensajeEmailDTO.getnCuenta())) {
                lista.remove(mensajeEmailDTO);
                lista.add((MensajeEmailDTO) mensaje);
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
       
        for (MensajeEmailDTO mensajeEmailDTO : lista) {
            if (nCuenta.equals(mensajeEmailDTO.getnCuenta())) {
                return mensajeEmailDTO;
            }
        }
        return null;
    }

    private void escribirFichero() throws IOException {

        File file = new File("src\\main\\resources\\ficheroEmail.txt");

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

        File file = new File("src\\main\\resources\\ficheroEmail.txt");
        lista.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = br.readLine()) != null) {
                String[] m = line.split("&");

                String nCuenta = m[0];
                String titular = m[1];
                String mensaje = m[2];
                String asunto = m[3];
                String destinatario = m[4];

                lista.add(new MensajeEmailDTO(nCuenta, titular, mensaje, asunto, destinatario));
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    } 
}
