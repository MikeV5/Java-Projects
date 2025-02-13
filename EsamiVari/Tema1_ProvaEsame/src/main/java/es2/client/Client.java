package es2.client;

import es1.GiaPresente;
import es1.NomeNonEsistente;

import java.io.IOException;

public class Client {
    public static final String SERVER_HOST = "localhost";
    public static final int SERVER_PORT = 8080;

    public static void main(String[] args) {
        try {
            RubricaStub rubricaStub = new RubricaStub(SERVER_HOST, SERVER_PORT);

            // Esempi di chiamate ai metodi della rubrica
            rubricaStub.aggiungiNumero("Alice", "123456789");
            rubricaStub.aggiungiNumero("Bob", "987654321");

            String numeroAlice = rubricaStub.trova("Alice");
            System.out.println("Numero di Alice: " + numeroAlice);

            boolean presenteBob = rubricaStub.inRubrica("Bob");
            System.out.println("Bob presente nella rubrica? " + presenteBob);

            rubricaStub.eliminaNumero("Bob");

            boolean presenteBobDopoEliminazione = rubricaStub.inRubrica("Bob");
            System.out.println("Bob presente nella rubrica dopo eliminazione? " + presenteBobDopoEliminazione);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (GiaPresente | NomeNonEsistente | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
