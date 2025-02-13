package es3;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Prova {
    private static final int auto=20;
    private static int PORT = 1099;
    public static void main(String[] args) throws RemoteException, NotBoundException, InterruptedException {
        //Viene ottenuto un riferimento al registro RMI locale

        Registry r = LocateRegistry.getRegistry();
       // Registry r = LocateRegistry.getRegistry("127.0.0.1", PORT);
        GestioneParcheggioRMI gp = (GestioneParcheggioRMI)r.lookup("GestoreParcheggio");
        for (int i=0; i<auto; i++) {
            Automobilista a = new Automobilista(i+1, gp);
            a.start();
            Thread.sleep(500);
        }

    }
}
