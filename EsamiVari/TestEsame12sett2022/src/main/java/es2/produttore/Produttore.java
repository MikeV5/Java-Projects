package es2.produttore;

import es1.DestinatarioPieno;
import es2.common.Msg;
import es2.common.ProduttoreMsgInterfaceRMI;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Random;

public class Produttore extends Thread {
    private final int maxCons = 5;
    //Rappresenta il gestore dei messaggi a cui il produttore invierà i messaggi
    private ProduttoreMsgInterfaceRMI gestore;
    //Per  casualmente il destinatario dei messaggi
    private Random randomConsumatore;
    public Produttore(ProduttoreMsgInterfaceRMI gestore) {
        randomConsumatore= new Random();
        this.gestore = gestore;
    }
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry r = LocateRegistry.getRegistry();
        //Il metodo lookup() viene chiamato sull'oggetto Registry
        // e restituisce l'oggetto remoto corrispondente al nome specificato
        ProduttoreMsgInterfaceRMI prodInter = (ProduttoreMsgInterfaceRMI) r.lookup("GestoreMessaggi");
        Produttore prod = new Produttore(prodInter);
        prod.start();
    }

    @Override
    public void run() {
        try {
            for (int i=0; i<100; i++) { //Ciclo per generare 100 messaggi da inviare
                //Viene generato casualmente un destinatario
                int dest = randomConsumatore.nextInt(maxCons);
                //Viene creato un Messaggio con il destinatario e il testo del messaggio
                Msg messaggio = new Msg(dest, "Mess"+i);

                try {
                    //Il produttore cerca di inviare il messaggio al gestore dei messaggi
                    gestore.send(messaggio);
                    //Il messaggio è stato inviato correttamente al destinatario
                    System.out.println("Inviato " + "Destinatario: "+
                            messaggio.dest+" - Contenuto: "+ messaggio.txt);
                    //Dopo l'invio di ogni messaggio, il thread fa una pausa di 0,2 s
                    Thread.sleep(200);
                }
                catch(DestinatarioPieno e) {
                    System.err.println("Destinatario " + e.dest + " pieno");
                }
            }
        }
        catch (InterruptedException | RemoteException e) { // Se viene interrotto durante la pausa sleep(200)
            e.printStackTrace();
        }
    }
}


