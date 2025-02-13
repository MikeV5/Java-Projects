package esercizio3;

import esercizio1.Inesistente;

import java.io.Serial;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

//SERVER
public class ContenitoreImpl extends UnicastRemoteObject implements Contenitore {
    @Serial
    private static final long serialVersionUID = 1L;
    private HashMap<Integer, String> contenitore;
    private int maxElementi;
    private int numElementi;

    public ContenitoreImpl(int maxElementi) throws RemoteException {
        contenitore = new HashMap<Integer, String>();
        this.maxElementi = maxElementi;
        numElementi = 0;
    }

    public static void main(String[] args) throws RemoteException {
        ContenitoreImpl obj = new ContenitoreImpl(10);
        Registry r = LocateRegistry.createRegistry(1099);
        r.rebind("Contenitore",obj);
        System.out.println("Server pronto...");
    }
    @Override
    public synchronized int inserisci(String s) throws InterruptedException {
       while(numElementi >= maxElementi){
           wait();
           System.out.println("Mi son bloccato");
       }
       contenitore.put(numElementi,s); //Lo metto in quella posizione
        notifyAll();
       return ++numElementi;
    }

    @Override
    public synchronized String recupera(int n) throws Inesistente {
        if(!contenitore.containsKey(n)) throw new Inesistente();
        return contenitore.get(n);
    }

    @Override
    public synchronized void cancella(int n) throws Inesistente {
        if(!contenitore.containsKey(n)) throw new Inesistente();
        contenitore.remove(n);
        notifyAll();
    }
}
