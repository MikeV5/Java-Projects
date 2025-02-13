package es3;

import es1.PianoInesistente;
import es1.StalliNonLiberi;

import java.rmi.RemoteException;

public class Automobilista extends Thread{
    private int id;
    private GestioneParcheggioRMI gp;
    private static int cont=0;
    public Automobilista(int id, GestioneParcheggioRMI gp){
        this.id=id;
        this.gp=gp;
    }
    public void run() {
        try {
            System.out.println("Sono " + id + " provo a entrare");
            gp.ingresso(); //Richiede l'ingresso al parcheggio
            System.out.println("Sono " + id + " entrato");
            int i = 0; //Rappresenta il piano corrente (parte dal piano 0)

            while (true) {
                //Gestire l'operazione di parcheggio
                try {
                    System.out.println("Sono " + id + " parcheggio a piano " + i);
                    gp.parcheggia(i);  //Effettua l'operazione di parcheggio al piano corrente
                    System.out.println("Sono " + id + " parcheggiato a piano " + i);
                    break; //Esce dal ciclo while perché il parcheggio è riuscito
                } catch (StalliNonLiberi | PianoInesistente e) {
                    if (e instanceof StalliNonLiberi) {
                        System.out.println("Sono " + id + " piano " + i + " pieno");
                        Thread.sleep(500);
                        i++; //Se pieno passa al piano successivo
                    } else i = 0;  //reimposta i a 0 per tornare al piano iniziale
                }
            }
            // Simula il tempo di permanenza nel parcheggio (da 6 a 16 secondi)
            try {
                Thread.sleep(6000 + (long)(Math.random()*10000));
                gp.partenza(i); //Effettua l'operazione di partenza dal piano corrente
                System.out.println("Sono " +id+ " lasciato piano " +i);
                Thread.sleep(1000); //Mette in pausa il thread per 1 secondo.
            }
            catch (PianoInesistente e) {e.printStackTrace();}
            gp.uscita();  //Effettua l'operazione di uscita dal parcheggio
            System.out.println("Sono " +id+ " uscito");
        } catch (InterruptedException | RemoteException e) {e.printStackTrace();}
    }
}
