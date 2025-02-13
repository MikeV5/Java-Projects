package org.example;

public class Utente extends Thread{

    private int id;
    static int cont=0;
    private Contenitore c;
    public Utente(int id, Contenitore c){
        this.id=id;
        this.c=c;
    }

    public void run() {
        try {
            for (int i = 1; i<10;i++) { //Il thread utente esegue un ciclo 9 volte
                double op = Math.random(); //numero casuale compreso tra 0 e 1
                if (op < 0.5) { //op è inferiore a 0.5. Probabilità di entrare in questo blocco è del 50% (0.5)
                    int val = id*10+ i;
                    c.inserisci(val);
                    System.out.println(cont++ +" Utente "+id+" - Inserito = "+val);
                }
                else if (op < 0.8) { //op è compreso tra 0.5 e 0.8. Probabilità di entrare in questo blocco è del 30% (0.8 - 0.5 = 0.3)
                    int val = c.somma();
                    System.out.println(cont++ +" Utente "+id+" - Somma = "+val);
                }
                else { //op è maggiore o uguale a 0.8. Probabilità di entrare in questo blocco è del 20% (1 - 0.8 = 0.2)
                    c.cancella();
                    System.err.println(cont++ + " Utente "+id+" - Cancello");
                }
                Thread.sleep(1000);
            }
        }
        catch(InterruptedException | SommaNonCalcolata e) {e.printStackTrace();}
    }
}
