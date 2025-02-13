package esercizio1;

import java.util.Hashtable;

public class Rubrica implements RubricaInterface{
    private Hashtable<String, String> laRubrica;
    public Rubrica(){
        laRubrica = new Hashtable<String, String>();
    }
    public synchronized void aggiungiNumero(String nome, String num) throws GiaPresente {
        if (!laRubrica.containsKey(nome)) {
            laRubrica.put(nome, num);
            notifyAll();
        }
        else {
          throw new GiaPresente();
        }
    }
    public synchronized void eliminaNumero(String nome) throws Inesistente {
        if (laRubrica.containsKey(nome)) {
            laRubrica.remove(nome);
        }
        else {
            throw new Inesistente();
        }
    }
    //Restituisce true se dato un nome(e quindi numero) esiste
    public synchronized boolean inRubrica(String nome) throws Inesistente {
        if(!laRubrica.containsKey(nome)) throw new Inesistente();
        return laRubrica.containsKey(nome);
    }
    //Restituisce il numero dato un nome
    public synchronized String trova(String nome) {
        while(!laRubrica.containsKey(nome)) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return laRubrica.get(nome);
    }
}
