package esercizio1;

import java.util.Random;

public class UtenteRubrica extends Thread{

    private int id;
    private RubricaInterface rub;
    public UtenteRubrica(int id, RubricaInterface rub) {
        this.id = id;
        this.rub = rub;
    }

    public void run(){

        try {
            Random r = new Random();
            String nomeRub = "Utente:"+id;

            long n = r.nextLong(100000000L)+300000000L;
            String numR = "+39 3"+String.valueOf(n);

            System.out.println(nomeRub + " provo a inserire un numero.");
            rub.aggiungiNumero(String.valueOf(id), String.valueOf(numR));
            System.out.println(nomeRub + " ho inserito: "+id+" "+numR);
            Thread.sleep(1000);

            int nomeR = r.nextInt(Prova.numThreads)+1;
            System.out.println(nomeRub + " provo a cercare il numero di "+nomeR);
            String numTrovato = rub.trova(String.valueOf(nomeR));
            System.out.println(nomeRub + " trovato numero: "+ numTrovato
                    +"di "+nomeR);
            Thread.sleep(1000);

        } catch (GiaPresente | InterruptedException | Inesistente e) {
            if(e instanceof GiaPresente)
                System.err.println("Nome già presente in rubrica.");
            else if (e instanceof Inesistente) {
                System.err.println("Nome inesistente.");
            }
            e.printStackTrace();
        }
    }
}
