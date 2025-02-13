package org.example;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ServerMain extends UnicastRemoteObject implements Loggable{
    static int PORT = 1234;

    protected ServerMain() throws RemoteException {
    }

    public static void main( String[] args ) throws RemoteException {
        System.out.println( "Hello from Server!" );
        ServerMain obj = new ServerMain();
        Registry registry = LocateRegistry.createRegistry(PORT);
        registry.rebind("Loggable", obj);
        System.err.println("Server ready");

    }


    public boolean login(String nick) throws RemoteException {
        boolean result = nick.equals("ingconti");
        return result;
    }

    public void logout(String nick) throws RemoteException {

    }
}