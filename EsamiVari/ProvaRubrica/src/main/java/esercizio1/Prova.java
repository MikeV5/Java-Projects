package esercizio1;

public class Prova {
    final static int numThreads = 10;
    public static void main(String[] args) throws InterruptedException {
        RubricaInterface rub = new Rubrica();
        for (int i = 0; i < numThreads; i++) {
            UtenteRubrica u = new UtenteRubrica(i+1,rub);
            u.start();
            Thread.sleep(500);
        }
    }
}
