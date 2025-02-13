package esercizio2;

import esercizio1.GestioneParcheggio;
import esercizio1.NoStalliLiberi;
import esercizio1.PianoInesistente;

import java.util.Random;

public class Automobilista extends Thread {
    private int id;
    private GestioneParcheggio gp;

    public Automobilista(int id, GestioneParcheggio gp) {
        this.id = id;
        this.gp = gp;
    }

    public void run() {
        Random r = new Random();
        int piano = 0;
        System.out.println("Autom: " + id + " prova a entrare");
        gp.ingresso();
        System.out.println("Autom: " + id + " è entrato");
        try {
            while (true) {
                try {
                    System.out.println("Autom: " + id + " prova a parcheggiare nel piano: " + piano);
                    gp.parcheggia(piano);
                    System.out.println("Autom: " + id + " ha parcheggiato nel piano: " + piano);
                    break;
                } catch (NoStalliLiberi e) {
                    System.out.println("Autom: " + id + " piano " + piano + " pieno");
                    piano++;
                }
            }
        } catch (PianoInesistente e) {
            System.out.println("Autom: " + id + " piano " + piano + " pieno");
        }

        try {
            int tempoRandom = r.nextInt(16) + 10;
            Thread.sleep(tempoRandom * 1000); //Da 5 a 9 s
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            System.out.println("Autom: " + id + " prova a partire " +
                    "dal piano: " + piano);
            gp.partenza(piano);
            System.out.println("Autom: " + id + " ha lasciato il piano: " + piano);
            //Thread.sleep(1000);

            System.out.println("Autom: " + id + " prova ad uscire dal piano: " + piano);
            gp.uscita();
            System.out.println("Autom: " + id + " è uscito dal piano: " + piano);
            Thread.sleep(1000);
        } catch (InterruptedException | PianoInesistente e) {
            e.printStackTrace();
        }

    }
}
