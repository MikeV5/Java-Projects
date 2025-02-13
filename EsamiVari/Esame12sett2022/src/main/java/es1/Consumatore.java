package es1;

import es1.common.ConsumatoreMsgInterface;
import es1.eccezioni.ConsumatoreSconosciuto;
import es1.eccezioni.GiaRegistrato;

public class Consumatore extends Thread {
    private int id;
    private ConsumatoreMsgInterface gestoreConsumatore;
    public Consumatore(int n, ConsumatoreMsgInterface g) {
        this.id = n;
        this.gestoreConsumatore = g;
    }
    public void run() {
        try {
            gestoreConsumatore.signUp(id);
            while(true) {
                Thread.sleep(2000);
                Msg tmp = gestoreConsumatore.receive(id);
                System.out.println("C" + id + " - Ricevuto: " +
                        "Destinatario: " + tmp.dest + " - Contenuto: " + tmp.txt);
            }
        }
        catch(InterruptedException | GiaRegistrato | ConsumatoreSconosciuto e) {
            e.printStackTrace();
        }
    }
}


