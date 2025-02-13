package esercizio3;
import esercizio1.NoStalliLiberi;
import esercizio1.PianoInesistente;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class AutomobilistaRMI extends Thread{
    private int id;
    private GestioneParcheggioRMI gp;

    public AutomobilistaRMI(int id, GestioneParcheggioRMI gp) {
        this.id = id;
        this.gp = gp;
    }

    public static void main(String[] args) throws RemoteException, NotBoundException, InterruptedException {
        Registry r = LocateRegistry.getRegistry();
        GestioneParcheggioRMI stub =
                (GestioneParcheggioRMI) r.lookup("GParcheggio");
        for (int i = 0; i < 20; i++) {
            AutomobilistaRMI a = new AutomobilistaRMI(i+1,stub);
            a.start();
            Thread.sleep(500);
        }
    }

    public void run(){
        try {
            System.out.println("Sono " + id + " provo a entrare");
            gp.ingresso(); //Richiede l'ingresso al parcheggio
            System.out.println("Sono " + id + " entrato");
            int i = 0; //Rappresenta il piano corrente (parte dal piano 0)
            while (true) {
                //Gestire l'operazione di parcheggio
                try {
                    System.out.println("Sono " + id + " parcheggio a piano " + i);
                    gp.parcheggia(i); //Effettua il parcheggio al piano corrente
                    System.out.println("Sono " + id + " parcheggiato a piano " + i);
                    break; //Esce dal ciclo while perché il parcheggio è riuscito
                } catch (NoStalliLiberi | PianoInesistente e) {
                    if (e instanceof NoStalliLiberi) {
                        System.err.println("Sono " + id + " piano " + i + " pieno");
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











        /*
        String autom = "Autom: "+id;
        int nPiano = 0;
        try {
            System.out.println(autom+" provo ad entrare nel parcheggio...");
            gp.ingresso();
            System.out.println(autom+" entrato");
            Thread.sleep(1000);
            while (true) {
                try {
                    System.out.println(autom + " provo a parcheggiare nel piano: " + nPiano);
                    gp.parcheggia(nPiano);
                    System.out.println(autom + " parcheggiato nel piano: " + nPiano);
                    break;
                } catch (PianoInesistente | NoStalliLiberi e) {
                    if (e instanceof NoStalliLiberi) {
                        System.err.println(autom + " - Non ci sono stalli liberi.");
                        Thread.sleep(1000);
                        nPiano++;
                    } else nPiano = 0;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        //Simulazione tempo nel parcheggio
        try {
            Thread.sleep(5000);
            System.out.println(autom+" provo lasciare il piano... "+ nPiano);
            gp.partenza(nPiano);
            System.out.println(autom+" lasciato il posto del piano: "+nPiano);
            Thread.sleep(1000);

            System.out.println(autom+" provo lasciare il parcheggio...");
            gp.uscita();
            System.out.println(autom+" lasciato il parcheggio.");
            Thread.sleep(1000);
        } catch (InterruptedException | PianoInesistente e) {
            e.printStackTrace();
        }


         */
    }
}
