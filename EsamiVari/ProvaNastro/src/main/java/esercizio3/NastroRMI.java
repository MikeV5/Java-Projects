package esercizio3;

import esercizio1.noRead;
import esercizio1.noWrite;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface NastroRMI extends Remote {
    void write(String s) throws noWrite, RemoteException;
    String read() throws noRead, RemoteException;
    void rewind()throws RemoteException;
    boolean empty()throws RemoteException;
}
