package es1;
import es1.common.ProduttoreMsgInterface;
import es1.eccezioni.DestinatarioPieno;

import java.util.Random;
public class Produttore extends Thread {
    private ProduttoreMsgInterface gestoreProd;
    private Random randomConsumatore;
    public Produttore(ProduttoreMsgInterface g) {
        this.randomConsumatore = new Random();
        this.gestoreProd = g;
    }
    public void run() {
        try {
            for (int i=0; i<100; i++) {
                int dest = randomConsumatore.nextInt(Prova.maxCons);
                Msg tmp = new Msg(dest, "Mess"+i);
                try {
                    gestoreProd.send(tmp);
                    System.out.println("Inviato " + "Destinatario: "+
                            tmp.dest+" - Contenuto: "+ tmp.txt);
                    Thread.sleep(200);

                } catch(DestinatarioPieno e) {
                    System.err.println("Destinatario " + e.dest + " pieno");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


