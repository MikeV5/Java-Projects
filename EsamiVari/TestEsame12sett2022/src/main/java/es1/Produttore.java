package es1;

import java.util.Random;
public class Produttore extends Thread {
    //Rappresenta il gestore dei messaggi a cui il produttore invierà i messaggi
    private ProduttoreMsgInterface gestore;
    //Per  casualmente il destinatario dei messaggi
    private Random randomConsumatore;

    public Produttore(ProduttoreMsgInterface gestore) {
        randomConsumatore= new Random();
        this.gestore = gestore;
    }

    @Override
    public void run() {
        try {
            for (int i=0; i<100; i++) { //Ciclo per generare 100 messaggi da inviare
                //Viene generato casualmente un destinatario
                int dest = randomConsumatore.nextInt(Prova.maxCons);
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
        catch (InterruptedException e) { // Se viene interrotto durante la pausa sleep(200)
            e.printStackTrace();
        }
    }
}


