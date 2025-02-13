package esercizio1;

import java.util.Random;

public class Produttore extends Thread{
    //int randomDestCons;
    private Random randomConsumatore;

    ProduttoreMsgInterface gestore;

    public Produttore(ProduttoreMsgInterface gestore) {
        this.gestore = gestore;
        randomConsumatore = new Random();
    }
    public void run(){
        try {
            for (int i=0; i<100; i++) { //Ciclo per generare 100 messaggi
                //da inviare
                //Viene generato casualmente un destinatario
                int dest = randomConsumatore.nextInt(Prova.numCons);
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
                catch(DestinatarioPieno e) {
                    System.err.println("Destinatario " + dest + " pieno");
                }
            }
        }
        catch (InterruptedException e) { // Se viene interrotto durante
            e.printStackTrace();    //la pausa sleep(200)
        }

    }

}
