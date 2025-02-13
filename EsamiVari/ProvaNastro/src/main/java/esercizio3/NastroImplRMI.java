package esercizio3;

import esercizio1.noRead;
import esercizio1.noWrite;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;

public class NastroImplRMI extends UnicastRemoteObject implements NastroRMI {
    private LinkedList<String> nastro;
    private int posCorrente;
    public NastroImplRMI() throws RemoteException {
        nastro = new LinkedList<String>();
        posCorrente = 0;
    }

    public static void main(String[] args) throws RemoteException {
        NastroImplRMI obj = new NastroImplRMI();
        Registry r = LocateRegistry.createRegistry(ServerSettings.PORT);
        r.rebind("Nastro",obj);
        System.out.println("Server pronto...");
    }
    @Override
    //Non si possono sovvrascrivere in posizione già occupate
    public synchronized void write(String s) throws noWrite {
        //if(!nastro.get(posCorrente).isEmpty()) throw new noWrite();
        if(nastro.size() > posCorrente)  throw new noWrite();
        nastro.addLast(s);
        posCorrente++;
    }
    @Override
    public synchronized String read() throws noRead {
        if(nastro.size() == posCorrente) throw new noRead();
        return nastro.get(posCorrente++);
    }
    @Override
    public synchronized void rewind() {
        posCorrente = 0;
    }
    @Override
    public synchronized boolean empty() {
        return nastro.isEmpty();
    }
}
