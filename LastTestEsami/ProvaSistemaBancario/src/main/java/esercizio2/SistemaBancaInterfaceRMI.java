package esercizio2;

import esercizio1.ContoInesistente;
import esercizio1.DisponibilitaInsufficiente;
import esercizio1.SommaNegativa;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SistemaBancaInterfaceRMI extends Remote {
    int saldo(IBAN_RMI idcc) throws ContoInesistente, RemoteException;
    void versamento(IBAN_RMI idcc, int s)
            throws ContoInesistente, SommaNegativa, RemoteException;
    void prelievo(IBAN_RMI idcc, int s)
            throws DisponibilitaInsufficiente, SommaNegativa,
            ContoInesistente, RemoteException;
    void trasferimento(IBAN_RMI idccFrom, IBAN_RMI idccTo, int s)
            throws DisponibilitaInsufficiente, SommaNegativa,
            ContoInesistente, RemoteException;
    boolean attendiTrasferimento(IBAN_RMI idcc) throws ContoInesistente, RemoteException;
}
