package es2.client;

import es2.common.Rubrica;
import es1.GiaPresente;
import es1.NomeNonEsistente;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class RubricaStub implements Rubrica {
    private ObjectInputStream in;
    private ObjectOutputStream out;

    public RubricaStub(String host, int port) throws IOException {
        Socket socket = new Socket(InetAddress.getByName(host), port);
        out = new ObjectOutputStream(socket.getOutputStream());
        in = new ObjectInputStream(socket.getInputStream());
    }

    public void aggiungiNumero(String nome, String num) throws GiaPresente, IOException {
        out.writeObject("AGG");
        out.writeObject(nome);
        out.writeObject(num);

        try {
            Object tmp = in.readObject();

            if (tmp instanceof IOException) {
                throw (IOException) tmp;
            } else if (tmp instanceof GiaPresente) {
                throw (GiaPresente) tmp;
            } else if (tmp instanceof String && ((String) tmp).equals("OK")) {
                return;
            } else {
                throw new IOException();
            }
        } catch (ClassNotFoundException e) {
            throw new IOException();
        }
    }

    public void eliminaNumero(String nome) throws NomeNonEsistente, IOException {
        out.writeObject("ELI");
        out.writeObject(nome);

        try {
            Object tmp = in.readObject();

            if (tmp instanceof IOException) {
                throw (IOException) tmp;
            } else if (tmp instanceof NomeNonEsistente) {
                throw (NomeNonEsistente) tmp;
            } else if (tmp instanceof String && ((String) tmp).equals("OK")) {
                return;
            } else {
                throw new IOException();
            }
        } catch (ClassNotFoundException e) {
            throw new IOException();
        }
    }

    public boolean inRubrica(String nome) throws IOException {
        out.writeObject("IN");
        out.writeObject(nome);

        try {
            Object tmp = in.readObject();

            if (tmp instanceof IOException) {
                throw (IOException) tmp;
            } else if (tmp instanceof Boolean) {
                return (Boolean) tmp;
            } else {
                throw new IOException();
            }
        } catch (ClassNotFoundException e) {
            throw new IOException();
        }
    }

    public String trova(String nome) throws InterruptedException, IOException {
        out.writeObject("TRO");
        out.writeObject(nome);

        try {
            Object tmp = in.readObject();

            if (tmp instanceof IOException) {
                throw (IOException) tmp;
            } else if (tmp instanceof InterruptedException) {
                throw (InterruptedException) tmp;
            } else if (tmp instanceof String) {
                return (String) tmp;
            } else {
                throw new IOException();
            }
        } catch (ClassNotFoundException e) {
            throw new IOException();
        }
    }
}