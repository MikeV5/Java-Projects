package esercizio2;
import esercizio1.Contenitore;

public class Prova {
    static final int numThreads = 5;
    static final int dim = 5;
    public static void main(String[] args) throws InterruptedException {
        Contenitore c = new ContenitoreImpl(dim);
        //for (int i = 0; i < numThreads; i++) {
            UtenteContenitore u = new UtenteContenitore(1,c);
            u.start();
            Thread.sleep(6000);
            UtenteContenitore u2 = new UtenteContenitore(2,c);
            u2.start();
       // }

    }
}
