package esercizio3;

import esercizio1.GiaPresente;
import esercizio1.Inesistente;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RubricaInterfaceRMI extends Remote {
    void aggiungiNumero(String nome, String num) throws GiaPresente, RemoteException;
    void eliminaNumero(String nome) throws Inesistente, RemoteException;
    boolean inRubrica(String nome) throws Inesistente, RemoteException;
    String trova(String nome) throws Inesistente, RemoteException;
}
