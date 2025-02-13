package esercizio4;

public class Prova {
    final static int maxThreads = 3;
    final static int dim = 10;

    public static void main(String[] args) throws InterruptedException {
        Contenitore c = new ContenitoreImpl(dim);
        for (int i = 0; i < maxThreads; i++) {
            UtenteContenitore u = new UtenteContenitore(i+1,c);
            u.start();
            Thread.sleep(1000);
        }
    }
}
