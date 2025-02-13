package es3.common;
import es1.noRead;
import es1.noWrite;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Nastro extends Remote {
    void write(String s) throws noWrite, RemoteException;
    String read() throws noRead, RemoteException;
    void rewind() throws RemoteException;
    boolean empty() throws RemoteException;
    int getCurrentPosition()throws RemoteException;
}
