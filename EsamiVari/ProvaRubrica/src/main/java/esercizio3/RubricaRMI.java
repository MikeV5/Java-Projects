package esercizio3;

import esercizio1.GiaPresente;
import esercizio1.Inesistente;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Hashtable;

public class RubricaRMI extends UnicastRemoteObject implements RubricaInterfaceRMI {
    static final long serialVersionUID = 1L;
    private Hashtable<String, String> laRubrica;
    public RubricaRMI() throws RemoteException {
        laRubrica = new Hashtable<String, String>();
    }
    public static void main(String[] args) throws RemoteException {
        RubricaRMI obj = new RubricaRMI();
        Registry r = LocateRegistry.createRegistry(ServerSettings.PORT);
        r.rebind("Rubrica", obj);
        System.out.println("Server pronto...");
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
