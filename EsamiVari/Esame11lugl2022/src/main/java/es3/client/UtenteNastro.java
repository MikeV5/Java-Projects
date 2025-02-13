package es3.client;
import es1.noRead;
import es1.noWrite;
import es3.common.Nastro;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Random;

public class UtenteNastro extends Thread{
    private int id;
    Nastro nastro;
    public UtenteNastro(int id, Nastro nastro){
        this.id=id;
        this.nastro = nastro;
    }
    public void run() {
            Random r = new Random();
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000); //Ritardo di 1 secondo
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                switch (r.nextInt(4)) { //numero casuale tra 0 e 3
                    case 0: {
                        try {
                            // Scrive una nuova stringa nel nastro utilizzando
                            // l'identificatore e l'indice corrente
                            nastro.write(id + "El" + i);
                            System.out.println("Scrivo: " + id + " Messa: El" + i);
                        } catch (noWrite | RemoteException e) {
                            System.out.println("noWrite");
                        }
                        break;
                    }
                    case 1: {
                        try {
                            // Legge la stringa nella posizione corrente del nastro
                            System.out.println("Letto: " + nastro.read());
                        } catch (noRead | RemoteException e) {
                            System.out.println("noRead");
                        }
                        break;
                    }
                    case 2: {
                        try {
                            nastro.rewind();
                            System.out.println("Rewind");
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                    default:
                        try {
                            System.out.println("Nastro vuoto? " + nastro.empty());
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                }
                // Aggiunta della stampa della posizione corrente
                try {
                    System.out.println("Posizione corrente: " + nastro.getCurrentPosition());
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
    }

    public static void main( String[] args ) throws RemoteException, NotBoundException {
        Registry r = LocateRegistry.getRegistry();
        Nastro n = (Nastro) r.lookup("NastroRMI");
        UtenteNastro u = new UtenteNastro((Integer.parseInt(args[0])), n);
        u.start();
        }
}
