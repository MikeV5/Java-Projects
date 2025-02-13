package es2.server;

import es2.common.Rubrica;
import es1.GiaPresente;
import es1.NomeNonEsistente;

import java.util.Hashtable;
public class RubricaImpl implements Rubrica {
    private Hashtable<String, String> laRubrica; // La rubrica è implementata come una Hashtable

    public RubricaImpl() {
        laRubrica = new Hashtable<String, String>(); // Inizializzazione della rubrica
    }

    // Aggiunge un numero alla rubrica con il rispettivo nome come chiave
    public synchronized void aggiungiNumero(String nome, String num) throws GiaPresente {
        if (!laRubrica.containsKey(nome)) {
            laRubrica.put(nome, num); // Aggiunta del nome e numero alla rubrica
            notifyAll(); // Notifica eventuali thread in attesa di accesso alla rubrica
        } else {
            throw new GiaPresente(); // Eccezione se il nome è già presente nella rubrica
        }
    }

    // Elimina un numero dalla rubrica dato il nome
    public synchronized void eliminaNumero(String nome) throws NomeNonEsistente {
        if (laRubrica.containsKey(nome)) {
            laRubrica.remove(nome); // Rimozione del nome dalla rubrica
        } else {
            throw new NomeNonEsistente(); // Eccezione se il nome non è presente nella rubrica
        }
    }

    // Verifica se un nome è presente nella rubrica
    public synchronized boolean inRubrica(String nome) {
        return laRubrica.containsKey(nome);
    }

    // Trova il numero corrispondente a un nome nella rubrica
    public synchronized String trova(String nome) throws InterruptedException {
        while (!laRubrica.containsKey(nome)) {
            this.wait(); // Attende finché il nome non è presente nella rubrica
        }
        return laRubrica.get(nome); // Restituisce il numero corrispondente al nome
    }
}