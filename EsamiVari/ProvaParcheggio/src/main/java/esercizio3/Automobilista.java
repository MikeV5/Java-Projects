package esercizio3;

import esercizio1.NoStalliLiberi;
import esercizio1.PianoInesistente;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Random;

public class Automobilista extends Thread {
    private int id;
    private GestioneParcheggioRMI gp;

    public Automobilista(int id, GestioneParcheggioRMI gp) {
        this.id = id;
        this.gp = gp;
    }

    public static void main(String[] args) throws RemoteException, NotBoundException, InterruptedException {
        int numAuto = 20;
        Registry r = LocateRegistry.getRegistry();
        GestioneParcheggioRMI stub =
                (GestioneParcheggioRMI) r.lookup("GParcheggio");
        for (int i = 0; i < numAuto; i++) {
            Automobilista a = new Automobilista(i+1,stub);
            a.start();
            Thread.sleep(500);
        }
    }
    public void run() {
        try {
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
            } catch (PianoInesistente | RemoteException e) {
                System.err.println("Autom: " + id +" piano inesistente.");
            }

            try {
                int tempoRandom = r.nextInt(16) + 10;
                Thread.sleep(tempoRandom * 1000); //Da 10 a 16 s
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
            } catch (InterruptedException | PianoInesistente | RemoteException e) {
                System.err.println("Autom: " + id +" piano inesistente.");
                e.printStackTrace();
            }
        } catch (RemoteException e) {
           e.printStackTrace();
        }
    }
}
