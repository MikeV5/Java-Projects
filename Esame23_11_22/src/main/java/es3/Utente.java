package es3;

import es1.Contenitore;
import es1.Inesistente;
import es1.Pieno;

public class Utente extends Thread{
    private int id; //identificatore
    private Contenitore c;

    public Utente(int n, Contenitore c) {
        id = n;
        this.c = c;

    }

    public void run() {
        try {
            for (int i = 1; i<10;i++) {
                double op = Math.random();
                if (op < 0.5) {
                    int val = id*10+ i;
                    c.inserisci(Integer.toString(val));
                    System.out.println("Utente "+id+" - Inserito = "+val);
                }
                else if (op < 0.8) {
                    int n = (int) (Math.random() * 10) + 1;
                    String s = c.recupera(n);
                    System.out.println("Utente " + id + " - Recuperato = " + s);
                }
                else {
                    int n = (int) (Math.random() * 10) + 1;
                    c.cancella(n);
                    System.out.println("Utente " + id + " - Cancellato elemento " + n);
                }
                Thread.sleep(1000);
            }
        }
        catch(InterruptedException e) {
            e.printStackTrace();
        }
        catch (Pieno e) {
            System.out.println("Utente " + id + " - ma il contenitore è pieno");
        }catch(Inesistente e) {
            System.out.println("Utente " + id + " - Elemento non esiste");
        }
    }
}
