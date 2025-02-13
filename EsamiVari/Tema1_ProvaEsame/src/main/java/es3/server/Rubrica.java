package es3.server;
import es3.common.RubricaInterface;
import es1.GiaPresente;
import es1.NomeNonEsistente;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Hashtable;

//SERVER
public class Rubrica extends UnicastRemoteObject implements RubricaInterface {
    //Ogni nome nella rubrica è una chiave con cui cercare il numero
    //corrispondente
    private Hashtable<String, String> laRubrica;
    public Rubrica() throws RemoteException {
        laRubrica = new Hashtable<String, String>();
    }

    public static void main(String[] args) throws RemoteException {
        RubricaInterface obj = new Rubrica();
        Registry r = LocateRegistry.createRegistry(1099);
        r.rebind("RubricaRMI",obj);
        System.out.println("server.Server ready...");
    }
    //Si aggiunge un numero nella rubrica con la rispettiva chiave
    //identificativa: il nome
    public synchronized void aggiungiNumero(String nome, String num) throws GiaPresente {
        if (!laRubrica.containsKey(nome)) {
            laRubrica.put(nome, num);
            //System.out.println("common.Rubrica: aggiunto " + nome + "  " + num);
            this.notifyAll();
        }
        else {
            throw new GiaPresente();
        }
    }
    public synchronized void eliminaNumero(String nome) throws NomeNonEsistente {
        if (laRubrica.containsKey(nome)) {
            laRubrica.remove(nome);
            this.notifyAll();
            //System.out.println("common.Rubrica: rimosso " + nome);
        }
        else {
           throw new NomeNonEsistente();
        }
    }
    public synchronized boolean inRubrica(String nome) {
        return laRubrica.containsKey(nome);
    }
    //Restituisce il  nome passato come argomento se esiste
    public synchronized String trova(String nome) throws InterruptedException {
        while(!laRubrica.containsKey(nome)) this.wait();
        return laRubrica.get(nome);
    }
}


