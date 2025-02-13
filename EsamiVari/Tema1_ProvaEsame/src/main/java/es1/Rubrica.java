package es1;
import java.util.Hashtable;

public class Rubrica implements RubricaInterface{
    //Ogni nome nella rubrica è una chiave con cui cercare il numero
    //corrispondente
    private Hashtable<String, String> laRubrica;
    public Rubrica(){
        laRubrica = new Hashtable<String, String>();
    }
    //Si aggiunge un numero nella rubrica con la rispettiva chiave
    //identificativa: il nome
    public synchronized void aggiungiNumero(String nome, String num) throws GiaPresente {
        if (!laRubrica.containsKey(nome)) {
            laRubrica.put(nome, num);
            //System.out.println("common.Rubrica: aggiunto " + nome + "  " + num);
            notifyAll();
        }
        else {
            throw new GiaPresente();
        }
    }
    public synchronized void eliminaNumero(String nome) throws NomeNonEsistente {
        if (laRubrica.containsKey(nome)) {
            laRubrica.remove(nome);
            //System.out.println("common.Rubrica: rimosso " + nome);
        }
        else {
           throw new NomeNonEsistente();
        }
    }
    public synchronized boolean inRubrica(String nome) {
        return laRubrica.containsKey(nome);
    }
    //Restituisce il nome se si trova in rubrica
    public synchronized String trova(String nome) throws InterruptedException {
        while(!laRubrica.containsKey(nome)) this.wait();
        return laRubrica.get(nome);
    }
}


