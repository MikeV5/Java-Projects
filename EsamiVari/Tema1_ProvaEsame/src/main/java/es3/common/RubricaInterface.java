package es3.common;
import es1.GiaPresente;
import es1.NomeNonEsistente;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RubricaInterface extends Remote {
    void aggiungiNumero(String nome, String num) throws GiaPresente, RemoteException;
    void eliminaNumero(String nome) throws NomeNonEsistente, RemoteException;
    boolean inRubrica(String nome) throws RemoteException;
    String trova(String nome) throws InterruptedException, RemoteException;
}
