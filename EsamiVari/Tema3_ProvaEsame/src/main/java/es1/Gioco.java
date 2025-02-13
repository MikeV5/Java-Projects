package es1;

import java.util.Random;

public class Gioco {
    private Random rand = new Random();
    private int chiEdiTurno; // a chi tocca dei due giocatori
    private boolean finito;
    private int chiHaVinto;
    public Gioco(int t) {
        chiEdiTurno = t;
        chiHaVinto=-99;
        finito=false;
    }
    public synchronized void gioca(int id, String mossa) {

        // effetto della mossa
        System.out.println("Gioco: giocatore "+id+" ha giocato");
        if (rand.nextInt(10)>8){
            finito=true;
            chiHaVinto=id;
        }
        chiEdiTurno = 1-chiEdiTurno; // adesso tocca all'altro
        System.out.println("Gioco: tocca a giocatore "+ chiEdiTurno);
    }

    public synchronized int aChiTocca() {
        return chiEdiTurno;
    }

    public synchronized boolean partitaFinita() {
        return finito;
    }

    public synchronized int vincitore() {
        return chiHaVinto;
    }
}


