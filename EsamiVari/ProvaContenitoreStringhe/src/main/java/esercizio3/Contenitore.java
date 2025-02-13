package esercizio3;

import esercizio1.Inesistente;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface Contenitore extends Remote {
    int inserisci(String s) throws InterruptedException, RemoteException;
    String recupera(int n) throws Inesistente, RemoteException;
    void cancella(int n) throws Inesistente, RemoteException;
}
