package esercizio3;

import esercizio1.Inesistente;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Random;

public class UtenteContenitore extends Thread{

    private int id;
    private Contenitore c;
    public UtenteContenitore(int id, Contenitore c) {
        this.id = id;
        this.c = c;
    }

    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry r = LocateRegistry.getRegistry();
        Contenitore c = (Contenitore) r.lookup("Contenitore");
        UtenteContenitore u = new UtenteContenitore(Integer.parseInt(args[0]),c);
        u.start();
    }
//IMPLEMENTAZIONE CON PROBABILITA'
    public void run(){

        Random r = new Random();
        double prob;
        String val;
        int posR;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
           e.printStackTrace();
        }
        //System.out.println("Stringa  inesistente.");
            for (int i = 0; i < 15; i++) {
                prob = Math.random();
                val = "String" + i;
                posR = r.nextInt(10);
                if(prob < 0.7){ //70% - tra 0 e 0.7
                    int nInsert = 0;
                    try {
                        nInsert = c.inserisci(val);
                        System.out.println("Utente: "+id+" - Stringa inserita: "+ val + " - Num inserimento: "+ nInsert);
                        Thread.sleep(2000);
                    } catch (InterruptedException | RemoteException e) {
                        System.out.println("Errore.");
                    }

                } else if (prob < 0.9) { //20% - tra 0.7 e 0.9
                    String s = null;
                    try {
                        s = c.recupera(posR);
                        System.out.println("Utente: "+id+" - Stringa recuperata: "+ s);
                        Thread.sleep(2000);
                    } catch (Inesistente | RemoteException | InterruptedException e) {
                        if(e instanceof Inesistente)
                            System.out.println("Stringa inesistente.");
                    }

                }else{ // 10% tra 0.9 e 1
                    try {
                    c.cancella(posR);
                    System.out.println("Utente: "+id+" - Stringa in pos: "+ i +" cancellata.");
                    } catch (Inesistente | RemoteException e) {
                        if(e instanceof Inesistente)
                            System.out.println("Stringa inesistente.");
                    }
                }
            }


    }




/* IMPLEMTAZIONE CON LO SWITCH
    public void run(){

        Random r = new Random();
        int scelta;
        String val;
        int pos = r.nextInt(9);
        try {
            for (int i = 0; i < 15; i++) {
                scelta = r.nextInt(3);
                val = "String" + i;
                switch (scelta) {
                    case 0:
                        int nInsert = c.inserisci(val);
                        System.out.println("Utente: "+id+" - Stringa inserita: "+ val + " - Num inserimento: "+ nInsert);
                        break;
                    case 1:
                        String s = c.recupera(pos);
                        System.out.println("Utente: "+id+" - Stringa recuperata: "+ s);
                        break;
                    case 2:
                        c.cancella(pos);
                        System.out.println("Utente: "+id+" - Stringa in pos: "+ i +" cancellata.");
                        break;
                }
                Thread.sleep(2000);
            }
        } catch (InterruptedException | Inesistente e) {
            System.out.println("Stringa in pos: "+pos+" inesistente.");
        }
    }

 */
}
