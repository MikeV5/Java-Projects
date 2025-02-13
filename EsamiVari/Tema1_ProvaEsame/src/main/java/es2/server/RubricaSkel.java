package es2.server;
import es2.common.Rubrica;
import es1.GiaPresente;
import es1.NomeNonEsistente;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class RubricaSkel extends Thread {
    private Socket clientSocket;
    private Rubrica rubrica;

    public RubricaSkel(Socket clientSocket, Rubrica rubrica) {
        this.clientSocket = clientSocket;
        this.rubrica = rubrica;
    }
    public void run() {
        try {
            ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
            ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());

            while (true) {
                String metodo = (String) in.readObject(); // Legge il metodo richiesto dal client

                if (metodo.equals("AGG")) {
                    String nome = (String) in.readObject(); // Legge il nome passato dal client
                    String num = (String) in.readObject(); // Legge il numero passato dal client

                    try {
                        rubrica.aggiungiNumero(nome, num); // Chiama il metodo aggiungiNumero della rubrica
                        out.writeObject("OK"); // Invia un messaggio di conferma al client
                    } catch (GiaPresente e) {
                        out.writeObject(e); // Invia l'eccezione GiaPresente al client
                    }
                } else if (metodo.equals("ELI")) {
                    String nome = (String) in.readObject(); // Legge il nome passato dal client

                    try {
                        rubrica.eliminaNumero(nome); // Chiama il metodo eliminaNumero della rubrica
                        out.writeObject("OK"); // Invia un messaggio di conferma al client
                    } catch (NomeNonEsistente e) {
                        out.writeObject(e); // Invia l'eccezione NomeNonEsistente al client
                    }
                } else if (metodo.equals("IN")) {
                    String nome = (String) in.readObject(); // Legge il nome passato dal client
                    boolean presente = rubrica.inRubrica(nome); // Chiama il metodo inRubrica della rubrica
                    out.writeObject(presente); // Invia il risultato al client
                } else if (metodo.equals("TRO")) {
                    String nome = (String) in.readObject(); // Legge il nome passato dal client

                    try {
                        String numero = rubrica.trova(nome); // Chiama il metodo trova della rubrica
                        out.writeObject(numero); // Invia il risultato al client
                    } catch (InterruptedException e) {
                        out.writeObject(e); // Invia l'eccezione InterruptedException al client
                    }
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}