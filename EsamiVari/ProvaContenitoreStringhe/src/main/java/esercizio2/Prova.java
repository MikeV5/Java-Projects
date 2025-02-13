package esercizio2;


public class Prova {
    final static int dim = 10;
    static final int numThreads = 3;
    public static void main(String[] args) throws InterruptedException {
        Contenitore c = new ContenitoreImpl(dim);
        for (int i = 0; i < numThreads; i++) {
            UtenteContenitore u = new UtenteContenitore(i+1,c);
            u.start();
            Thread.sleep(1000);
        }
    }
}
