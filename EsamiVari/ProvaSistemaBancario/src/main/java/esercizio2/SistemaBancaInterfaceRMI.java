package esercizio2;

import esercizio1.eccezioni.ContoInesistente;
import esercizio1.eccezioni.DisponibilitaInsufficiente;
import esercizio1.eccezioni.SommaNegativa;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SistemaBancaInterfaceRMI extends Remote {
    int saldo(IBAN idcc) throws ContoInesistente, RemoteException;
    void versamento(IBAN idcc, int s)
            throws ContoInesistente, SommaNegativa, RemoteException;
    void prelievo(IBAN idcc, int s)
            throws DisponibilitaInsufficiente, SommaNegativa,
            ContoInesistente, RemoteException;
    void trasferimento(IBAN idccFrom, IBAN idccTo, int s)
            throws DisponibilitaInsufficiente,
            SommaNegativa, ContoInesistente, RemoteException;
    boolean attendiTrasferimento(IBAN idcc) throws ContoInesistente
            , RemoteException;
}
