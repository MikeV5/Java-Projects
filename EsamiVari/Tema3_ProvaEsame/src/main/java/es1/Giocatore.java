package es1;

public class Giocatore extends Thread {
    int mioId;
    private Gioco ilGioco;

    public Giocatore(int id, Gioco g) {
        mioId=id;
        ilGioco=g;
        System.out.println("Giocatore " + mioId + ": creato");
        this.start();
    }

    public void run() {
        boolean finito=false;
        while(!finito) {
            while(ilGioco.aChiTocca() != mioId && !ilGioco.partitaFinita()) ; // busy loop
            if (ilGioco.partitaFinita()) {
                if (ilGioco.vincitore()==mioId)
                    System.out.println("Giocatore "+mioId+
                            ": Ho vinto!");
                else
                    System.out.println("Giocatore "+mioId+
                            ": Ho perso!");
                finito=true;
                break;
            }
            else {
                try {Thread.sleep(200); } // pensa la mossa
                catch (InterruptedException e) { }
                ilGioco.gioca(mioId, "la mia mossa");
            }
        }
    }
}
