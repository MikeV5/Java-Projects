package esercizio2;

import esercizio1.DestinatarioPieno;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Random;

public class ProduttoreRMI extends Thread{
    //int randomDestCons;
    private Random randomConsumatore;

    ProduttoreMsgInterface gestore;

    public ProduttoreRMI(ProduttoreMsgInterface gestore) {
        this.gestore = gestore;
        randomConsumatore = new Random();
    }

    public static void main(String[] args) throws NotBoundException, RemoteException {
        Registry r = LocateRegistry.getRegistry();
        ProduttoreMsgInterface stub = (ProduttoreMsgInterface)r.lookup("GestoreM");
        ProduttoreRMI p = new ProduttoreRMI(stub);
        p.start();
    }
    public void run(){
        try {
            for (int i=0; i<100; i++) { //Ciclo per generare 100 messaggi
                //da inviare
                //Viene generato casualmente un destinatario
                int dest = randomConsumatore.nextInt(5);
                //Viene creato un Messaggio con il destinatario
                //e il testo del messaggio
                Msg messaggio = new Msg(dest, "Mess"+i);
                try {
                    //Il produttore cerca di inviare il messaggio
                    //al gestore dei messaggi
                    gestore.send(messaggio);
                    //Il messaggio è stato inviato correttamente al destinatario
                    System.out.println("Inviato " + "Destinatario: "+
                            messaggio.dest+" - Contenuto: "+ messaggio.txt);
                    //Dopo l'invio di ogni messaggio, il thread fa una pausa
                    //di 0,2 s
                    Thread.sleep(200);
                }
                catch(DestinatarioPieno | RemoteException e) {
                    System.err.println("Destinatario " + dest + " pieno");
                }
            }
        }
        catch (InterruptedException e) { // Se viene interrotto durante
            e.printStackTrace();    //la pausa sleep(200)
        }

    }

}
